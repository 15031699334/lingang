package com.boot.gang.service.Impl;

import com.boot.gang.activemqTool.SendMessageTool;
import com.boot.gang.entity.*;
import com.boot.gang.mapper.*;
import com.boot.gang.util.StringUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.jms.JMSException;
import java.util.*;

/**
 * common操作方法
 *
 * @author shengyong
 * 2020/1/6 11:30
 */
@Service
public class MessageService {

    private static Logger logger = LogManager.getLogger(MessageService.class);
    @Autowired
    private SendMessageTool sendMessageTool;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private MessageUserAdminMapper messageUserAdminMapper;
    @Autowired
    private MessageAdminUnreadMapper messageAdminUnreadMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminMapper adminMapper;


    @Value("${defaultCSId}")
    private String defaultCSId;

    public void save(Message message) {
        try {
            int i = this.messageMapper.insertSelective(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建并发送消息
     * @param messageContent 消息内容
     * @param userId 发送的用户id
     * @param adminPic 接收者头像
     * @param adminName 消息接收者姓名
     * @param adminNo 消息接收者
     * @return 发送后的消息
     * @throws JMSException 发送的异常
     */
    public Message sendMessage(String messageContent, String userId, String adminPic, String adminNo, String adminName, Integer messageType) throws JMSException {
        Message message = new Message();
        User user = userMapper.selectByPrimaryKey(userId);
        Admin admin = null;
//        logger.info("adminNo: " + adminNo + ", adminPic : " + adminPic + ", adminName : " + adminName);
        List<MessageUserAdmin> muas = messageUserAdminMapper.getList("and um_user_id = '" + userId + "' and um_status = 1 order by um_last_time desc");
        if (StringUtil.isNullOrEmpty(adminNo)) {    // 未指定客服
            if (muas == null || muas.isEmpty()) {   // 以前没聊过 没有专属客服
                // 获取admin信息
                List<Admin> aList = adminMapper.getList("and receiveMessage = 1 and c_hide = 's' order by role desc");
                if (aList == null || aList.isEmpty()) {     // 所有人都不在线 发送给admin
                    admin = adminMapper.selectByPrimaryKey(defaultCSId);
                }else {     // 有人在线  随机给其中一个人发送 只有第一次会走这里 相当于专属客服
                    // 随机分配的admin   (Math.random() * (max - min) + min) // [0, aList.size())
                    int ran2 = (int) (Math.random() * aList.size());
                    admin = aList.get(ran2);
                }
                // 添加 MessageUserAdmin
                MessageUserAdmin messageUserAdmin = new MessageUserAdmin("MUA" + System.nanoTime(), admin.getcId(), new Date(), new Date(), userId);
                messageUserAdminMapper.insertSelective(messageUserAdmin);
            }else {     // 有专属客服
                admin = adminMapper.selectByPrimaryKey(muas.get(0).getUmAdminId());
            }
        }else {     // 指定了客服 传入了adminNo
            if (muas != null && !muas.isEmpty()) {
                MessageUserAdmin messageUserAdmin = muas.get(0);
                Admin adminSel = adminMapper.selectByPrimaryKey(messageUserAdmin.getUmAdminId());
                logger.info("指定了客服号: " + adminNo + ",  原绑定的客服号:  " + adminSel.getAdminno());
                if (!adminSel.getAdminno().equals(adminNo)){   //不相同 替换
                    List<Admin> admins = adminMapper.listCSByAdminNo(adminNo);
                    messageUserAdmin.setUmAdminId(admins.get(0).getcId());
                    messageUserAdminMapper.updateByPrimaryKeySelective(messageUserAdmin);
                    logger.info("修改完成");
                }
            }
        }
        List<MessageAdminUnread> maus = messageAdminUnreadMapper.getList("and au_user_id = '" + userId + "' and au_admin_no = '" + (null == adminNo ? admin == null ? "" : admin.getAdminno() : adminNo) + "'");
        if (!CollectionUtils.isEmpty(maus)) {   // 删除
            maus.forEach(mau ->{
                   messageAdminUnreadMapper.deleteByPrimaryKey(mau.getAuId());
            });
        }
        message.setAdminno(null == adminNo ? admin == null ? "" : admin.getAdminno() : adminNo);
        message.setAdminname(null == adminName || adminName.equals("") ? admin == null ? "" : admin.getAdminname() : adminName);
        message.setAdminpic(null == adminPic ? admin == null ? "" : admin.getAdminpic() : adminPic);
        // 0为 客户向客服发送
        message.setState(0);
        //消息内容
        message.setSummary(messageContent);
        message.setUserid(userId);
        message.setUsername(user.getcUsername());
        message.setUserpic(null == user.getcLogo() ? "" : user.getcLogo());

        message.setMessageType(messageType == null? 0:messageType);
//        message.setUserName(user.getRealName());
//        message.setUserPic(user.getHeadPic());
        //调用activemq工具发送
        sendMessageTool.sendMessage(message);
        return message;
    }

    /**
     * 查看当天的Message消息
     * @param userId
     * @param adminNo
     * @return
     */
    public List<Message> listMessageOnDataBaseToday(String userId, String adminNo) {
        adminNo = getAdminNo(userId, adminNo);
        return messageMapper.getAllToday(userId, adminNo);
    }

    /**
     * 从数据库里查看Message消息
     * @param pageNo
     * @param pageSize
     * @param userId
     * @param adminNo
     * @return
     */
    public Map<String, Object> listMessageOnDataBase(int pageNo, int pageSize, String userId, String adminNo) {
        Map<String, Object> map = new HashMap<>();
        logger.info("service :  页码: " + pageNo + " , 数量: " + pageSize);
        adminNo = getAdminNo(userId, adminNo);
        List<Message> messages = messageMapper.getPageAllNotToday(userId, adminNo, (pageNo - 1) * pageSize, pageSize);
        Collections.reverse(messages);
        map.put("data", messages);
//        logger.info( (int) Math.ceil(messageMapper.getCountNotToday(userId))/(double) pageSize);
        map.put("totalPages", (int) Math.ceil(messageMapper.getCountNotToday(userId, adminNo)/(double) pageSize));
        return map;
    }


    //        内部方法         *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
    public String getAdminNo(String userId, String adminNo){
        if (StringUtil.isNullOrEmpty(adminNo)){
            List<MessageUserAdmin> muas = messageUserAdminMapper.getList("and um_user_id = '" + userId + "' and um_status = 1 order by um_last_time desc");
            if (muas == null || muas.isEmpty()) {
                adminNo = null;
            }else {
                adminNo = adminMapper.selectByPrimaryKey(muas.get(0).getUmAdminId()).getAdminno();
            }
        }
        return adminNo;
    }
}

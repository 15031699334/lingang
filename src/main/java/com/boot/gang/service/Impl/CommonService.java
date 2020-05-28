package com.boot.gang.service.Impl;

import com.boot.gang.activemqTool.SendMessageTool;
import com.boot.gang.entity.Message;
import com.boot.gang.entity.User;
import com.boot.gang.mapper.MessageMapper;
import com.boot.gang.mapper.UserMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import java.util.*;
import java.util.function.Predicate;

/**
 * common操作方法
 *
 * @author shengyong
 * 2020/1/6 11:30
 */
@Service
public class CommonService {

    private static Logger logger = LogManager.getLogger(CommonService.class);
    @Autowired
    private SendMessageTool sendMessageTool;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private UserMapper userMapper;

    public void save(Message message) {
        try {
            int i = this.messageMapper.insertSelective(message);
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建并发送消息
     * @param messageContent 消息内容
     * @param userId 发送的用户id
     * @param recruitInfoId 招聘信息
     * @param adminName 消息接收者姓名
     * @param adminNo 消息接收者
     * @return 发送后的消息
     * @throws JMSException 发送的异常
     */
    public Message sendMessage(String messageContent, String userId, Integer recruitInfoId, String adminNo, String adminName, Integer messageType) throws JMSException {
        Message message = new Message();
        // 招聘的冗余信息
        User user = userMapper.selectByPrimaryKey(userId);
        message.setAdminno("11110");
        message.setAdminname("管理员");
        message.setAdminpic("http://lingangsteel.com/lingang/upload/images/986908100106000.jpg");
//        if (recruitInfoId == null) {
//            message.setRecruitInfoId(0);
//        } else {
//            message.setRecruitInfoId(recruitInfoId);
//        }
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
     * @param recruitInfoId
     * @return
     */
    public List<Message> listMessageOnDataBaseToday(String userId, Integer recruitInfoId) {
        return messageMapper.getAllToday(userId);
    }

    /**
     * 从数据库里查看Message消息
     * @param pageNo
     * @param pageSize
     * @param userId
     * @param recruitInfoId
     * @return
     */
    public Map<String, Object> listMessageOnDataBase(int pageNo, int pageSize, String userId, Integer recruitInfoId) {
        Map<String, Object> map = new HashMap<>();
        logger.info("service :  页码: " + pageNo + " , 数量: " + pageSize);
        List<Message> messages = messageMapper.getPageAllNotToday(userId, (pageNo - 1) * pageSize, pageSize);
        Collections.reverse(messages);
        map.put("data", messages);
//        logger.info( (int) Math.ceil(messageMapper.getCountNotToday(userId))/(double) pageSize);
        map.put("totalPages", (int) Math.ceil(messageMapper.getCountNotToday(userId)/(double) pageSize));
        return map;
    }
}

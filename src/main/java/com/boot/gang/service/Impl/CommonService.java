package com.boot.gang.service.Impl;

import com.boot.gang.activemqTool.SendMessageTool;
import com.boot.gang.entity.Message;
import com.boot.gang.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import java.util.List;

/**
 * common操作方法
 *
 * @author shengyong
 * 2020/1/6 11:30
 */
@Service
public class CommonService {

    @Autowired
    private SendMessageTool sendMessageTool;
    @Autowired
    private MessageMapper messageMapper;

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
    public Message sendMessage(String messageContent, String userId, Integer recruitInfoId, String adminNo, String adminName) throws JMSException {
        Message message = new Message();
        // 招聘的冗余信息

        message.setAdminno(adminNo);
        message.setAdminname(adminName);
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
//        message.setUserName(user.getRealName());
//        message.setUserPic(user.getHeadPic());
        //调用activemq工具发送
        sendMessageTool.sendMessage(message);
        return message;
    }


    public List<Message> findAll(String userId) {
        return messageMapper.getAll(userId);
    }
}

package com.boot.gang.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.ArrayList;
import java.util.List;

/**
 * @desciption:
 * @author:shengyong
 * @Date:2019/12/30 16:39
 */
@Component
public class Consumer {
    private List<TextMessage> list = new ArrayList<>();

//    @JmsListener(destination = "${sendMessageQueue}", containerFactory = "jmsQueueListener")   //监听队列里面的消息
//    public void receive(String msg) {
//        System.out.println("监听器收到msg:" + msg);
//    }

//    @JmsListener(destination = "${sendMessageQueue}", containerFactory = "jmsQueueListener")   //监听队列里面的消息
//    public void receiveQueue(final TextMessage text, Session session)
//            throws JMSException {
//        try {
//
//            System.out.println("Consumer收到的报文为:" + text.getText() + "---------------" + session.getAcknowledgeMode());
////            text.acknowledge();// 使用手动签收模式，需要手动的调用，如果不在catch中调用session.recover()消息只会在重启服务后重发
//            list.add(text);
//        } catch (Exception e) {
//            session.recover();// 此不可省略 重发信息使用
//        }
//    }
}
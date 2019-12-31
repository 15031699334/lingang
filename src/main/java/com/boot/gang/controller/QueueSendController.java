package com.boot.gang.controller;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.*;

@RestController
public class QueueSendController {

    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    Queue queue;
    @Autowired
    Topic topic;
    /*
     * 发送 队列消息
     */
  /*  @RequestMapping("/sendQueue")
    public String sendQueue() {
        String message = UUID.randomUUID().toString();
        // 指定消息发送的目的地及内容
        this.jmsMessagingTemplate.convertAndSend(this.queue, message);
        return "消息发送成功！message=" + message;
    }


    *//*
     * 发送 主题消息
     *//*
    @RequestMapping("/sendTopic")
    public String sendTopic() {
        String message = UUID.randomUUID().toString();
        // 指定消息发送的目的地及内容
        this.jmsMessagingTemplate.convertAndSend(this.topic, message);
        return "消息发送成功！message=" + message;
    }
*/

    //定义ActivMQ的连接地址
    private static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";
    //定义发送消息的队列名称
    private static final String QUEUE_NAME = "MyMessage";
    //定义发送消息的主题名称
    private static final String TOPIC_NAME = "MyTopicMessage";
    public static void main(String[] args) throws JMSException {
        //创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //打开连接
        connection.start();
        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建队列目标
        Destination destination = session.createQueue(QUEUE_NAME);
        //创建队列目标
//        Destination destination = session.createTopic(TOPIC_NAME);
        //创建一个生产者
        javax.jms.MessageProducer producer = session.createProducer(destination);
        //创建模拟100个消息
        for (int i = 1 ; i <= 100 ; i++){
            TextMessage message = session.createTextMessage("我发送message:" + i);
            //发送消息
            producer.send(message);
            //在本地打印消息
            System.out.println("我现在发的消息是：" + message.getText());
        }
        //关闭连接
        connection.close();
    }







}

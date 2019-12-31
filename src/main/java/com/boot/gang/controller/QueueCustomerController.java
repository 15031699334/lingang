package com.boot.gang.controller;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.*;

@RestController
public class QueueCustomerController {


//    /*
//     * 监听和接收  队列消息
//     */
//    @JmsListener(destination = "queue1")
//    public void readActiveQueue(String message) {
//        System.out.println("接受到1：" + message);
//    }
//    /*
//     * 监听和接收  队列消息
//     */
//    @JmsListener(destination = "queue1")
//    public void readActiveQueue2(String message) {
//        System.out.println("接受到2：" + message);
//    }
//
//    /*
//     * 监听和接收  主题消息1
//     */
//    @JmsListener(destination = "topic1")
//    public void readActiveTopic1(String message) {
//        System.out.println("Customer1接受到：" + message);
//    }
//
//    /*
//     * 监听和接收  主题消息2
//     */
//    @JmsListener(destination = "topic1")
//    public void readActiveTopic2(String message) {
//        System.out.println("Customer2接受到：" + message);
//    }
//



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
        //创建消费者
        javax.jms.MessageConsumer consumer = session.createConsumer(destination);
        //创建消费的监听
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("获取消息：" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}


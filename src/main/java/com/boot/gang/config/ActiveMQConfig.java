package com.boot.gang.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class ActiveMQConfig {

//    public final static String JMS_LISTENER_CONTAINER_FACTORY_QUEUE = "jmsListenerContainerFactoryQueue";
//
//    public final static String JMS_LISTENER_CONTAINER_FACTORY_TOPIC = "jmsListenerContainerFactoryTopic";
//
//    public final static String JMS_QUEUE = "jmsQueue";
//
//    public final static String JMS_TOPIC = "jmsTopic";
//
//
//
//    @Bean(JMS_LISTENER_CONTAINER_FACTORY_TOPIC)
//    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        factory.setPubSubDomain(true);
//        factory.setConnectionFactory(activeMQConnectionFactory);
//        return factory;
//    }
//
//    @Bean(JMS_LISTENER_CONTAINER_FACTORY_QUEUE)
//    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ConnectionFactory activeMQConnectionFactory) {
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        factory.setPubSubDomain(false);
//        factory.setConnectionFactory(activeMQConnectionFactory);
//        return factory;
//    }

    /**
     * 点对点
     */
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("queue1");
    }
    /**
     *
     */

    /**
     * 发布/订阅
     */
    @Bean
    public Topic topic() {
        return new ActiveMQTopic("topic1");
    }
}

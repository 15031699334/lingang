package com.boot.gang.activemq.config.queue;

import com.boot.gang.activemq.config.IQueue;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * @desciption:
 * @author:shengyong
 * @Date:2020/1/3 11:17
 */
@Configuration("sendMessageQueueConfig")
public class SendMessageQueue implements IQueue {
    @Value("${sendMessageQueue}")
    private String queue;


    //注入bean
    @Override
    @Bean("sendMessageQueue")
    public Queue createQueue() {
        return new ActiveMQQueue(queue);
    }

}

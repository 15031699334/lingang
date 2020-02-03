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
@Configuration("saveSendMessageQueueConfig")
public class SaveSendMessageQueue implements IQueue {
    @Value("${saveSendMessageQueue}")
    private String queue;

    @Override
    @Bean("saveSendMessageQueue")
    public Queue createQueue() {
        return new ActiveMQQueue(queue);
    }
}

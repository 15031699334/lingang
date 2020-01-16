package com.boot.gang.activemq.producer;

import com.boot.gang.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Queue;

/**
 * @desciption:
 * @author:shengyong
 * @Date:2019/12/30 16:33
 */
@Component
public class Producer {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void send(Queue queue, Object object) throws JMSException {
        logger.info(queue.getQueueName() + "写入消息:" + JsonUtil.beanToJson(object));
        jmsMessagingTemplate.convertAndSend(queue, object);
    }
}

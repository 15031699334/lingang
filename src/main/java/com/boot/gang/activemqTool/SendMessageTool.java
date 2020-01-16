package com.boot.gang.activemqTool;

import com.boot.gang.activemq.producer.Producer;
import com.boot.gang.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Queue;


/**
 * @desciption:
 * @author:shengyong
 * @Date:2020/1/3 17:02
 */
@Component
public class SendMessageTool {
    @Autowired
    @Qualifier("sendMessageQueue")
    private Queue sendMessageQueue;
    @Autowired
    @Qualifier("saveSendMessageQueue")
    private Queue saveSendMessageQueue;
    @Autowired
    private Producer producer;


    public void sendMessage(Message message) throws JMSException {
        producer.send(sendMessageQueue, message);
        producer.send(saveSendMessageQueue, message);
    }
}

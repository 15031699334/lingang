package com.boot.gang.activemqTool;

import com.boot.gang.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 * @desciption:
 * @author:shengyong
 * @Date:2020/1/3 17:17
 */
@Component
@EnableJms
public class ConsumerListenerTool {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ReceiveTool receiveTool;
    
    @JmsListener(destination = "${replyMessageQueue}", containerFactory = "jmsQueueListener")
    public void receiveQueue(ObjectMessage objectMessage, Session session)
            throws JMSException {
//        logger.info(objectMessage.getJMSDestination() + "监听器读取数据：" + JsonUtil.beanToJson(objectMessage.getObject()));
        try {
        	receiveTool.addMessage(objectMessage);
//            objectMessage.acknowledge();// 使用手动签收模式，需要手动的调用，如果不在catch中调用session.recover()消息只会在重启服务后重发
        } catch (Exception e) {
            session.recover();// 此不可省略 重发信息使用
        }
    }

}

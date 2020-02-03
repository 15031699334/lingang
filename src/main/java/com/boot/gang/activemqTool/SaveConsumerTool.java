package com.boot.gang.activemqTool;

import com.boot.gang.entity.Message;
import com.boot.gang.service.Impl.CommonService;
import com.boot.gang.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import java.util.Date;

/**
 * @desciption:
 * @author:shengyong
 * @Date:2020/1/3 17:17
 */
@Component
public class SaveConsumerTool {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CommonService commonService;
//    @JmsListener(destination = "${saveSendMessageQueue}", containerFactory = "jmsQueueListener")   //监听队列里面的消息
//    public void receive(String msg) {
//        System.out.println("监听器收到msg:" + msg);
//    }

    @JmsListener(destination = "${saveSendMessageQueue}", containerFactory = "jmsQueueListener")
    @JmsListener(destination = "${saveReplyMessageQueue}", containerFactory = "jmsQueueListener")
    public void receiveQueue(ObjectMessage objectMessage, Session session)
            throws JMSException {
        logger.info(objectMessage.getJMSDestination() + "监听器读取数据：" + objectMessage.getObject());
        try {
            Message message = (Message) objectMessage.getObject();
            message.setCreatetime(new Date());
            System.out.println(JsonUtil.objectToJson(message));
            commonService.save(message);
            objectMessage.acknowledge();// 使用手动签收模式，需要手动的调用，如果不在catch中调用session.recover()消息只会在重启服务后重发
        } catch (Exception e) {
            session.recover();// 此不可省略 重发信息使用
        }
    }

}

package com.boot.gang.activemqTool;

import com.boot.gang.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import java.util.*;

/**
 * 将从activemq中取出的消息放入内存中
 * @author  shengyong
 *
 */
@Component
public class ReceiveTool {
	/**
	 * 保存客户消息的map
	 */
	private Map<String, List<ObjectMessage>> map = new HashMap<>();
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    




    
    /**
     * @throws JMSException 
    * @Title: addMessage
    * @Description: 监听器监听到消息时将消息加入消息容器
    * @param @param message    参数
    * @return void    返回类型
    * @throws
     */
    public void addMessage(ObjectMessage objectMessage) throws JMSException {
    	String userId = ((Message) (objectMessage.getObject())).getUserid();
    	this.addMessage(userId, objectMessage);
    }

	
	/**
	 * 
	* @Title: addMessage
	* @Description: 根据客户的id保存消息
	* @param @param userId  发送消息的客户的主键
	* @param @param objectMessage	发送的消息
	* @param @param messageMap    参数	客服的专属消息集合（已做过非空的判定）
	* @return void    返回类型
	* @throws
	 */
	private void addMessage(String userId, ObjectMessage objectMessage) {
		//在客服的专属集合里，获得此人已发送且未处理的消息列表
		List<ObjectMessage> messageList = map.get(userId);
		if(messageList == null) {
			messageList = new ArrayList<>();
			map.put(userId, messageList);
		}
		messageList.add(objectMessage);
	}

	/**
	 * 获得内存中保存的activemq发送的未处理的消息， 获得后即为处理
	 * @param userId
	 * @return
	 * @throws JMSException
	 */
	public List<Message> getMessageOnMemory(String userId) throws JMSException {
		List<ObjectMessage> list = map.get(userId);
		if (list == null) {
			return new ArrayList<>();
		}
		List<Message> messageList = new ArrayList<>();
		for (Iterator<ObjectMessage> ite = list.iterator(); ite.hasNext();) {
			ObjectMessage objectMessage = ite.next();
			Message message = (Message) objectMessage.getObject();
			messageList.add(message);
			ite.remove();
		}
		return messageList;
	}
}

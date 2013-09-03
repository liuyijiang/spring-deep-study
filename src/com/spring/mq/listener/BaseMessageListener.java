package com.spring.mq.listener;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

public class BaseMessageListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		MapMessage m = (MapMessage)message;
		try {
			String mes = m.getString("mess");
			System.out.println("topic收到消息：" + mes);
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}

package com.spring.mq.mess;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.MessageCreator;

public class Mess implements MessageCreator {
    
	public String mess;

	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		this.mess = mess;
	}

	@Override
	public Message createMessage(Session session) throws JMSException {
		MapMessage message = session.createMapMessage();
        message.setString("mess", mess);
		return message;
	}
	
	
}

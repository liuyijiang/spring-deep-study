package com.spring.mq.service.impl;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.spring.mq.mess.Mess;
import com.spring.mq.service.BaseMessageService;

//@Service
public class BaseMessageServiceImpl implements BaseMessageService {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	@Qualifier("queuedestination")
	private ActiveMQQueue queuedestination;//目的地
	
	@Autowired
	@Qualifier("destination")
	private Destination destination;//目的地
	
	@Override
	public void sendData() {
		System.out.println("开始copy 图片。。。。。");
		Mess mess = new Mess();
		mess.setMess("完成copy 图片");
		jmsTemplate.send(destination,mess);
		
	}

	@Override
	public void sendToQueue() {
		System.out.println("开始copy 图片放入队列。。。。。");
		Mess mess = new Mess();
		mess.setMess("完成copy 图片");
		jmsTemplate.send(queuedestination,mess);
		
	}

}

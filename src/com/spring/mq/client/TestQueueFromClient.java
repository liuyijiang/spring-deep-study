package com.spring.mq.client;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.spring.mq.listener.BaseMessageListener;

/**
 * 程序中创建  不和spring 集成
 * @author Administrator
 *
 */
public class TestQueueFromClient {

	public static void main(String[] args) {
		TestQueueFromClient t = new TestQueueFromClient();
		try {
			t.testTop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void test() throws Exception{
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
	            "liuyij", "system", "tcp://192.168.2.127:61616");
	  Connection connection = connectionFactory.createConnection();
	  connection.start();
	  Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
	  Destination destination = session.createQueue("clinet-que");
	  MessageConsumer consumer = session.createConsumer(destination);
	  consumer.setMessageListener(new BaseMessageListener());
	  connection.start(); 
	}
	
	public void testTop() throws Exception{
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
	            "liuyij", "system", "tcp://192.168.2.127:61616");
	  Connection connection = connectionFactory.createConnection();
	  connection.start();
	  Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
	  Destination destination = session.createQueue("clint-top");
	  MessageConsumer consumer = session.createConsumer(destination);
	  consumer.setMessageListener(new BaseMessageListener());
	  connection.start(); 
	}
	
}

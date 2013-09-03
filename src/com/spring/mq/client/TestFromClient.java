package com.spring.mq.client;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * 程序中创建  不和spring 集成
 * @author Administrator
 *
 */
public class TestFromClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestFromClient t = new TestFromClient();
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
	  
       MessageProducer producer = session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);
		MapMessage message = session.createMapMessage();
		message.setString("mess", "from clinet11");
		producer.send(destination, message);
		session.commit();
	}
	
	public void testTop() throws Exception{
		  ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
		            "liuyij", "system", "tcp://192.168.2.127:61616");
		  Connection connection = connectionFactory.createConnection();
		  connection.start();
		  Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		  Destination destination = session.createTopic("clint-top");
		  
	        MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);//�־û���Ϣ
			MapMessage message = session.createMapMessage();
			message.setString("mess", "from testTop");
			producer.send(destination, message);
			session.commit();
		}
	
}

package com.redis.pubsub;

import redis.clients.jedis.Jedis;

/**
 * 实现一个消息队列
 * @author Administrator
 *
 */
public class QuereClient extends Thread {

	private Jedis jedis = null;
	
	public QuereClient(){
		jedis = new Jedis("192.168.2.153",6379);
	}

	public void run(){
		for(int i=0 ;i<10;i++){
			try{
				//将信息 message 发送到指定的频道 channel 。
				//O(N+M)，其中 N 是频道 channel 的订阅者数量，而 M 则是使用模式订阅(subscribed patterns)的客户端的数量
				String channl = "quere";
				jedis.publish(channl, "pushmessage"+i);//
				Thread.sleep(2000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void pushMessage(){
		
	}
	
	
}

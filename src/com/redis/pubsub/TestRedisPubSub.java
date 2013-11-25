package com.redis.pubsub;

import redis.clients.jedis.Jedis;

/**
 * 这个类来测试redis中pub/sub的操作
 * redis中所有pub/sub的操作
 * @author Administrator
 * 
    PSUBSCRIBE  订阅一个或多个符合给定模式的频道。每个模式以 * 作为匹配符，比如 it* 匹配所有以 it 开头的频道( it.news 、 it.blog 、 it.tweets 等等)， news.* 匹配所有以 news. 开头的频道( news.it 、 news.global.today 等等)，诸如此类。
    PUBLISH 将信息 message 发送到指定的频道 channel 。O(N+M)，其中 N 是频道 channel 的订阅者数量，而 M 则是使用模式订阅(subscribed patterns)的客户端的数量
    PUBSUB PUBSUB 是一个查看订阅与发布系统状态的内省命令， 它由数个不同格式的子命令组成， 以下将分别对这些子命令进行介绍。
    PUNSUBSCRIBE
    SUBSCRIBE
    UNSUBSCRIBE
 */
public class TestRedisPubSub {

    private Jedis jedis = null;
	
	public TestRedisPubSub(){
		jedis = new Jedis("192.168.2.153",6379);
	}
	
	public void testpub(){
		//JedisPubSub jedisPubSub = jedis.pu PUBSUB 
		//jedis.pub
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QuereService s = new QuereService();
		s.start();
		QuereClient q = new QuereClient();
		q.start();
	}

}

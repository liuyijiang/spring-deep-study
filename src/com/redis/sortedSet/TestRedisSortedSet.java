package com.redis.sortedSet;

import java.util.Set;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;
/**
 * 测试有序集合排名邦
 * @author Administrator
 *ZSCORE获得最高分
 */
public class TestRedisSortedSet {

    private Jedis jedis = null;
	
	public TestRedisSortedSet(){
		jedis = new Jedis("192.168.1.211",6379);
	}
	
	public void showKey(){
		Set<String> set = jedis.keys("ranking");
		for (String key : set) {
			System.out.println(key);
		}
	}
	
	public void addData(){
		jedis.del("caonima");
		for (int i = 0 ;i<100 ;i++) {
			UserVO vo = new UserVO();
			vo.name = "user:"+ (int)(Math.random()*20);
			vo.openid = "openid:"+i;
			jedis.zadd("caonima", (int)(Math.random()*5000), JSON.toJSONString(vo));
		}
	}
	
	//获得排名 重小到大
	public void getRanking(String key){
		System.out.println(jedis.zrank("ranking", key)+1);
	}
	
	/**
	 * 获得排序后的数据
	 */
	public void getRankingAll(){
//		Set<String> set = jedis.zrange("ranking", 0, -1);//从小到大
//		for (String key : set) {
//			System.out.println(key);
//		}
//		System.out.println("###############");
//		Set<Tuple> sett = jedis.zrangeWithScores("ranking", 0, -1);
//		for (Tuple key : sett) {
//			System.out.println(key.getScore() + " :" + key.getElement());//从小到大
//		} ZREVRANGE
		//Set<String> set = jedis.zrevrange("ranking", 0, -1);//从大到小
//		Set<String> set = jedis.zrevrange("ranking", 0, 100);//从大到小
//		for (String key : set) {
//			System.out.println(key);
//		}
		System.out.println("###############");
		Set<Tuple> sett = jedis.zrevrangeWithScores("caonima", 0, -1);
		System.out.println(sett.size());
		for (Tuple key : sett) {
			UserVO user = JSON.parseObject(key.getElement().toString(),UserVO.class);
			System.out.println(key.getScore() + " :name：" + user.name+"openid:"+user.openid);//从大到小
		}
	}
	
//	public void getRankingBySource(int sou1,int sou2){
//		jedis
//	}
	
	
	public static void main(String[] args) {
		TestRedisSortedSet t = new TestRedisSortedSet();
		t.showKey();
//		t.addData();//会自动替换已有的值
//		System.out.println("ok");
		t.getRankingAll();
		//t.getRanking("key2");
	}
	
	public static class UserVO{
		public String openid;
		public String name;
		public String getOpenid() {
			return openid;
		}
		public void setOpenid(String openid) {
			this.openid = openid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
}

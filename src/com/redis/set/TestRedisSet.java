package com.redis.set;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;
/**
 * redis set 数据类型操作
 * @author jim.liu
 *
    SADD 将一个或多个 member 元素加入到集合 key 当中，已经存在于集合的 member 元素将被忽略。假如 key 不存在，则创建一个只包含 member 元素作成员的集合。当 key 不是集合类型时，返回一个错误。
    SCARD
    SDIFF
    SDIFFSTORE
    SINTER
    SINTERSTORE
    SISMEMBER
    SMEMBERS
    SMOVE
    SPOP
    SRANDMEMBER
    SREM
    SUNION
    SUNIONSTORE
 */
public class TestRedisSet {

    private Jedis jedis = null;
	
	public TestRedisSet(){
		jedis = new Jedis("192.168.1.153",6379);
//		if(jedis.exists("test_set")){
//		   System.out.println("test_set_card: " +jedis.scard("test_set"));
//		  // System.out.println("test_set_card: " +jedis.("test_set"));
//		}
	}
	
	//保存set
	public void testSaveSet(){
		jedis.sadd("test_set_1", "set1","set3","set4");
	}
	
	public void testDel(){
		
	}
	
	public void testMoveData(){
		jedis.smove("test_set_2", "test_set_1", "set2");
		testShowAll();
	}
	
	
	public void testShowAll(){
		Set<String> set = jedis.smembers("test_set_1");
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		//System.out.println("set3 is member? "+ jedis.sismember("test_set", "set3")); 判断是否存在
		System.out.println(jedis.spop("test_set_2"));//随即返回set中一个值
		//jedis.sr
	}
	
	private void showSet(Set<String> set){
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}
	
	//交集 和 补集
	public void testJJandBJ(){
		Set<String> setjj = jedis.sinter("test_set_2","test_set_1");//等到交集
		//Set<String> setbj = jedis.sinterstore(dstkey, keys) 交集保存在
		showSet(setjj);
		Set<String> setbj = jedis.sunion("test_set_2","test_set_1");//补集 两个和在一起
		showSet(setbj);
		Set<String> setcj = jedis.sdiff("test_set_2","test_set_1");//差集 不同的部分  
		showSet(setcj);
 	}
	
	
	public static void main(String[] args) {
		TestRedisSet t = new TestRedisSet();
		t.testJJandBJ();
	}

}

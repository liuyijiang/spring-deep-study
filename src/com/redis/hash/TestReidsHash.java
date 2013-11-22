package com.redis.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * 这个类来测试redis中hash的操作
 * redis中所有hash的操作
 * 
    HDEL 删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略。
    HEXISTS 查看哈希表 key 中，给定域 field 是否存在。
    HGET 返回哈希表 key 中给定域 field 的值
    HGETALL 返回哈希表 key 中，所有的域和值。在返回值里，紧跟每个域名(field name)之后是域的值(value)，所以返回值的长度是哈希表大小的两倍。
    HINCRBY  为哈希表 key 中的域 field 的值加上增量 increment 。增量也可以为负数，相当于对给定域进行减法操作。如果 key 不存在，一个新的哈希表被创建并执行 HINCRBY 命令。如果域 field 不存在，那么在执行命令前，域的值被初始化为 0 。对一个储存字符串值的域 field 执行 HINCRBY 命令将造成一个错误。
    HINCRBYFLOAT
    HKEYS 返回哈希表 key 中的所有域
    HLEN 返回哈希表 key 中域的数量。
    HMGET 返回哈希表 key 中，一个或多个给定域的值。如果给定的域不存在于哈希表，那么返回一个 nil 值。因为不存在的 key 被当作一个空哈希表来处理，所以对一个不存在的 key 进行 HMGET 操作将返回一个只带有 nil 值的表。
    HMSET 同时将多个 field-value (域-值)对设置到哈希表 key 中。此命令会覆盖哈希表中已存在的域。如果 key 不存在，一个空哈希表被创建并执行 HMSET 操作。
    HSET 插入
    HSETNX 插入不覆盖
    HVALS 返回哈希表 key 中所有域的值。
 */
public class TestReidsHash {

	private Jedis jedis = null;
	
	public TestReidsHash(){
		jedis = new Jedis("192.168.2.102", 6379);
		//jedis.hkeys(key) 返回所有的key值
		//jedis.hvals(key) 返回所有的value
	}
	
	//查看哈希表 key 中，给定域 field 是否存在。
	public void testExists(){
		System.out.println("liuyijiang:"+jedis.hexists("hash_test", "liuyijiang"));//测试key 是否存在
		System.out.println("yuzhu:"+jedis.hexists("hash_test", "yuzhu"));
		System.out.println("#################get################");
		System.out.println("yuzhu: "+jedis.hget("hash_test", "yuzhu"));//返回哈希表 key 中给定域 field 的值。
		Set<String> setkeys = jedis.hkeys("hash_test");//返回哈希表 key 中的所有域
		System.out.println("#################所有key################");
		System.out.println("filed number: "+jedis.hlen("hash_test"));//返回哈希表 key 中域的数量。
		for (String str : setkeys) {
			System.out.println(str);
		}
		System.out.println("###############所有value##############");
		List<String> list = jedis.hvals("hash_test");//返回哈希表 key 中所有域的值。
		for (String str : list) {
			System.out.println(str);
		}
	}
	
	public void testSaveHash(){
//		Set<String> set = new HashSet<String>();
//		set.add("key1");
//		set.add("key2");
//		set.add("key3");
//		jedis.hset("hash_test", "chengxiaoting", "23");//像一个map 
		//jedis.hset(key, field, value)
		//jedis.hsetnx(key, field, value);//SETNX 是『SET if Not eXists』(如果不存在，则 SET)的简写。
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("xuyucheng", "23");
		map.put("yuzhu","24");
		jedis.hset("hash_test", "chengxiaoting", "24");
		jedis.hmset("hash_test", map);//一次性多插入多条数据
	}
	
	//HGETALL 返回哈希表 key 中，所有的域和值
	public void testGet(){
		System.out.println("####################get all##########################");
		Map<String,String> map = jedis.hgetAll("hash_test");//获得所有值 返回map
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.println(map.get(it.next()));
		}
		System.out.println("####################get 多个 ##########################");
		List<String> list = jedis.hmget("hash_test", "chengxiaoting","xuyucheng");//返回哈希表 key 中，一个或多个给定域的值 
		for (String str : list) {
			System.out.println(str);
		}
	}
	
	public void testHDel(){
		jedis.hdel("hash_test", "xuyucheng","yuzhu");//删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略。
	}
	
	public void testHLen(){//return hash set length
		System.out.println(jedis.hlen("hash_test"));
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestReidsHash t = new TestReidsHash();
//		t.testExists();
//		t.testSaveHash();
		t.testGet();
//		t.testHDel();
//		t.testGetAll();
		//t.testHLen();
	}
	
}

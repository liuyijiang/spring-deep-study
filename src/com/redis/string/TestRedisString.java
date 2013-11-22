package com.redis.string;

import java.util.List;

import redis.clients.jedis.Jedis;

/**
 * 这个类来测试redis中string的操作
 * redis中所有string的操作
    APPEND 如果 key 已经存在并且是一个字符串， APPEND 命令将 value 追加到 key 原来的值的末尾。如果 key 不存在， APPEND 就简单地将给定 key 设为 value ，就像执行 SET key value 一样
    BITCOUNT (个人感觉不常用)计算给定字符串中，被设置为 1 的比特位的数量。
    BITOP (个人感觉不常用)对一个或多个保存二进制位的字符串 key 进行位元操作，并将结果保存到 destkey 上。
    DECR 将 key 中储存的数字值减一。如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 DECR 操作。如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。
    DECRBY 将 key 所储存的值减去减量 decrement 。如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 DECRBY 操作。如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。
    GET 返回 key 所关联的字符串值。如果 key 不存在那么返回特殊值 nil 。假如 key 储存的值不是字符串类型，返回一个错误，因为 GET 只能用于处理字符串值。
    GETBIT 对 key 所储存的字符串值，获取指定偏移量上的位(bit)。当 offset 比字符串值的长度大，或者 key 不存在时，返回 0 。
    GETRANGE 返回 key 中字符串值的子字符串，字符串的截取范围由 start 和 end 两个偏移量决定(包括 start 和 end 在内)。
    GETSET 将给定 key 的值设为 value ，并返回 key 的旧值(old value)。当 key 存在但不是字符串类型时，返回一个错误。
    INCR 将 key 中储存的数字值增一。如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 INCR 操作。如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。
    INCRBY 将 key 所储存的值加上增量 increment 。如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 INCRBY 命令。如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。
    INCRBYFLOAT 增加一个浮点数
    MGET 返回所有(一个或多个)给定 key 的值。如果给定的 key 里面，有某个 key 不存在，那么这个 key 返回特殊值 nil 。因此，该命令永不失败
    MSET 同时设置一个或多个 key-value 对。如果某个给定 key 已经存在，那么 MSET 会用新值覆盖原来的旧值，如果这不是你所希望的效果，请考虑使用 MSETNX 命令：它只会在所有给定 key 都不存在的情况下进行设置操作。
    MSETNX 同时设置一个或多个 key-value 对，当且仅当所有给定 key 都不存在。即使只有一个给定 key 已存在， MSETNX 也会拒绝执行所有给定 key 的设置操作。
    PSETEX 这个命令和 SETEX 命令相似，但它以毫秒为单位设置 key 的生存时间，而不是像 SETEX 命令那样，以秒为单位。
    SET 将字符串值 value 关联到 key 。如果 key 已经持有其他值， SET 就覆写旧值，无视类型
    SETBIT （搞不懂）
    SETEX 将值 value 关联到 key ，并将 key 的生存时间设为 seconds (以秒为单位)。如果 key 已经存在， SETEX 命令将覆写旧值。
    SETNX 将 key 的值设为 value ，当且仅当 key 不存在。若给定的 key 已经存在，则 SETNX 不做任何动作。
    SETRANGE （搞不懂） 用 value 参数覆写(overwrite)给定 key 所储存的字符串值，从偏移量 offset 开始。不存在的 key 当作空白字符串处理。
    STRLEN 返回 key 所储存的字符串值的长度。当 key 储存的不是字符串值时，返回一个错误。
 * @author Administrator
 * 
 */
public class TestRedisString {
  
private Jedis jedis = null;
	
	public TestRedisString(){
		jedis = new Jedis("192.168.2.102", 6379);
	}
	
	//测试递减 value必须是数字类型
	public void testDecr(){
		jedis.decr("num");
		System.out.println(jedis.get("num"));
		jedis.decr("num");//每次递减1
		System.out.println(jedis.get("num"));
		jedis.set("num", "3000");
		System.out.println(jedis.get("num"));
		jedis.decrBy("num", 300);//每次递减300
		System.out.println(jedis.get("num"));
	}
	
	//测试递增 value必须是数字类型
	public void testIncr(){
		jedis.incr("num");
		System.out.println(jedis.get("num"));
		jedis.incr("num");//每次递减1
		System.out.println(jedis.get("num"));
		jedis.set("num", "3000");
		System.out.println(jedis.get("num"));
		jedis.incrBy("num", 300);//每次递减300
		System.out.println(jedis.get("num"));
	}
	
	//测试append 对字符串经行追加
	//APPEND 可以为一系列定长(fixed-size)数据(sample)提供一种紧凑的表示方式，通常称之为时间序列。
	public void testappend(){
		jedis.set("te", "婷");
		System.out.println(jedis.get("te"));
		jedis.append("te", "happy");
		System.out.println(jedis.get("te"));
	}
	
	//测试redis string类型的各种set
	public void testStringSet(){
		//jedis.set(key, value)
		//jedis.setnx(key, value) 将 key 的值设为 value ，当且仅当 key 不存在。
		jedis.set("set1", "test set1");//最简答的set
		jedis.setex("te", 30, "yj"); //设置过期时间
		jedis.setnx("set1", "test set1");////不会覆盖已有的
		jedis.mset("setm1","test setm1","setm2","test setm2");//两个一对 第一个是key 第二个是value
		jedis.msetnx("setm1","test setm1","setm2","test setm2");//不会覆盖已有的
		
	}
	
	
//	public void testStringSetrage(){
//		jedis.setrange("test_update", 3, "lover");//替换
//		//jedis.mset(keysvalues)
//	}
	
	//测试redis string类型的各种get
	public void testStringGet(){
		System.out.println("#################最简单得key value get######################");
		System.out.println(jedis.get("te"));//最简单得key value get
		System.out.println("#################bit######################");
		System.out.println(jedis.getbit("te", 1));//目前还不知道这个的意义和场景
		System.out.println("################字符串截取#######################");
		jedis.set("rtest","hello, my friend");
		System.out.println(jedis.get("rtest"));
		System.out.println(jedis.getrange("rtest", 0,4 ));//字符串截取 返回索引0-4的字符，包括4。
		System.out.println("################字符串替换#######################");
		jedis.set("getset","ok");
		System.out.println(jedis.get("getset"));
		System.out.println(jedis.getSet("getset","thank"));//字符串替换 返回的是原始的值
		System.out.println(jedis.get("getset"));
		System.out.println("################获得多个key的value#######################");
		//时间复杂度 O(N) , N 为给定 key 的数量
		List<String> list = jedis.mget("getset","rtest","te");
		for (String str:list) {
			System.out.println(str);
		}
		System.out.println(jedis.strlen("getset"));//获得key 对应value的字符串长度 必须是字符串
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestRedisString t = new TestRedisString();
		t.testStringGet();
		//t.testappend();
		//t.testDecr();
		//t.testIncr();
	}

	
}

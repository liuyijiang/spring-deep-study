package com.redis.list;

import java.util.List;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.Jedis;
/**
 *这个类来测试redis中list的操作
 * redis中所有list的操作
 * @author Administrator
 *
    BLPOP  是列表的阻塞式(blocking)弹出原语。
    BRPOP  是列表的阻塞式(blocking)弹出原语
    BRPOPLPUSH 是 RPOPLPUSH 的阻塞版本，当给定列表 source 不为空时， BRPOPLPUSH 的表现和 RPOPLPUSH 一样。当列表 source 为空时， BRPOPLPUSH 命令将阻塞连接，直到等待超时，或有另一个客户端对 source 执行 LPUSH 或 RPUSH 命令为止。
    LINDEX 
    LINSERT 将值 value 插入到列表 key 当中，位于值 pivot 之前或之后。当 pivot 不存在于列表 key 时，不执行任何操作。当 key 不存在时， key 被视为空列表，不执行任何操作。如果 key 不是列表类型，返回一个错误。
    LLEN 返回列表 key 的长度。如果 key 不存在，则 key 被解释为一个空列表，返回 0 .如果 key 不是列表类型，返回一个错误
    LPOP 移除并返回列表 key 的头元素。
    LPUSH 将一个或多个值 value 插入到列表 key 的表头
    LPUSHX 将值 value 插入到列表 key 的表头，当且仅当 key 存在并且是一个列表。和 LPUSH 命令相反，当 key 不存在时， LPUSHX 命令什么也不做。
    LRANGE 返回列表 key 中指定区间内的元素，区间以偏移量 start 和 stop 指定。
    LREM  根据参数 count 的值，移除列表中与参数 value 相等的元素。
		    count 的值可以是以下几种：
		    count > 0 : 从表头开始向表尾搜索，移除与 value 相等的元素，数量为 count 。
		    count < 0 : 从表尾开始向表头搜索，移除与 value 相等的元素，数量为 count 的绝对值。
		    count = 0 : 移除表中所有与 value 相等的值。
    LSET 将列表 key 下标为 index 的元素的值设置为 value 。当 index 参数超出范围，或对一个空列表( key 不存在)进行 LSET 时，返回一个错误。
    LTRIM 对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除。
    RPOP 移除并返回列表 key 的尾元素。
    RPOPLPUSH
    RPUSH 将一个或多个值 value 插入到列表 key 的表尾(最右边)。
    RPUSHX
 */
public class TestRedisList {

	
	private Jedis jedis = null;
	
	public TestRedisList(){
		jedis = new Jedis("192.168.2.153",6379);
	}
	
	public void testrim(){
		System.out.println("集合长度:"+jedis.llen("test_list"));//查询集合长度
		List<String> list = jedis.lrange("test_list", 0, -1);
		for(String str :list){
			System.out.print(str+"\t");
		}
		System.out.println("\n");
		jedis.ltrim("test_list", 0, 1);//截取list
		 list = jedis.lrange("test_list", 0, -1);
			for(String str :list){
				System.out.print(str+"\t");
			}
	}
	
	public void testlrem(){
		System.out.println("#############集合长度###############");
		System.out.println("集合长度:"+jedis.llen("test_list"));//查询集合长度
		List<String> list = jedis.lrange("test_list", 0, -1);
		for(String str :list){
			System.out.print(str+"\t");
		}
		System.out.println("\n");
		jedis.lrem("test_list", 2L, "12"); //相同的也会删除
		list = jedis.lrange("test_list", 0, -1);
		for(String str :list){
			System.out.print(str+"\t");
		}
	}
	
	//测试pop操作
	public void testpop(){
		System.out.println("#############集合长度###############");
		System.out.println("集合长度:"+jedis.llen("test_list"));//查询集合长度
		List<String> list = jedis.lrange("test_list", 0, -1);
		for(String str :list){
			System.out.print(str+"\t");
		}
		System.out.println("\n");
		System.out.println(jedis.lpop("test_list"));//移除并返回列表 key 的头元素。
		System.out.println(jedis.blpop(5,"test_list"));//柱塞弹出 超时五秒
		System.out.println("集合长度:"+jedis.llen("test_list"));//查询集合长度
		list = jedis.lrange("test_list", 0, -1);
		for(String str :list){
			System.out.print(str+"\t");
		}
	}
	
	//
	public void testBase(){
		System.out.println("#############集合长度###############");
		System.out.println("集合长度:"+jedis.llen("test_list"));//查询集合长度
		System.out.println("#############放入值###############");
		//jedis.lpush("test_list", "555");
		jedis.lpush("test_list", "103","89","234","12");//key 不存在 存在都不影响 不会去重复
		System.out.println("集合长度:"+jedis.llen("test_list"));//查询集合长度
		System.out.println("#############index###############");
		System.out.println("index is 2:"+jedis.lindex("test_list", 2));
		List<String> list = jedis.lrange("test_list", 0, -1);
		for(String str :list){
			System.out.print(str+"\t");
		}
		System.out.println("\n");
		//jedis.linsert("test_list",LIST_POSITION.AFTER,"555","233212");//在某一位置插入数据
		list = jedis.lrange("test_list", 0, -1);
		for(String str :list){
			System.out.print(str+"\t");
		}
	}
	
	
	
	public void saveList(){
		jedis.lpush("test_list", "103","89","234","12");//key 不存在 存在都不影响
		//jedis.lpushx(key, string);//key 存在
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestRedisList t = new TestRedisList();
		t.testrim();
		//t.testlrem();
		//t.testBase();
		//t.testpop();
	}

}

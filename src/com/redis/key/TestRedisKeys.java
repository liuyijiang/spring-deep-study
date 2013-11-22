package com.redis.key;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * 这个类来测试redis中key的操作
 * redis中所有key的操作
    DEL  删除key
    DUMP 序列化给定 key ，并返回被序列化的值，使用 RESTORE 命令可以将这个值反序列化为 Redis 键。
    EXISTS 判断key是否存在
    EXPIRE 设置key失效时间 接受参数 秒
    EXPIREAT 设置key失效时间 接受的时间参数是 UNIX 时间戳(unix timestamp)。
    KEYS 查找所有符合给定模式 pattern 的 key
    MIGRATE 将 key 原子性地从当前实例传送到目标实例的指定数据库上
    MOVE 将当前数据库的 key 移动到给定的数据库 db 当中 
    OBJECT 命令允许从内部察看给定 key 的 Redis 对象
    PERSIST 移除给定 key 的生存时间，将这个 key 从『易失的』(带生存时间 key )转换成『持久的』(一个不带生存时间、永不过期的 key )。
    PEXPIRE 这个命令和 EXPIRE 命令的作用类似，但是它以毫秒为单位设置 key 的生存时间，而不像 EXPIRE 命令那样，以秒为单位
    PEXPIREAT 这个命令和 EXPIREAT 命令类似，但它以毫秒为单位设置 key 的过期 unix 时间戳，而不是像 EXPIREAT 那样，以秒为单位。
    PTTL 这个命令类似于 TTL 命令，但它以毫秒为单位返回 key 的剩余生存时间，而不是像 TTL 命令那样，以秒为单位
    RANDOMKEY 从当前数据库中随机返回(不删除)一个 key 
    RENAME 将 key 改名为 newkey 。当 key 和 newkey 相同，或者 key 不存在时，返回一个错误。当 newkey 已经存在时， RENAME 命令将覆盖旧值
    RENAMENX 当且仅当 newkey 不存在时，将 key 改名为 newkey 。 当 key 不存在时，返回一个错误。
    RESTORE 反序列化给定的序列化值，并将它和给定的 key 关联。
    SORT 返回或保存给定列表、集合、有序集合 key 中经过排序的元素。排序默认以数字作为对象，值被解释为双精度浮点数，然后进行比较。
    TTL 以秒为单位，返回给定 key 的剩余生存时间(TTL, time to live)。
    TYPE 返回 key 所储存的值的类型。none (key不存在) string (字符串) list (列表)set (集合) zset (有序集)  hash (哈希表)
 * @author jim.liu
 * 
 */
public class TestRedisKeys {

	private Jedis jedis = null;

	public TestRedisKeys() {
		jedis = new Jedis("192.168.2.102", 6379);
//		System.out.println("db1:" + jedis.exists("test"));
//		jedis.select(1); // 切换数据库
//		System.out.println("db1:" + jedis.exists("test"));
//		jedis.select(0);
//		System.out.println("db1:" + jedis.exists("test"));
	}

	//获得key类型
	public void testType(){
		System.out.println(jedis.type(jedis.randomKey()));
		jedis.select(2);
		System.out.println(jedis.type(jedis.randomKey()));
	}
	
	// 没有对应的key返回0 正常返回1
	public void testDeleteKey() {
		System.out.println(jedis.del("test"));//删除key
	}

	// 查看当前所有key
	public void testShowKeys() {
		Set<String> set = jedis.keys("*");// * 匹配数据库中所有 key 。
		//Set<String> set = jedis.keys("h?llo");// h?llo 匹配 hello ， hallo 和 hxllo 等
		//Set<String> set = jedis.keys("h*llo");// h*llo 匹配 hllo 和 heeeeello 等。
		//Set<String> set = jedis.keys("h[ae]llo");// h[ae]llo 匹配 hello 和 hallo ，但不匹配 hillo 。
		//KEYS 的速度非常快，但在一个大的数据库中使用它仍然可能造成性能问题，如果你需要从一个数据集中查找特定的 key ，你最好还是用 Redis 的集合结构(set)来代替。
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

	//修改key的名称
	public void testRename(String key){
		jedis.select(2);
		jedis.set(key, "xuting");
		System.out.println(jedis.get(key));
		String newkey = key + "new";
		jedis.rename(key, newkey);
		System.out.println(jedis.get(newkey));
	}
	
	//获得随即key
	public void testShowRadomKey() {
		jedis.select(2);
		System.out.println(jedis.randomKey());
	}

	//查看一个key还剩余的过期时间
	public void testTTL() {
		jedis.expire("p", 10);// 设置一个key的过期时间单位秒  10秒
		//jedis.expireAt("ss", 1355292000);
		boolean flag = true;
		while (flag) {
			try {
				long i = jedis.ttl("p");
				System.out.println(i);
				Thread.sleep(1000);
				if (i == -1) {
					flag = false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("ok");
	}

	public void testMigrate(){
		// jedis 不支持这个命令
		//先启动两个 Redis 实例，一个使用默认的 6379 端口，一个使用 7777 端口。$ ./redis-server  $ ./redis-server --port 7777
		//然后用客户端连上 6379 端口的实例，设置一个键，然后将它迁移到 7777 端口的实例上：
		//redis 127.0.0.1:6379> SET greeting "Hello from 6379 instance"
		//redis 127.0.0.1:6379> MIGRATE 127.0.0.1 7777 greeting 0 1000
		//redis 127.0.0.1:6379> EXISTS greeting  
		//迁移后会自动删除
		//
		//redis 127.0.0.1:7777> GET greeting
	}
	
	//移动key 到选择的数据
	//如果当前数据库(源数据库)和给定数据库(目标数据库)有相同名字的给定 key ，或者 key 不存在于当前数据库，那么 MOVE 没有任何效果。
	//次方法执行2次结果会不一样 
	public void testMove(String key){
		jedis.select(1);
		System.out.println("###########select 1 database ##################");
		System.out.println("db1 has test key :" + jedis.exists(key));
		jedis.set(key, "liuyijiang");
		System.out.println("db1 has test key :" + jedis.exists(key));
		System.out.println(jedis.get(key));
		jedis.move(key, 2);//将test key移动到2号数据库
		System.out.println("###########move key  ##################");
		System.out.println("db1 has test key :" + jedis.exists(key)); //移动后db1没有这个key
		jedis.select(2);
		System.out.println("###########select 2 database ##################");
		System.out.println("db2 has test key :" + jedis.exists(key));
		System.out.println(jedis.get(key));
	}
	
	//test object 命令允许从内部察看给定 key 的 Redis 对象
	public void testObject(String key){
		//jedis.set(key, "hololw");
		jedis.hset(key, "mao", "sa");
		System.out.println(jedis.objectEncoding(key));//OBJECT ENCODING <key> 返回给定 key 锁储存的值所使用的内部表示(representation)。
		System.out.println(jedis.objectIdletime(key));//OBJECT IDLETIME <key> 返回给定 key 自储存以来的空转时间(idle， 没有被读取也没有被写入)，以秒为单位。
		System.out.println(jedis.objectRefcount(key));//OBJECT REFCOUNT <key> 返回给定 key 引用所储存的值的次数。此命令主要用于除错。
	    //对象可以以多种方式编码：
        //字符串可以被编码为 raw (一般字符串)或 int (用字符串表示64位数字是为了节约空间)。
		//列表可以被编码为 ziplist 或 linkedlist 。 ziplist 是为节约大小较小的列表空间而作的特殊表示。
		//集合可以被编码为 intset 或者 hashtable 。 intset 是只储存数字的小集合的特殊表示。
		//哈希表可以编码为 zipmap 或者 hashtable 。 zipmap 是小哈希表的特殊表示。
		//有序集合可以被编码为 ziplist 或者 skiplist 格式。 ziplist 用于表示小的有序集合，而 skiplist 则用于表示任何大小的有序集合。
		//假如你做了什么让 Redis 没办法再使用节省空间的编码时(比如将一个只有 1 个元素的集合扩展为一个有 100 万个元素的集合)，特殊编码类型(specially encoded types)会自动转换成通用类型(general type)。
	}
	
	//持久化key 移除过期时间
	public void testPerstit(String key){
		jedis.set(key, "anan");
		jedis.expire(key, 30);
		for (int i=0;i<10;i++) {
			System.out.println(jedis.ttl(key));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		jedis.persist(key); //持久化key 移除过期时间
		System.out.println(jedis.ttl(key));
	}
	
	/**
	 * 修改key name
	 */
	public void testRenameKey() {
		System.out.println("test_update: " + jedis.get("test_update"));
		System.out.println("test: " + jedis.get("test"));
		jedis.rename("test", "test_update");
		System.out.println("test_update: " + jedis.get("test_update"));
		// jedis.renamenx(oldkey, newkey); 当且仅当 newkey 不存在时，将 key 改名为 newkey
	}

	/**
	 * 排序列表
	 */
	public void testSort() {
		List<String> set = jedis.sort("nums");
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " - ");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestRedisKeys t = new TestRedisKeys();
		t.testType();
		//t.testRename("tts");
		// t.testDeleteKey();
		// t.testShowKeys();
		//t.testShowRadomKey();
		// t.testTTL();
		// t.testRenameKey();
		//t.testSort();
		//t.testMove("test2");
		//t.testObject("test3");
		//t.testPerstit("test4");
	}

}

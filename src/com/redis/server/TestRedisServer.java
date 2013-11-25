package com.redis.server;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisMonitor;

import com.redis.pubsub.Linster;
/**
 * 测试redis server
 * 
    BGREWRITEAOF 执行一个 AOF文件 重写操作。重写会创建一个当前 AOF 文件的体积优化版本。 从 Redis 2.4 开始， AOF 重写由 Redis 自行触发， BGREWRITEAOF 仅仅用于手动触发重写操作。
    BGSAVE 在后台异步(Asynchronously)保存当前数据库的数据到磁盘。BGSAVE 命令执行之后立即返回 OK ，然后 Redis fork 出一个新子进程，原来的 Redis 进程(父进程)继续处理客户端请求，而子进程则负责将数据保存到磁盘，然后退出。
    CLIENT GETNAME 返回 CLIENT SETNAME 命令为连接设置的名字。
    CLIENT KILL
    CLIENT LIST
    CLIENT SETNAME
    CONFIG GET
    CONFIG RESETSTAT
    CONFIG REWRITE
    CONFIG SET
    DBSIZE 返回当前数据库的 key 的数量。
    DEBUG OBJECT
    DEBUG SEGFAULT
    FLUSHALL
    FLUSHDB
    INFO
    LASTSAVE 返回最近一次 Redis 成功将数据保存到磁盘上的时间，以 UNIX 时间戳格式表示。
    MONITOR
    PSYNC
    SAVE
    SHUTDOWN
    SLAVEOF
    SLOWLOG
    SYNC
    TIME
 * @author Administrator
 *
 */
public class TestRedisServer {

	private Jedis jedis = null;
	
	public TestRedisServer(){
		jedis = new Jedis("192.168.2.153",6379);
	}
	
	public void test(){
		//System.out.println("########手动除发AOF文件 重写操作#######");
		//System.out.println(jedis.bgrewriteaof());//执行一个 AOF文件 重写操作。重写会创建一个当前 AOF 文件的体积优化版本。
//		System.out.println("########手save#######");
//		System.out.println(jedis.bgsave());
//		System.out.println(jedis.lastsave());
		//客户端可以通过 LASTSAVE 命令查看相关信息，判断 BGSAVE 命令是否执行成功
		//System.out.println(jedis.getClient().getTimeout());
		//jedis.configGet(pattern)
		System.out.println(jedis.info());//redis 信息
		System.out.println("数据库key的数量"+jedis.dbSize());
		//JedisMonitor jm = new JedisMonitor();
		//jedis.monitor(new Linster());
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestRedisServer t = new TestRedisServer();
		t.test();

	}

}

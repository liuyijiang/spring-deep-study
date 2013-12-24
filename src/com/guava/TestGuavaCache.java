package com.guava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.Weigher;

/**
 * guvava cache CPU缓存
 * @author Administrator
 *
 */
public class TestGuavaCache {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestGuavaCache t = new TestGuavaCache();
		try {
			//t.testCacheBuilder();
			t.testCallable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cacheByCacheloader(){
		CacheBuilder builder = CacheBuilder.newBuilder();
		//基于时间的移出策略
		//Guava提供了两种基于时间的移除方式，
		builder.expireAfterAccess(10, TimeUnit.SECONDS);//后一次访问后的一段时间移除
		builder.expireAfterWrite(10, TimeUnit.SECONDS);//缓存写入的一段时间后移除
		
		//基于引用的移出策略
		builder.weakKeys();//这样的缓存的key是弱引用的。
		builder.weakValues();//缓存的value是弱引用的。
		builder.softValues();//缓存的value是软引用。
		
		Cache<String, String> cache = builder.build();
		//手动移除缓存
		builder.maximumSize(10);//
//		Cache<String, String> cache = CacheBuilder.newBuilder().expireAfterAccess(8, TimeUnit.SECONDS).maximumSize(10).build();  
//		cache.
	}

	/**
	 * 使用LoadingCache
	 * 首先是基于cacheloader的方法
	 * @throws ExecutionException
	 */
	public void testCacheBuilder() throws ExecutionException {

		LoadingCache<String, String> graphs = CacheBuilder.newBuilder()
			.maximumSize(1000)
			.build(new CacheLoader<String, String>() {
				public String load(String key) {
					System.out.println("-----------数据库操作获得值 第一次会执行这里------------");
					return "value";
				}
			});

		System.out.println(graphs.get("testKey"));
		System.out.println("————————————————————————————————");
		System.out.println(graphs.get("testKey"));
		//graphs.as
	}
	
	/**
	 * 其次是基于实现callable的方法：
	 * @throws ExecutionException
	 */
	public void testCallable() throws ExecutionException {
		// 没有使用CacheLoader
		Cache<String, String> cache = CacheBuilder.newBuilder()
			.maximumSize(1000)
			.build();
		String resultVal = cache.get("testKey", get());
		System.out.println(resultVal);
		System.out.println("————————————————————————————————");
		resultVal = cache.get("testKey", get());
		System.out.println(resultVal);
	}
	
	private Callable get(){
		return new Callable<String>() {
			public String call() {
				System.out.println("-----------数据库操作获得值 第一次会执行这里------------");
				return "value";
			}
		};
	}
	
	
//	public void testCacheByWeight() throws ExecutionException{
//		 LoadingCache<String, Integer> loadingCache = CacheBuilder.newBuilder()
//	                .maximumWeight(10)
//	                .weigher(new Weigher<String, Integer>() {
//	                    public int weigh(String k, Integer v) {
//	                        return v;    //v的权重设为其本身；
//	                    }
//	                })
//	                .recordStats()
//	                .build(
//	                        new CacheLoader<String, Integer>() {
//	                        	int num = 1;
//	                        	
//	                            public Integer load(String key) {
//	                                return num ++;  //num初始值为1；
//	                            }
//	                        });
//	          System.out.println(loadingCache.get("a"));
//	            System.out.println(loadingCache.get("b"));
//	            System.out.println(loadingCache.get("c"));
//	            System.out.println(loadingCache.get("d"));
//	            System.out.println(loadingCache.get("a"));
//	}
	
}

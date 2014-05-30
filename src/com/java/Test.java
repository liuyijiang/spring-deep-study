package com.java;

import java.util.concurrent.ConcurrentHashMap;

public class Test {

//	public static void sys(){
//		System.out.println(12);
//	}
	
	public static String staticField = "静态变量";
	// 变量
	public String field = "变量";
	// 静态初始化块
	static {
	System.out.println(staticField);
	System.out.println("静态初始化块");
	}
	// 初始化块
	{
	System.out.println(field);
	System.out.println("初始化块");
	}
	
	public Test(){
		System.out.println("构造器");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Test t = new Test();
		ConcurrentHashMap s;
//		String ste = "ss";
//		String stes = "2ss";
//		System.out.println(ste.intern());
		//sys();
	}

}

package com.java.base;

import java.util.HashMap;
import java.util.Map;

public class OutClassTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		OutClassTest t = new OutClassTest();
		t.test2();
	}

	/**
	 * 外部类是抽象的类 不能new 
	 */
	public void test1(){
		//OuterClass o = new OuterClass();
		OuterAbstractClass.InterClassTwo i = new OuterAbstractClass.InterClassTwo(); //静态内部类调用
		System.out.println(OuterAbstractClass.InterClassTwo.a);
		Thread t = new Thread(i);
		t.start();
	}
	
	
	public void test2(){
		OuterClass o = new OuterClass();
		OuterClass.InterClassOne io = o.new InterClassOne();
		Thread t = new Thread(io);
		t.start();
		OuterClass.InterClassTwo i = new OuterClass.InterClassTwo(); //静态内部类调用
		Thread t2 = new Thread(i);
		t2.start();
	}
	
}

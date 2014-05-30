package com.java.base;

public class B extends A {

	public int i=20;
	public static final String KET ="B";
	
	public static void main(String[] args) {
		A a = new B();
		B b = new B();
		System.out.println(a.i+b.i);
		System.out.println(b.KET);
	}
	
}

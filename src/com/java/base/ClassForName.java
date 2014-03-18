package com.java.base;

public class ClassForName {

	public void test(){
		System.out.println("class for name test");
	}
	
	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		Class clzss = Class.forName("com.java.base.ClassForName");
		//ClassForName s = (ClassForName) clzss;

	}

}

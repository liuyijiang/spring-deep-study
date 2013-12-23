package com.java.function;

public class ToFunction {

	public void toFunction(String str,Function<String,Integer,String> fn){
		String strt = fn.method(12,":liuyjiang");
		System.out.println(str + " *********  " + strt);
	}
}

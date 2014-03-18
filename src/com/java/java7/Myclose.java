package com.java.java7;

public class Myclose implements AutoCloseable {

	public Myclose(){
		System.out.println(123);
	}
	
	@Override
	public void close() throws Exception {
		System.out.println("sss");

	}

}

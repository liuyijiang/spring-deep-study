package com.java.base;

public abstract class Plane {

	public Plane(){
		create();
	}
	
	public abstract void create();
	
	protected void cc(){
		System.out.println(1);
	}
}

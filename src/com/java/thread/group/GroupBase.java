package com.java.thread.group;

public abstract class GroupBase {

	public final static String ME = "okok";
	
	public final ThreadGroup threadGroup1 = new ThreadGroup(this.getClass().getName());
	
	public abstract void tt();
	
	public void exe() throws SecurityException, NoSuchFieldException{
		System.out.println(this.getClass().isAnnotation());
	}
	
}

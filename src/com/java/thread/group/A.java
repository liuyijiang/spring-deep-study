package com.java.thread.group;

public class A extends GroupBase{

	public final static String ME = "小唐恬恬";
	
	public String message = "小唐恬";
	
	@Override
	public void tt() {
		System.out.println(this.threadGroup1.getName());
		System.out.println("setDaemon"+this.threadGroup1.isDaemon());
		System.out.println(threadGroup1.activeCount());
		Thread s = new Thread(this.threadGroup1,"xx线程");
		this.threadGroup1.setDaemon(true);
		System.out.println("setDaemon"+this.threadGroup1.isDaemon());
//		s.start();
//		s.interrupt()
	}

	
}

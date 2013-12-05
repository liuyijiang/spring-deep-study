package com.java.base;

public class OuterClass implements Runnable {

	@Override
	public void run() {
		while(true){
			try {
				exe();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
  
	public void exe(){}
	
	
	public class InterClassOne extends OuterClass {

		@Override
		public void exe() {
			System.out.println(this);
			System.out.println(OuterClass.this);//?
			System.out.println("this is InterClassOne");
			System.out.println("************************");
		}
		
	}
	
	/**
	 * 
	 * 静态内部类
	 *
	 */
	public static class InterClassTwo extends OuterClass {

		@Override
		public void exe() {
			System.out.println("this is InterClassTwo");
			
		}
		
	}
	
	
}

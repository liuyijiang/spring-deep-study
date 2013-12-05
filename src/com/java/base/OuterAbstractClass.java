package com.java.base;

public abstract class OuterAbstractClass implements Runnable {

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
  
	public abstract void exe();
	
	
	public class InterClassOne extends OuterAbstractClass {

		 //static int a = 10;成员内部类内不允许有任何静态声明！
		
		@Override
		public void exe() {
			System.out.println("this is InterClassOne");
			
		}
		
	}
	
	/**
	 * 
	 * 静态内部类
	 *
	 */
	public static class InterClassTwo extends OuterAbstractClass {

		static int a = 10; //
		
		@Override
		public void exe() {
			System.out.println("this is InterClassTwo");
			
		}
		
	}
	
	private static class InterClassThree extends OuterAbstractClass {

		@Override
		public void exe() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class  InterClassFoue extends OuterAbstractClass {

		@Override
		public void exe() {
			// TODO Auto-generated method stub
			
		}
		
	}
}

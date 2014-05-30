package com.java.thread;

public class TestThreads {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						System.out.println(Thread.currentThread().getName());
						
					}
				}).start();
			}
			
		}).start();

	}
	
	
	

}

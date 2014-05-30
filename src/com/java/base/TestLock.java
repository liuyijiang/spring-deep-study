package com.java.base;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

	//public Lock lock = new Lock();
	
	public ReentrantLock lock = new ReentrantLock();
	
	private int num;
	
	public void exe(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try{
						lock.lock();
						num = num + 1;
						System.out.println(Thread.currentThread().getName()+ ":\t" +num);
						Thread.sleep(500);
					}catch(Exception e){
						
					}finally{
						lock.unlock();
					}
				}
				
			}
		}).start();
		
       new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try{
						lock.lock();
						num = num - 1;
						System.out.println(Thread.currentThread().getName()+ ":\t" +num);
						Thread.sleep(500);
					}catch(Exception e){
						
					}finally{
						lock.unlock();
					}
				}
				
			}
		}).start();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestLock t = new TestLock();
		t.exe();
		

	}

}

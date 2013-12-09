package com.java.concurrent.locks;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLocks {

	private BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
	private final Lock lock = new ReentrantLock();
	private final Condition full = lock.newCondition();
	private final Condition empty = lock.newCondition();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestLocks t = new TestLocks();
		t.test();

	}

	public  void  test(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					lock.lock();
					try{
						if(queue.size() == 0){
							full.await();
						}
						String str = queue.poll();
						System.out.println("poll:"+str);
						empty.signalAll();
						Thread.sleep(1000);
					}catch(Exception e){
						e.printStackTrace();
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
					lock.lock();
					try{
						if(queue.size() == 10){
							empty.await();
						}
						String s = (new Date()).toString();
						System.out.println(s);
						queue.put(s);
						full.signalAll();
						Thread.sleep(2000);
					}catch(Exception e){
						e.printStackTrace();
					}finally{
						lock.unlock();
					}
				}
			}
		}).start();
	}
}

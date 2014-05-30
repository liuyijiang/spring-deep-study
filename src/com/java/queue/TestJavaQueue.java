package com.java.queue;

import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

import sun.misc.Unsafe;

public class TestJavaQueue {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Unsafe unsafe = Unsafe.getUnsafe();
		 System.out.println(unsafe.addressSize());

	}

	public void testBlockingQueue(){
		BlockingQueue  b = new ArrayBlockingQueue(1);
		b.add("ss");
		//b.put("cc");
		ConcurrentLinkedQueue q = new ConcurrentLinkedQueue();
		AtomicInteger  a = new AtomicInteger();
		//Collections.
		//Collections.min(coll)
	}
	
	public class QueueBean implements Runnable {

		@Override
		public void run() {
			 while(true){
				 
			 }
			
		}
		
	}
	
}

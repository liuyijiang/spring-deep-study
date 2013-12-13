package com.java.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutorFor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService e = (ExecutorService)Executors.newFixedThreadPool(1);
		//Executors.newSingleThreadScheduledExecutor().schedule(command, delay, unit)
		for(int i=0;i<10;i++){
			
			e.execute(new Th(i));
			System.out.println(i);
		}
		System.out.println("ok");
	}

}

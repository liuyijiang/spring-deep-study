package com.java.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TestExecutor {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Server server=new Server();
//		for (int i=0; i<10; i++){
//		Task task=new Task("Task "+i);
//		server.executeTask(task);
//		}
//		server.endServer();
//		ExecutorService executor = Executors.newCachedThreadPool();
//		//executor.
//		for(int i=0;i<5;i++){
//			executor.execute(new Run());
//		}
//		//executor.s
//		executor.shutdown();
		ExecutorService e = (ExecutorService)Executors.newFixedThreadPool(1);
		System.out.println(e.isShutdown());
		System.out.println(e.isTerminated());
	//	e.
//		if(e.isShutdown()){
			e.execute(new Runnable() {
				
				@Override
				public void run() {
					while(true){
						try{
							Thread.sleep(2000);
							System.out.println(22);
						}catch(Exception e){
							e.printStackTrace();
						}
					}
					
				}
			});
			System.out.println("##############shutdwon#############");
			System.out.println(e.isShutdown());
			System.out.println(e.isTerminated());
//		}else{
//			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//		}
		System.out.println("##############shutdwon#############");
	}

}

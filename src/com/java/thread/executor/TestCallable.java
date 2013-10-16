package com.java.thread.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallable {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		ExecutorService executor = Executors.newFixedThreadPool(4);
		List<Future> flist = new ArrayList<Future>();
		for(int i=0;i<4;i++){
			Future future1 = executor.submit(new Call());
			flist.add(future1);
		}
		System.out.println(3);
		executor.shutdown();
		System.out.println(2);
		boolean flag = true;
		System.out.println(1);
        while(flag){
        	for(Future f:flist){
        		System.out.println("loading....");
        		if(f.isDone()){
        			System.out.println(f.get().toString());//get() 会柱塞 直到完成
        			System.out.println(f.isCancelled());
        			f.cancel(true);
        			System.out.println(f.isCancelled());
        		}
        		Thread.sleep(1000);
        	}
        }
	}

}

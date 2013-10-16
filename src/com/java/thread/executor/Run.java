package com.java.thread.executor;

public class Run implements Runnable{

	@Override
	public void run() {
		boolean flag = true;
		try{
			while(flag){
				int i = (int)(Math.random()*10);
				if(i > 8){
					flag = false;
				}else{
					System.out.println(Thread.currentThread().getName()+" leave!");
					Thread.sleep(1000);
				}
			}
			System.out.println(Thread.currentThread().getName()+" dead!");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}

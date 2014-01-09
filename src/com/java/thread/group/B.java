package com.java.thread.group;

public class B  extends GroupBase{

	@Override
	public void tt() {
		System.out.println(this.threadGroup1.getName());
		System.out.println(threadGroup1.activeCount());
		new Thread(this.threadGroup1,new Runnable() {
			
			@Override
			public void run() {
				try{
					System.out.println(3);
					Thread.sleep(3000);
					System.out.println(1);
				}catch(Exception e){
					
				}
				
			}
		}).start();
		
	}
}

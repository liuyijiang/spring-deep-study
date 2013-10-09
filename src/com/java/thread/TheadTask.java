package com.java.thread;

public class TheadTask extends Thread {

	private int times;
	
	public TheadTask(int times){
		this.times  = times;
	}		
	
	public void run(){
		for(int i=0;i<times;i++){
			try{
				System.out.println(Thread.currentThread().getName()+" is run!");
				Thread.sleep(1000);
			}catch(Exception e){
				
			}
		}
		System.out.println(Thread.currentThread().getName()+" is dead!");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TheadTask task1 = new TheadTask(4);
		TheadTask task2 = new TheadTask(8);
		TheadTask task3 = new TheadTask(6);
		WriterTask t = new WriterTask();
		task1.start();
		task2.start();
		task3.start();
		t.start();
		
	}

}

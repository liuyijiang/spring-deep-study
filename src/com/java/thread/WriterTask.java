package com.java.thread;

public class WriterTask extends Thread {
  
	public WriterTask(){
		this.setDaemon(true);
	}
	
	@Override
	public void run() {
		while(true){
			try{
				System.out.println("##############daemon....is run!");
				Thread.sleep(1000);
			}catch(Exception e){
				
			}
		}
		
	}



}

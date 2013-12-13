package com.java.thread.executor;

public class Th implements Runnable{
    
    private int i;
    
    public Th(int i){
 	   this.i = i;
    }
    
		@Override
		public void run() {
			try{
				System.out.println(i+" ****** "+Thread.currentThread().getName());
				Thread.sleep(1000);
			}catch(Exception e){
				
			}
			
			
		}
		
	}

package com.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ch.qos.logback.core.util.SystemInfo;

public class CpuTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String[] str = new String[9999999999999999L];
		//SystemInfo.getJavaVendor()
		
//		JVM jvm = JVMFactory.getJVM();
//		List cpus = new ArrayList();
//		for(Iterator it = JVMFactory.getJVM().getProcessAffinity().iterator();it.hasNext();)
//		{
//		CPU cpu = (CPU) it.next();
//		jvm.suggestProcessAffinity(cpus);
//		}
//		  int busyTime = 10;  
//	        int idleTime = busyTime;  
//	        long startTime = 0;  
//	        while (true) {  
//	            startTime = System.currentTimeMillis();  
//	            // busy loop  
//	            while ((System.currentTimeMillis() - startTime) <= busyTime)  
//	                ;  
//	            // idle loop  
//	            try {  
//	                Thread.sleep(idleTime);  
//	            } catch (InterruptedException e) {  
//	                System.out.println(e);  
//	            }  
//	        }  
		
		for (int i=0;i<4;i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(true){
						int i =0;
						i++;
					}
				}
			}).start();
		}
		

	}

}

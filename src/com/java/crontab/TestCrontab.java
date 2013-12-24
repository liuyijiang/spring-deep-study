package com.java.crontab;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestCrontab {
  
	public static final Logger logger = LoggerFactory.getLogger(TestCrontab.class); 
	
	public static void main(String[] args) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
             logger.debug("#############start running #############");  
			for(int i=0;i<10;i++){
				logger.debug("running for {}",i);  
				Thread.sleep(1000);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		logger.debug("stop runing time {}",formatter.format(new Date()));
		logger.debug("#############stop running #############");  
	}
	
}

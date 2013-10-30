package com.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
/**
 * slf4j logback
 * @author Administrator
 *
 */
public class TestSlf4J {


	public static final Logger logger = LoggerFactory.getLogger(TestSlf4J.class); 
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
         LoggerContext lc = (LoggerContext)LoggerFactory.getILoggerFactory();
         try {
             JoranConfigurator configurator = new JoranConfigurator();
             configurator.setContext(lc);
             lc.reset();
             configurator.doConfigure("conf/logback.xml");
        }
        catch (Exception e) {
          e.printStackTrace();
        }
		 Integer t = 55661132;  
		 Integer oldT = 443;
		 logger.trace("======trace");  
		 logger.debug("======debug");  
		 logger.info("======info");  
		 logger.warn("======warn");  
		 try{
			 int i = 0 / 0;
		 }catch(Exception e){
			 logger.error("error message {}. error StackTrace {}.",e.getMessage(), e);
			 logger.error("error StackTrace ", e);
		 }
		 
		 
		 
////		logger.debug("Temperature set to {}. Old temperature was {}.", t, oldT);  
//		logger.info("Temperature set to {}. Old temperature was {}.", t, oldT);  
//		logger.error("Temperature set to {}. Old temperature was {}.", t, oldT);
		System.out.println(1);
	}
 

}

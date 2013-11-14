package com.mkyong.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkyong.customer.services.CustomerService;

//http://www.mkyong.com/spring/spring-auto-proxy-creator-example/
/**
 * 使用 MethodInterceptor 实现aop
 * @author Administrator
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext appContext = 
    		new ClassPathXmlApplicationContext(new String[] {"Spring-Customer.xml"});
	
    	CustomerService cust = (CustomerService)appContext.getBean("customerService");
    	
    	System.out.println("************start*************");
    	cust.printName("liuyijiang",123);
    	System.out.println("**********end***************");
    	//cust.printURL();
    	//System.out.println("*************************");
    	try{
    		cust.printThrowException();
    	}catch(Exception e){
    		
    	}
    	
    }
}

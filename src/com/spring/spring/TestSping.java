package com.spring.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSping {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		SpingSimpleService task = context.getBean(SpingSimpleService.class);
//		task.spingtest();
		SpringContextAware tt = context.getBean(SpringContextAware.class);
		//SpringContextAware.class.isAssignableFrom(cls)
	}
	
}

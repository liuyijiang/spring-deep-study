package com.spring.spring;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class SpringContextAware implements ApplicationContextAware {

	@Resource
	private SpingSimpleService service;
	
	/**
	 * 实现 ApplicationContextAware 可以获得spring的 ApplicationContext
	 * 加载一些类 ##好处 ： 不用写@Resource @autowriet 那些
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		String[] arr = applicationContext.getBeanNamesForType(SpringInterface.class);//可以获得bean的名称
		for (String str : arr) {
			System.out.println(str);
			SpringInterface ss = applicationContext.getBean(str,SpringInterface.class);
			ss.hhh();
		}
		

	}
    
	public void ss(){
		service.spingtest();
	}
}

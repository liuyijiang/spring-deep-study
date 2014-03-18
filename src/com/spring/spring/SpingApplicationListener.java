package com.spring.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * spring的事件监听
 * @author Administrator
 *
 */
public class SpingApplicationListener implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if(event instanceof SpringApplicationEvent){  
			SpringApplicationEvent animalEvent = (SpringApplicationEvent)event;  
            System.out.println("触发自定义事件：SpringApplicationEvent name is " + animalEvent.getName());  
        }  
		
	}

}

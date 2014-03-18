package com.spring.spring;

import org.springframework.context.ApplicationEvent;

/**
 * spring中的自定义事件
 * @author Administrator
 *
 */
public class SpringApplicationEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2456319180124694855L;
	private String name;  
    
    public String getName() {  
        return name;  
    }  
  
    /** 
     * @param source 事件源对象 
     */  
    public SpringApplicationEvent(Object source){  
        super(source);  
    }  
      
    public SpringApplicationEvent(Object source, String name){  
        super(source);  
        this.name = name;  
    }  
	
}

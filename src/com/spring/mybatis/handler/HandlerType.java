package com.spring.mybatis.handler;

public enum HandlerType {
   
	SUCCESS(200),ERROR(404);
	
    private int code; 
        
    private HandlerType(int code) { 
        this.code = code; 
    } 
        
    public int getCode() { 
        return this.code; 
    } 
}

package com.spring.spring;

import org.springframework.stereotype.Service;

@Service
public class SpingSimpleService implements SpringInterface{
  
	public void spingtest(){
		System.out.println("**********************************111111");
	}

	@Override
	public void hhh() {
		System.out.println("*******************hhhh***************SpingSimpleService");
		
	}
	
}

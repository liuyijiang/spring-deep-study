package com.spring.annotaion.service;

import org.springframework.stereotype.Service;

import com.java.base.Bean;

@Service
public class TestAopService {

	public Bean find(Integer id){
		Bean b = new Bean();
		b.setBean_str1(222);
		return b;
	}
	
}

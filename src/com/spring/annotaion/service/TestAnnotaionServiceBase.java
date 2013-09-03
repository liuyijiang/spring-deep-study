package com.spring.annotaion.service;

public abstract class TestAnnotaionServiceBase {
  
	public abstract <T> T findDataById(int id,Class<T> clazs);
	
}

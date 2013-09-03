package com.spring.ssl.service;

import java.util.UUID;

import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	@Autowired
	@Qualifier("memcachedClient")
	private MemcachedClient mc;
	
	public String loginIn(){
		String key = UUID.randomUUID().toString();
		String value = "login";//这个value可以是用户的id key value 登录后将key value放入缓存
		mc.set(key, 40000, value);
		return key;
	}
	
	public boolean checkUser(String key){
		CASValue<Object> casValue = mc.getAndTouch(key, 40000);
		String data = null;
		if (casValue != null){
			data = casValue.getValue().toString();
			System.out.println("from memncashed:"+data);
			return true;
		} else {
			return false;
		}
	}
}

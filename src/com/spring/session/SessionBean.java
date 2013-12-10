package com.spring.session;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class SessionBean {
  
	private long id;
	private String name;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String value) {
		this.name = value;
//		try {
//			this.name = URLEncoder.encode(value,"UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
	}
	
//	public void decode(){
//		try {
//			this.name =  URLDecoder.decode(this.name,"UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//	}
	
	@Override
	public String toString(){
		return "id: "+id + "name: " +name;
	}
	
}

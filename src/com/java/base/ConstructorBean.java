package com.java.base;

public class ConstructorBean {
    
	private Bean bean;
	private String str;
	
	public ConstructorBean(){
		
	}
	
	public ConstructorBean(Bean bean ,String str){
		this.bean = bean;
		this.str = str;
	}

	public Bean getBean() {
		return bean;
	}

	public void setBean(Bean bean) {
		this.bean = bean;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	
}

package com.mkyong.customer.services;

import com.spring.annotaion.annotaion.Cashable;

public class CustomerService
{
	private String name;
	private String url;

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Cashable(cashed = false)
	public void printName(String name,int age){
		System.out.println("Customer name : " + name + "id: " + age);
	}
	
	public void printURL(){
		System.out.println("Customer website : " + this.url);
	}
	
	public void printThrowException(){
		throw new IllegalArgumentException();
	}
	
}

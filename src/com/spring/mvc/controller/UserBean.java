package com.spring.mvc.controller;

import java.util.Date;

import org.aspectj.lang.annotation.DeclareMixin;

import com.sun.istack.internal.NotNull;

public class UserBean {

	@NotNull
	private String name;
	
	//@DeclareMixin
	private int age;
	private String email;
	private Date bith;
	
	
}

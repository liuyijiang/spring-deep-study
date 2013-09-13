package com.spring.interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.interceptor.annotain.LoginRequired;

@Controller
public class InterceptorController {

	@LoginRequired
	@RequestMapping(value = "/intindex", method = RequestMethod.GET)
	public ModelAndView index(){
		return new ModelAndView("index.jsp");
	}
	
	@RequestMapping(value = "/test/interceptor", method = RequestMethod.GET)
	public ModelAndView indexUpdate(){
		return new ModelAndView("index.jsp");
	}
	
	@LoginRequired(required = false)
	@RequestMapping(value = "/intlogin", method = RequestMethod.GET)
	public ModelAndView login(){
		return new ModelAndView("security_login.jsp");
	}
	
	
	@RequestMapping(value = "/inttest", method = RequestMethod.GET)
	@ResponseBody
	public String testAnnotain(){
		return "cash_save";
	} 
	
}

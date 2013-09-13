package com.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {

	@RequestMapping(value = "/sindex", method = RequestMethod.GET)
	public ModelAndView index(){
		return new ModelAndView("index.jsp");
	}
	
	@RequestMapping(value = "/slogin", method = RequestMethod.GET)
	public ModelAndView login(){
		return new ModelAndView("security_login.jsp");
	}
	
}

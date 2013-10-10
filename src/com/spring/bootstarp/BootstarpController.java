package com.spring.bootstarp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BootstarpController {

	@RequestMapping(value = "/bindex", method = RequestMethod.GET)
	public ModelAndView bindex(){
		return new ModelAndView("bindex.jsp");
	}
	
	@RequestMapping(value = "/js", method = RequestMethod.GET)
	public ModelAndView jsStudy(){
		return new ModelAndView("jsstudy.jsp");
	}
}

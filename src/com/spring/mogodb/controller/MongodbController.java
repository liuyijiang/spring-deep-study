package com.spring.mogodb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MongodbController {
  
	@RequestMapping(value = "/mogindex", method = RequestMethod.GET)
	@ResponseBody
	public String bindex(){
		return "ok";
	}
	
	
}

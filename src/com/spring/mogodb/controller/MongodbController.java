package com.spring.mogodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.mogodb.dao.MongodbDaoTemplate;

@Controller
public class MongodbController {
  
	@Autowired
	private MongodbDaoTemplate template;
	
	@RequestMapping(value = "/mogindex", method = RequestMethod.GET)
	@ResponseBody
	public String bindex(){
		template.find();
		return "ok";
	}
	
	
}

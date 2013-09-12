package com.spring.annotaion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.annotaion.service.TestAnnotaionService;
import com.spring.hibernate.entity.Ship;

@Controller
public class AnnotainController {

	//@Autowired
	private TestAnnotaionService tas;
	
	@RequestMapping(value = "/test1/{type}", method = RequestMethod.GET)
	@ResponseBody
	public String testAnnotain(@PathVariable("type") int type){
		tas.testSave(type);
		return "cash_save";
	}
	
	@RequestMapping(value = "/test2/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String testfindAnnotain(@PathVariable("id") int id){
		Ship s = tas.findDataById(id, Ship.class);
		String re ="ss";
		if(s != null){
			re = s.getName();
		}
		return re;
	}
	
}

package com.spring.jdbctemplet.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Ship;
import com.spring.jdbctemplet.service.JdbcService;

@Controller
public class JdbcTemplateController {

	@Autowired
	private JdbcService service;
	
	@RequestMapping(value = "/templatesave/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String mybsave(@PathVariable("id") int id){
		Ship ship = new Ship();
		String str = (new Date()).toString();
		ship.setId(id);
		ship.setName("google2 "+str);
		service.saveShip(ship);
		return str;
	}
	
}

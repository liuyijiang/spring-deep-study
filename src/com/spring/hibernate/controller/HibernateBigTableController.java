package com.spring.hibernate.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.annotaion.service.TestAopService;
import com.spring.hibernate.dao.UserDao;
import com.spring.hibernate.entity.Ship;

@Controller
public class HibernateBigTableController {
   
	@Autowired
	private UserDao dao;
	
	@Autowired
	private TestAopService ap;
	
	@RequestMapping(value = "/testhib", method = RequestMethod.GET)
	@ResponseBody
	public void testsave(){
		Ship ship = new Ship();
		ship.setCreate(new Date());
		ship.setName("llll");
		//dao.saveData(ship);
		System.out.println(ship.getId());
	}
	
	@RequestMapping(value = "/testhibs", method = RequestMethod.GET)
	@ResponseBody
	public void testsaves(){
		Ship ship = new Ship();
		ship.setCreate(new Date());
		ship.setName("llll222");
		ap.find(1);
		dao.teave(ship);
		System.out.println(ship.getId());
	}
	
}

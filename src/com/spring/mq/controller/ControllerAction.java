package com.spring.mq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.mq.service.BaseMessageService;

@Controller
public class ControllerAction {

	@Autowired
	private BaseMessageService bs;
	
	@RequestMapping(value = "/ms", method = RequestMethod.GET)
	@ResponseBody
	public String flushAristImages(){
		bs.sendData();
		bs.sendToQueue();
		return "to-mq-ok";
	}
	
	
}

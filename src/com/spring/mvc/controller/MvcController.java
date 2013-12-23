package com.spring.mvc.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Ship;

@Controller
public class MvcController {

	/**
	 * 初始话一个值
	 * @return
	 */
	@ModelAttribute
	private Ship ship(){
		Ship s = new Ship();
		s.setCreate(new Date());
		s.setId(1);
		s.setName("ship 1");
		return s;
	}
	
	@RequestMapping(value = "/mvcindex", method = RequestMethod.GET)
	public ModelAndView index(@ModelAttribute Ship ship){
		System.out.println(ship.toString());
		return new ModelAndView("mvcindex.jsp");
	}
	
	/**
	 * 匹配
	 * @return
	 */
	@RequestMapping(value = "/mvcindex/mm?/*/{userid}", method = RequestMethod.GET)
	public ModelAndView indexPrem(@PathVariable("userid") String useid){
		System.out.println("*****************************************************"+useid);
		return new ModelAndView("mvcindex.jsp");
	}
	
	/**
	 * 
	 * @param useid
	 * @return
	 */
	@RequestMapping(value = "/mvcindex/mm/p", method = RequestMethod.GET)
	public ModelAndView indexPremp(@RequestParam("userid") String useid){
		System.out.println("*****************************************************"+useid);
		return new ModelAndView("mvcindex.jsp");
	}
	
}

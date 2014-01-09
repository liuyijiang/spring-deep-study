package com.spring.http;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HttpController {

	@RequestMapping(value = "/httpindex", method = RequestMethod.GET)
	public void testPW(HttpServletRequest r,HttpServletResponse p){
		try {
			p.getWriter().write("jimliui");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

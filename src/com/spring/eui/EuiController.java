package com.spring.eui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EuiController {

	@RequestMapping(value = "/euijs", method = RequestMethod.GET)
	public ModelAndView jsStudy(){
		return new ModelAndView("eui/eui_test.jsp");
	}
	
}

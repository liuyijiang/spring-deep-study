package com.spring.session;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

/**
 * 使用cokie来做分布式集群
 * @author Administrator
 *
 */
@Controller
public class SessionController {

	@RequestMapping(value = "/cookie/index", method = RequestMethod.GET)
	public ModelAndView index(HttpServletResponse response){
		Cookie cookie = new Cookie("cartCookie","liuyijiangss");  
	    cookie.setMaxAge(60*60*24*7);//保留7天  
	    response.addCookie(cookie);
		return new ModelAndView("cindex.jsp");
	}
   
	@RequestMapping(value = "/cookie/cookie", method = RequestMethod.GET)
	public ModelAndView cookie(@CookieValue(value = "cartCookie",required  = false) String cartCookie){
		System.out.println(cartCookie);
		return new ModelAndView("cindex.jsp");
	}
}

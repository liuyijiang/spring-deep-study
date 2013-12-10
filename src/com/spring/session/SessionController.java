package com.spring.session;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import com.java.base.Sta;

/**
 * 使用cokie来做分布式集群
 * @author Administrator
 *
 */
@Controller
public class SessionController {

	@Autowired
	private SessionContext sessionContext;
	
	@RequestMapping(value = "/cookie/index", method = RequestMethod.GET)
	public ModelAndView index(HttpServletResponse response){
		System.out.println(sessionContext.toString());
		SessionBean bean = new SessionBean();
		bean.setId(12345343047291333L);
		bean.setName("liuyijiang");
		sessionContext.session(response, bean, 72000);
		return new ModelAndView("bindex.jsp");
	}
   
	@RequestMapping(value = "/cookie/cookie", method = RequestMethod.GET)
	public ModelAndView cookie(@CookieValue(value = "cartCookie",required  = false) String cartCookie){
		System.out.println(cartCookie);
		return new ModelAndView("bindex.jsp");
	}
	
	@RequestMapping(value = "/cookie/session", method = RequestMethod.GET)
	public ModelAndView session(){
		Sta.tt();
		System.out.println(sessionContext.toString());
		if(sessionContext.getSession() != null)
		System.out.println(sessionContext.getSession().toString());
		return new ModelAndView("bindex.jsp");
	}
}

package com.spring.ssl.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.ssl.request.LoginForm;
import com.spring.ssl.service.LoginService;

@Controller
public class SSLLoginController {

	//@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/sslindex", method = RequestMethod.GET)
	public ModelAndView index(){
		return new ModelAndView("index.jsp");
	}
	
	@RequestMapping(value = "/ssllogin", method = RequestMethod.GET)
	public ModelAndView ssllogin(){
		return new ModelAndView("login.jsp");
	}
	
	//登录成功会到这个页面
	@RequestMapping(value = "/userindex", method = RequestMethod.GET)
	public ModelAndView useindex(@CookieValue(value="token",required=false) String key,HttpServletRequest req){
		ModelAndView model = new ModelAndView("userindex.jsp");
		if(key != null && key!="" && loginService.checkUser(key)){
			req.setAttribute("message", "login success");
		}else{
			req.setAttribute("message", "no login");
		}
		return model;
	}
	
	@RequestMapping(value = "/loginOut", method = RequestMethod.GET)
	public ModelAndView loginOut(HttpServletResponse response){
		Cookie cookie = new Cookie("token","");  
		response.addCookie(cookie);  
		return new ModelAndView("index.jsp");
	}
	
	//异步
	/**
	 * @PathVariable           用于接收路径变量

@RequestParam         相当于调用request.getParameter(“name”)方法

@CookieValue           获取cookie的值

@RequestHeader        获取header中的值
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/loginSync?*", method = {RequestMethod.GET,RequestMethod.POST})
	public String SSLLoginSync(HttpServletRequest request,HttpServletResponse response){
		String str = request.getParameter("name");
		String psw = request.getParameter("psw");
		System.out.println(str + "*****" + psw);
		//response.sendRedirect("/ssllogin/ok.jsp");  一般方式
		//ajax 方式
		System.out.println("get");
		response.setContentType("text/plain");// 1.设置返回响应的类型
		//2. 01 一定要注意：要包括jsoncallback参数，不然回调函数不执行。
		//2. 02 返回的数据一定要是严格符合json格式 ，不然回调函数不执行。
		//response.getWriter().write( request.getParameter("jsoncallback") + "({isAuth:'"+str+"',psw:'"+psw+"',resetnum:'"+200+"'})" );
		return request.getParameter("jsoncallback") + "({isAuth:'"+str+"',psw:'"+psw+"',resetnum:'"+200+"'})";
	}
	
	//同步
	@RequestMapping(value = "/loginIn", method = RequestMethod.POST)
	public String SSLLoginIn(LoginForm from,HttpServletResponse response){
		System.out.println(from.getName()+"***"+from.getPass());
		if(from.getName().equals("root")&&from.getPass().equals("root")){
			String key = loginService.loginIn();
			Cookie cookie = new Cookie("token",key);  
			cookie.setMaxAge(60*60*24*7);//保留7天  
			response.addCookie(cookie);  
			return "redirect:/userindex"; //"forward:/userindex"
		}else{
			return "redirect:/sslindex"; //"forward:/userindex"
		}
	
	}
	
}

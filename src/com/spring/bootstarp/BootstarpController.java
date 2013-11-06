package com.spring.bootstarp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.alibaba.fastjson.JSON;
import com.spring.restfull.service.request.ResendRequest;
import com.spring.restfull.service.vo.UserVO;
/**
 * 测试js bootstarp等
 * @author Administrator
 *
 */
@Controller
public class BootstarpController {

	@RequestMapping(value = "/bindex", method = RequestMethod.GET)
	public ModelAndView bindex(){
		return new ModelAndView("bindex.jsp");
	}
	
	@RequestMapping(value = "/js", method = RequestMethod.GET)
	public ModelAndView jsStudy(){
		return new ModelAndView("jsstudy.jsp");
	}
	
	@RequestMapping(value = "/jsweb", method = RequestMethod.GET)
	public ModelAndView jsWebStudy(){
		return new ModelAndView("jswebstudy.jsp");
	}
	
	@RequestMapping(value = "/bajaxgetp", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public UserVO getDataParm(@RequestBody ResendRequest request){
		UserVO vo = new UserVO();
		vo.setId(1);
		vo.setName("jim" +1111+request.getEndTime());
		return vo;
	}
	
	@RequestMapping(value = "/bajaxget", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public UserVO getData(){
		UserVO vo = new UserVO();
		vo.setId(1);
		vo.setName("jim" +2222);
		return vo;
	}
	
	/**
	 * jsonp 列子
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/bajaxgetjsonp", method = {RequestMethod.GET})
	@ResponseBody
	public void getDataJsonp(HttpServletRequest request,HttpServletResponse response) throws IOException{
		UserVO vo = new UserVO();
		vo.setId(1);
		vo.setName("jim" +2222345);
		String str = request.getParameter("callback");
		response.setContentType("text/javascript");  
		PrintWriter out = response.getWriter();  
		out.write(str + "(" + JSON.toJSON(vo).toString() +");"); 
	}
	
	
	//标准的返回jsonp
	@RequestMapping(value = "/jsonpview", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView getJsonView(){
		UserVO vo = new UserVO();
		vo.setId(12);
		vo.setName("jimanan刘一江" +2222);
		//MappingJacksonJsonpView v = new MappingJacksonJsonpView();
		Map<String,String> mp = new HashMap<String,String>();
		mp.put("name","jim-liuyijiang");
		ModelAndView m = new ModelAndView();
		m.addObject(vo);
		//View v = new View();
		//m.setView(v)
		return m;
	}
	
	
	@RequestMapping(value = "/jsonpbodyview", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public UserVO getJsonbodyView(){
		UserVO vo = new UserVO();
		vo.setId(1);
		vo.setName("jim" +2222);
		//MappingJacksonJsonpView v = new MappingJacksonJsonpView();
//		Map<String,String> mp = new HashMap<String,String>();
//		mp.put("name","jim-liuyijiang");
//		ModelAndView m = new ModelAndView("",mp);
		//View v = new View();
		//m.setView(v)
		return vo;
	}
	
}

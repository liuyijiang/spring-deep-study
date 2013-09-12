package com.spring.restfull.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.restfull.service.request.ResendRequest;
import com.spring.restfull.service.vo.UserVO;

@Controller
public class RestFullService {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(){
		return new ModelAndView("index.jsp");
	}
	
	@RequestMapping(value = "/getData", method = RequestMethod.GET)
	@ResponseBody
	public UserVO getData(){
		UserVO vo = new UserVO();
		vo.setId(1);
		vo.setName("jim");
		return vo;
	}
	
	@RequestMapping(value = "/getDataParm", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public UserVO getDataParm(@RequestBody ResendRequest request){
		UserVO vo = new UserVO();
		vo.setId(1);
		vo.setName("jim" +1111);
		return vo;
	}
	@RequestMapping(value = "/getDataParms", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public UserVO getDataParms(HttpServletRequest request){
		//HttpServletRequest request
		MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) request;
		System.out.println(mrequest.getParameter("type"));
//		System.out.println(mrequest.getParameter("startTime"));
		UserVO vo = new UserVO();
		vo.setId(1);
		vo.setName("jim" +1111);
		return vo;
	}
	
	@RequestMapping(value = "/putDataParm", method = RequestMethod.PUT)
	@ResponseBody
	public UserVO putDataParm(@RequestBody ResendRequest request){
		UserVO vo = new UserVO();
		vo.setId(1);
		vo.setName("put jim" + request.getEndTime() + "##"+request.getStartTime()+"**"+request.getType());
		return vo;
	}
	
	
	@RequestMapping(value = "/deleteDataParm", method = RequestMethod.DELETE)
	@ResponseBody
	public UserVO deleteDataParm(@RequestBody ResendRequest request){
		UserVO vo = new UserVO();
		vo.setId(1);
		vo.setName("delete jim" + request.getEndTime() + "##"+request.getStartTime()+"**"+request.getType());
		return vo;
	}
	
}

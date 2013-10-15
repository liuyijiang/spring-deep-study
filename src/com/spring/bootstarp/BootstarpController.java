package com.spring.bootstarp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
}

package com.spring.maven;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * 把lib文件夹下的loadcompletejar.txt 放在D盘
 * @author Administrator
 *
 */
@Controller
public class LoadMavenController {
    
	
	@RequestMapping(value = "/mavenlist", method = RequestMethod.GET)
	public ModelAndView bindex(){
		LoadMavenService ls = new LoadMavenService();
		List<MavenBean> list = ls.getLoadInstallJar();
		return new ModelAndView("mavenlist.jsp","list",list);
	}
	
}

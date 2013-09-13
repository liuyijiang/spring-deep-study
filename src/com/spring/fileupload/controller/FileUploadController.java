package com.spring.fileupload.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.spring.fileupload.request.UploadReponse;
import com.spring.fileupload.request.UserRequest;
import com.spring.fileupload.service.FileUploadService;

@Controller
public class FileUploadController {

	@Autowired
	private FileUploadService service;
	
	@RequestMapping(value = "/uploadindex", method = RequestMethod.GET)
	public ModelAndView index(){
		return new ModelAndView("uploadindex.jsp");
	}
	
	//同步上传
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView uploadFile(HttpServletRequest request) throws Exception{
		//转型为MultipartHttpRequest(重点的所在)  
        MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;  
        //  获得第1张图片（根据前台的name名称得到上传的文件）   
        MultipartFile imgFile =  multipartRequest.getFile("imgFile"); 
        System.out.println(imgFile.getOriginalFilename());
        System.out.println(imgFile.getContentType());
        System.out.println(imgFile.getName());
        service.uploadFile(imgFile.getInputStream(),imgFile.getOriginalFilename());
		return new ModelAndView("index.jsp");
	}
	
	//使用ajaxfileupload.js
	@RequestMapping(value = "/uploadajax", method = RequestMethod.POST)
	public void uploadFileAjax(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//转型为MultipartHttpRequest(重点的所在)  
        MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;  
        System.out.println(multipartRequest.getParameter("startTime"));
        System.out.println(multipartRequest.getParameter("type"));
        //  获得第1张图片（根据前台的name名称得到上传的文件）   
        MultipartFile imgFile =  multipartRequest.getFile("imgFile"); 
        System.out.println(imgFile.getOriginalFilename());
        System.out.println(imgFile.getContentType());
        System.out.println(imgFile.getName());
        service.uploadFile(imgFile.getInputStream(),imgFile.getOriginalFilename());
        JSONObject jsonObject = new JSONObject();  
        jsonObject.put("path", "sss");  
        response.setContentType("text/html");  
        response.getWriter().println(jsonObject.toString()); 
	}
	
	//使用jQuery.form.js
	@RequestMapping(value = "/uploadajaxfrom", method = RequestMethod.POST)
	@ResponseBody
	public UploadReponse uploadFileAjaxFrom(UserRequest use,HttpServletResponse response) throws Exception{
		if(use != null){
			System.out.println(use.getName());
			System.out.println(use.getSex());
			//service.uploadFile(use.getImage(),"jj.jpg");
		}
//		JSONObject jsonObject = new JSONObject();  
//        jsonObject.put("path", "sss");  
//        response.setContentType("text/html");  
//        response.getWriter().println(jsonObject.toString());
		UploadReponse r = new UploadReponse();
		r.setMessage("你好");
		return r;
	}
	
}

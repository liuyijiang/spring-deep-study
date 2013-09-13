package com.spring.fileupload.request;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class UserRequest {
   
	private String name;
	private String sex;
	private MultipartFile image;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
    	
	
	
}

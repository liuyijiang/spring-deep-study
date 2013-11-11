package com.spring.mogodb.bean;

import org.springframework.data.annotation.Id;

public class MapBean {
    
	@Id
	private String id;
	private Double[] loc;
	private String place;
	
	public Double[] getLoc() {
		return loc;
	}
	public void setLoc(Double[] loc) {
		this.loc = loc;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
    
	
	
	
	
	
}

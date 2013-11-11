package com.spring.mogodb.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.Point;

public class MapPointBean {
   
	@Id
	private String id;
	private String place;
	private Point point;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	
	
}

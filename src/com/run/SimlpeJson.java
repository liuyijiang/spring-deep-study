package com.run;

import java.util.Date;

import com.google.gson.annotations.Expose;

public class SimlpeJson {
  
	private int id;
	private String name;
	private Long lo;
	@Expose
	private String value;
	private Date time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Long getLo() {
		return lo;
	}
	public void setLo(Long lo) {
		this.lo = lo;
	}
	
	
	
}

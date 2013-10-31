package com.java.base;

import javax.persistence.Table;

@Table(name="ss")
public class Bean {
  
	private int bean_str1;
	private String bean_str2;
	private String bean_str3;
	private long bean_str4;
	
	public int getBean_str1() {
		return bean_str1;
	}
	public void setBean_str1(int bean_str1) {
		this.bean_str1 = bean_str1;
	}
	public String getBean_str2() {
		return bean_str2;
	}
	public void setBean_str2(String bean_str2) {
		this.bean_str2 = bean_str2;
	}
	public String getBean_str3() {
		return bean_str3;
	}
	public void setBean_str3(String bean_str3) {
		this.bean_str3 = bean_str3;
	}
	public long getBean_str4() {
		return bean_str4;
	}
	public void setBean_str4(long bean_str4) {
		this.bean_str4 = bean_str4;
	}
	
	
}

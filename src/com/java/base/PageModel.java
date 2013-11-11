package com.java.base;

import java.util.ArrayList;
import java.util.List;

public class PageModel<E> {
   
	private int page;
	private List<E> list = new ArrayList<E>();
	//private List<?> s =new  ArrayList<E>();
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	public void add(E e){
		list.add(e);
	}
	
	public List<E> getList() {
		return list;
	}
	
	
	
}

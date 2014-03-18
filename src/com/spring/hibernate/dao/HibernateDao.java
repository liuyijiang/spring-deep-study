package com.spring.hibernate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class HibernateDao<T> {
  
	private Class<T> clazs;
	
	//@Autowired
	HibernateTemplate templete;
	
	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> T saveData(Object obj){
		templete.save(obj);
		return (T) obj;
	}
	
	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> T findDateById(int id){
		return (T) templete.get(clazs, id);
	}
	
}

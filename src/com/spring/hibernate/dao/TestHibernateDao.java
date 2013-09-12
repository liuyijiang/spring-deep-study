package com.spring.hibernate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

//@Component
public class TestHibernateDao {
 
	//@Autowired
	private HibernateTemplate templete;   
	
	@SuppressWarnings("unchecked")
	public <T> T saveData(Object obj,Class<T> clazs){
		templete.save(obj);
		return (T) obj;
	}
	
	public <T> T findDateById(int id,Class<T> clazs){
		return templete.get(clazs, id);
	}
	
}

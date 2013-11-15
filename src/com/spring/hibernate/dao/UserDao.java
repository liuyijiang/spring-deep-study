package com.spring.hibernate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.spring.hibernate.entity.Ship;


@Service
public class UserDao {
   
	@Autowired
	private HibernateTemplate templete;
	
	public void teave(Object obj){
		templete.get(Ship.class, 2);
		System.out.println(1);
	}
	
}

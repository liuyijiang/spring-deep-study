package com.spring.annotaion.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.annotaion.annotaion.Cashable;
import com.spring.hibernate.dao.TestHibernateDao;
import com.spring.hibernate.entity.Ship;
import com.spring.hibernate.entity.Tank;

//@Service
public class TestAnnotaionService extends TestAnnotaionServiceBase {

	//@Autowired
	private TestHibernateDao dao;
	
	@Cashable(cashed = false)//不缓存
	public <T> T findDataById(int id,Class<T> clazs){
		System.out.println("id: "+ id +"  been saved" + clazs);
		return dao.findDateById(id, clazs);
	}
	
	@Transactional
	//@Cashable(cashed = true, exptime = 3000) //注解的方式标志这个缓存
	@Cashable
	public Object testSave(int type){
		if(type==1){
			Ship s = new Ship();
			s.setName(new Date().toString());
			return dao.saveData(s,Ship.class);
		}else{
			Tank t = new Tank();
			t.setName(new Date().toString());
			return dao.saveData(t,Tank.class);
		}
		
	}
	
}

package com.spring.jdbctemplet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Ship;
import com.spring.jdbctemplet.dao.ShipDao;

@Service
@Transactional
public class JdbcService {

	@Autowired
	private ShipDao shipDao;
	
	@Transactional(rollbackFor=Exception.class)
    public void saveShip(Ship ship){
		//try{
	    	shipDao.saveShip(ship);
	    	 throw new RuntimeException();
//	        List list = null;
//	    	System.out.println(list.size());
		//}catch(Exception e){
		//	e.printStackTrace();
		//}
	}
}

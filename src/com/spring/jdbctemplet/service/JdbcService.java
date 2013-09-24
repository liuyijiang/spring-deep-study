package com.spring.jdbctemplet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Ship;
import com.spring.jdbctemplet.dao.ShipDao;

@Service
public class JdbcService {

	@Autowired
	private ShipDao shipDao;
	
	@Transactional(rollbackFor=Exception.class)
    public void saveShip(Ship ship){
		try{
    	shipDao.saveShip(ship);
    	int i = 0/0;
    	System.out.println(i);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

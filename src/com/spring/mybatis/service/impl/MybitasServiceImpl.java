package com.spring.mybatis.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Ship;
import com.spring.mybatis.dao.mapper.ShipMapper;
import com.spring.mybatis.service.MybitasService;

@Service
public class MybitasServiceImpl implements MybitasService{
   
	//@Autowired
    private ShipMapper shipMapper;
	
    public Ship selectShip(int id){
    	return shipMapper.selectShip(id);
    }
	
	public void saveShip(Ship ship){
    	//ship
    	shipMapper.insertShip(ship);
		
	}

    public void updateShip(Ship ship){
    	try{
    		shipMapper.updateShip(1);
        	//shipMapper.insertShip(ship);
        	int i = 0 / 0;
        	System.out.println(i);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    
	public ShipMapper getShipMapper() {
		return shipMapper;
	}

//	@Resource  
//	public void setShipMapper(ShipMapper shipMapper) {
//		this.shipMapper = shipMapper;
//	}
	
	
	
}

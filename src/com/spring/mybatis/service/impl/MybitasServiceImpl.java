package com.spring.mybatis.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Ship;
import com.spring.mybatis.dao.mapper.ShipMapper;
import com.spring.mybatis.service.MybitasService;

@Service
public class MybitasServiceImpl implements MybitasService{
   
	@Autowired
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

	@Override
	public void saveShipAuto(Ship ship) {
		shipMapper.insertShipAuto(ship);
		
	}

	@Override
	public void createbigData() {
		Calendar calendar=Calendar.getInstance();   
		for(int i=0;i<100000;i++){
			Date tody = new Date();
			calendar.setTime(tody); 
			calendar.add(Calendar.DAY_OF_MONTH,i);
			Ship ship = new Ship();
			ship.setCreate(calendar.getTime());
			ship.setName("ship number"+i);
			shipMapper.insertShipAuto(ship);
			System.out.println("-------------"+ i +"-------------");
		}
	}
   
//	public static void main(String[] args) {
//		
//	}
	
//	@Resource  
//	public void setShipMapper(ShipMapper shipMapper) {
//		this.shipMapper = shipMapper;
//	}
	
	
	
}

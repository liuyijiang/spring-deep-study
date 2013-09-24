package com.spring.mybatis.dao.mapper;

import com.model.Ship;

public interface ShipMapper {
  
	public Ship selectShip(int id);
	
	public void insertShip(Ship ship);
	
	public void updateShip(int id);
}

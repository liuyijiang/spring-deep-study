package com.spring.mybatis.dao.mapper;

import java.util.List;
import java.util.Map;

import com.model.Ship;

public interface ShipMapper {
  
	public Ship selectShip(int id);
	
	public void insertShip(Ship ship);
	
	public void updateShip(int id);
	
	public void insertShipAuto(Ship ship);
	
	public String callssd(Map param);
	
	public Integer callss(Map<String,Object> param);
	
	public List<Bean> callshow(Map<String,Object> param);
}

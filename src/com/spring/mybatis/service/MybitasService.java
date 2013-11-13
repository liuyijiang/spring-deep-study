package com.spring.mybatis.service;

import com.model.Ship;

public interface MybitasService {

    public Ship selectShip(int id);
	
	public void saveShip(Ship ship);
	
	public void saveShipAuto(Ship ship);

    public void updateShip(Ship ship);
	
    public void createbigData();
}

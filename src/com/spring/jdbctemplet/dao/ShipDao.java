package com.spring.jdbctemplet.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Ship;
import com.spring.jdbctemplet.database.JDBCAccess;

@Component
public class ShipDao {
  
	//@Autowired
	private JDBCAccess access;
	
	public void saveShip(Ship ship){
		String sql = "insert into tb_ship values(?,?)";
		access.execute(sql, new Object[] {ship.getId(),ship.getName()});
	}
	
}

package com.spring.mogodb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import com.spring.mogodb.bean.MapBean;

@Component
public class MongodbDaoTemplate {

	@Autowired
	private MongoOperations mog; 
	
	public void save(MapBean bean){
		mog.save(bean);
	}
	
}

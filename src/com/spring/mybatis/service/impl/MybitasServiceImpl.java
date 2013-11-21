package com.spring.mybatis.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Ship;
import com.spring.mybatis.dao.mapper.Bean;
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

	@Transactional
    public void updateShip(Ship ship){
		try{
    		shipMapper.updateShip(ship.getId());
        	//shipMapper.insertShip(ship);
        	int i = 0 / 0;
        	System.out.println(i);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("error sql");
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

	@Override
	public Ship saveUserEntity(Ship ship) {
		ship.setId(2);
		return ship;
	}

	@Override
	public void call(int page) {
		//无in参数返回字符串的call --test ok
		//calltest1();
		//有in参数返回数字的call -- test ok
		//calltest2();
		//返回集合的存储过程call
		calltest3();
	}
   
	private void calltest1(){
		 HashMap params = new HashMap();   
		 params.put("result", "");   
		 shipMapper.callssd(params);
		 String result = (String) params.get("result"); 
		 System.out.println(result);
	}
	
	//mysql 不需要 out 参数
	private void calltest2(){
		 HashMap<String,Object> params = new HashMap<String,Object>();   
		 params.put("b", 1);  
		 params.put("a", 4);
		 params.put("c", null);
		 shipMapper.callss(params);
		 Integer result = (Integer) params.get("c"); //这里遇到一个问题 返回值是jdbcType=INTEGER 接口返回值要是INTEGER 不能是int
		 System.out.println(result);
	}
	
	private void calltest3(){
		 HashMap<String,Object> params = new HashMap<String,Object>();   
		 params.put("pag", 0); 
		 List<Bean> list = shipMapper.callshow(params);
		 if(list != null){
			 for (Bean bean : list){
				 System.out.println(bean.getInfo() + " -  " + bean.getSocre());
			 }
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

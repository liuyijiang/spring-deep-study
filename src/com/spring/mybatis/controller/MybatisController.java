package com.spring.mybatis.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.Ship;
import com.model.TbHandler;
import com.spring.mybatis.dao.mapper.ShipMapper;
import com.spring.mybatis.handler.HandlerType;
import com.spring.mybatis.service.MybitasService;

@Controller
public class MybatisController {

	//@Autowired
    private MybitasService service;	
	
	//@Autowired
    private ShipMapper shipMapper;
	
	
	@RequestMapping(value = "/handler", method = RequestMethod.GET)
	@ResponseBody
	public String handler(){
		TbHandler tb = new TbHandler();
		tb.setName("test4");
		tb.setStats(HandlerType.ERROR);
//		TbHandler tb2 = new TbHandler();
//		tb.setName("test3");
//		tb.setStats(HandlerType.SUCCESS);
		try{
		shipMapper.inserthander(tb);
//		shipMapper.inserthander(tb2);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "ok";
	}
	
	@RequestMapping(value = "/handler/find", method = RequestMethod.GET)
	@ResponseBody
	public String handlerfind(){
		try{
		   List<TbHandler> list = shipMapper.selectthander();
		   for (TbHandler t:list) {
			   System.out.println(t.getName()+" -- "+t.getStats());
		   }
		}catch(Exception e){
			e.printStackTrace();
		}
		return "ok";
	}
	
	//mybatis掉存储过程
	@RequestMapping(value = "/call/{page}", method = RequestMethod.GET)
	@ResponseBody
	public String call(@PathVariable("page") int id){
		service.call(id);//test
		return "ok";
	}
	
	@RequestMapping(value = "/mybindex", method = RequestMethod.GET)
	public ModelAndView bindex(){
		Ship ship = new Ship();
		ship.setName("m1212");
		ship.setCreate(new Date());
		service.saveUserEntity(ship);
		return new ModelAndView("mybindex.jsp");
	}
	
	@RequestMapping(value = "/mybupdte/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String mybupdte(@PathVariable("id") int id){
		Ship ship = new Ship();
		String str = (new Date()).toString();
		ship.setId(id);
		ship.setName("m1212"+str);
		try{
		service.updateShip(ship);
		}catch(Exception e){
			e.printStackTrace();
		}
		return str;
	}
	
	@RequestMapping(value = "/mybsave/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String mybsave(@PathVariable("id") int id){
		Ship ship = new Ship();
		String str = (new Date()).toString();
		ship.setName("liuiyijiang"+str);
		if(id != 0){
			ship.setId(id);
			service.saveShip(ship);
		}else{
			service.saveShipAuto(ship);
		}
		return str;
	}
	
	@RequestMapping(value = "/mybfind/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String mybfind(@PathVariable("id") int id){
		Ship ship = service.selectShip(id);
		StringBuffer sb = new StringBuffer();
		if(ship != null){
			sb.append("id:"+ ship.getId()+" *** name:" + ship.getName());
		}else{
			sb.append("no ship");
		}
		return sb.toString();
	}
	
	@RequestMapping(value = "/myPartition", method = RequestMethod.GET)
	@ResponseBody
	public String myPartition(){
		Thread d = new Thread(new Runnable() {
			
			@Override
			public void run() {
				service.createbigData();
			}
		});
		d.start();
		return "ok";
	}
	
}

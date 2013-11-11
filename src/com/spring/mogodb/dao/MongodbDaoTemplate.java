package com.spring.mogodb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.spring.mogodb.bean.MapBean;
import com.spring.mogodb.bean.MapPointBean;

@Component
public class MongodbDaoTemplate {

	@Autowired
	private MongoOperations mog; 
	
	public void save(){
		for(int i=0;i<10000;i++){
			Double lon1 = 179 * Math.random();
			Double lat1 = 179 * Math.random();
			String place1 = "place1"+i;
			MapBean bean1 = new MapBean();
			bean1.setPlace(place1);
			bean1.setLoc(new Double[]{lon1,lat1});
			mog.save(bean1);
			
			Double lon2 = 179 * Math.random();
			Double lat2 = -179 * Math.random();
			String place2 = "place2"+i;
			MapBean bean2 = new MapBean();
			bean2.setPlace(place2);
			bean2.setLoc(new Double[]{lon2,lat2});
			mog.save(bean2);
			
			Double lon3 = -179 * Math.random();
			Double lat3 = 179 * Math.random();
			String place3 = "place3"+i;
			MapBean bean3 = new MapBean();
			bean3.setPlace(place3);
			bean3.setLoc(new Double[]{lon3,lat3});
			mog.save(bean3);
			
			Double lon4 = -179 * Math.random();
			Double lat4 = -179 * Math.random();
			String place4 = "place4"+i;
			MapBean bean4 = new MapBean();
			bean4.setPlace(place4);
			bean4.setLoc(new Double[]{lon4,lat4});
			mog.save(bean4);
		}
		System.out.println("==-==================ok");
		savePoint();
	}
	
	private void savePoint(){
		for(int i=0;i<10000;i++){
			Double lon1 = 179 * Math.random();
			Double lat1 = 179 * Math.random();
			String place1 = "place1"+i;
			MapPointBean bean1 = new MapPointBean();
			bean1.setPlace(place1);
			bean1.setPoint(new Point(lon1,lat1));
			mog.save(bean1);
			
			Double lon2 = 179 * Math.random();
			Double lat2 = -179 * Math.random();
			String place2 = "place2"+i;
			MapPointBean bean2 = new MapPointBean();
			bean2.setPlace(place2);
			bean2.setPoint(new Point(lon2,lat2));
			mog.save(bean2);
			
			Double lon3 = -179 * Math.random();
			Double lat3 = 179 * Math.random();
			String place3 = "place3"+i;
			MapPointBean bean3 = new MapPointBean();
			bean3.setPlace(place3);
			bean3.setPoint(new Point(lon3,lat3));
			mog.save(bean3);
			
			Double lon4 = -179 * Math.random();
			Double lat4 = -179 * Math.random();
			String place4 = "place4"+i;
			MapPointBean bean4 = new MapPointBean();
			bean4.setPlace(place4);
			bean4.setPoint(new Point(lon4,lat4));
			mog.save(bean4);
		}
		System.out.println("==-======savePoint============ok");
	}
	
	
	public void find(){
		//mog.executeQuery(arg0, arg1, arg2)
		find1();
		System.out.println("---------------ok find1-----------------");
		//find2();
	}
	
	//坐标的组成是数组
	private void find1(){
		BasicQuery  bq = new BasicQuery("{loc:{$near:[50,50]}}");
		bq.limit(10);
		List<MapBean> list1 = mog.find(bq, MapBean.class);
		for (MapBean b: list1) {
			System.out.println(b.getPlace());
		}
		System.out.println("#######################################");
		//mog.f
		Point point = new Point(50.0,50.0);
		Criteria c = Criteria.where("loc").near(point);
	    Query q = new Query(c);
	    q.limit(10);
		List<MapBean> list = mog.find(q, MapBean.class);
		for (MapBean b: list) {
			System.out.println(b.getPlace());
		}
		System.out.println("-----------------ok------------------");
	}
	
	//坐标是point
	private void find2(){
		//{ loc : { $near : [50,50] , $maxDistance : 5 } } 
		
		// box = [[49.83083, -50.99756], [49.741404, -20.988135]]
		//b.places.find({loc : {$within : {$box : box}}}).limit(2)
		BasicQuery  bq = new BasicQuery("{loc:{$near:[50,50]}}");
		bq.limit(10);
		List<MapPointBean> list1 = mog.find(bq, MapPointBean.class);
		for (MapPointBean b: list1) {
			System.out.println(b.getPlace());
		}
		//mog.f
		Point point = new Point(50.0,50.0);
		Criteria c = Criteria.where("loc").near(point);
	    Query q = new Query(c);
	    q.limit(10);
		List<MapPointBean> list = mog.find(q, MapPointBean.class);
		for (MapPointBean b: list) {
			System.out.println(b.getPlace());
		}
		System.out.println("-----------------ok------------------");
	}
	
}

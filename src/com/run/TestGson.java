package com.run;

import java.util.Date;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.Ship;

public class TestGson {

	public static void main(String[] args) {
		TestGson t = new  TestGson();
		//t.baseTest();
		t.builderTest();
	}
	
	public void baseTest(){
		Ship ship = new Ship();
		ship.setCreate(new Date());
		ship.setId(2);
		ship.setName("liuu");
		Gson gson = new Gson();
		System.out.println(gson.toJson(ship));
	}
	
	public void builderTest(){
		SimlpeJson s = new SimlpeJson();
		s.setId(1);
		s.setName("sss");
		s.setTime(new Date());
        s.setLo(300L);
		//s.setValue("lll");
		GsonBuilder b = new GsonBuilder();
		//b.excludeFieldsWithoutExposeAnnotation();// 只导出@Expose注解字段
		b.serializeNulls();//输出null
		b.setDateFormat("yyyy-MM-dd HH:mm:ss:SSS");//格式化时间
		b.setPrettyPrinting(); //对json结果格式化.
		b.setExclusionStrategies(new ExclusionStrategy() {
			public boolean shouldSkipField(FieldAttributes f) {
				return f.getName().equals("lo");
			}
			@Override
			public boolean shouldSkipClass(Class<?> clazz) {
				return false;
			}
		});
		//b.setLongSerializationPolicy(null);
		//b.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE);//会把字段首字母大写,注:对于实体上使用了@SerializedName注解的不会生效. 
		//b.setVersion(2.2);//
		Gson gson = b.create();
		System.out.println(gson.toJson(s));
	}
	
}

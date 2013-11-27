package com.spring.restfull.client.baidumap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class BaiduMapUtil {
   
	public String getBaiduFormattedAddress(String value){
		String address = null;
		try{
			String jsonbase = value.substring(value.indexOf("(")+1,value.length()-1);
			JSONObject obj = JSON.parseObject(jsonbase);
			String json = obj.getString("result");
			JSONObject objs = JSON.parseObject(json);
			address = objs.getString("formatted_address");
		}catch(Exception e){
			e.printStackTrace();
		}
		return address;
	}
	
}

package com.run;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class TestFastJSON {
 
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", "liuyijiang");
		map.put("jim", "sex222");
		System.out.println(JSON.toJSON(map).toString());
	}
	
}

package com.guava;


import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class TestMap {

	//翻转的bimap 可以
	public void testEumn(){
		BiMap<String,String> bimap = HashBiMap.create();
		bimap.put("b1", "pk1");
		bimap.put("b2", "pk2");
		BiMap<String,String> bimap2 = bimap.inverse();
		System.out.println(bimap.get("b2"));
		System.out.println(bimap2.get("pk1"));
	}
	
}

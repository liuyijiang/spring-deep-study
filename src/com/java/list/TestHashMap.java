package com.java.list;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("key1", "liuyijiang");
		String st = map.get("key1");
		System.out.println(st);

	}

}

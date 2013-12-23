package com.guava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableSet;

public class TestBaseJavaCollections {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		Collections.addAll(list, "ss1","ss3");
		//boolean re |= ss;
		for(String str : list){
			System.out.println(str);
		}
	}

}

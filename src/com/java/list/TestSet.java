package com.java.list;

import java.util.HashSet;
import java.util.Set;
/**
 * set 为什么能去重复 
 * set内部是hashMap实现的 key 就是add的那个值
 * @author Administrator
 *
 */
public class TestSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("ss");
	}

}

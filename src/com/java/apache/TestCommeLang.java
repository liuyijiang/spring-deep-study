package com.java.apache;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
/**
 * 测试commons-lang3 的工具类
 * @author Administrator
 *
 */
public class TestCommeLang {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestCommeLang t = new TestCommeLang();
		//t.testRandomStringUtils();
		t.testStringUtils();

	}

	/**
	 * RandomStringUtils
	 */
	public void testRandomStringUtils(){
		System.out.println(RandomStringUtils.random(6));
		//System.out.println(RandomStringUtils.random(3, 'sdvfcs'));
	}
	
	public void testStringUtils(){
		System.out.println(StringUtils.isEmpty(null));      // true  
		System.out.println(StringUtils.isEmpty(""));        // true  
		System.out.println(StringUtils.isEmpty(" "));
		
		System.out.println(StringUtils.rightPad("liuyijiang", 3));
	}
}

package com.java.base;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.util.StringUtil;

public class Test {

	public static void main(String[] args) {
		int i = 0;
//		System.out.println(i++);
		//0 + 2 + 2 + 3 + 4 = 11
		//0 + 2 + 2 + 4 + 5 = 
		int j = i++ + ++i + i++ + ++i + ++i;
		int k = --i + i--;
//		System.out.println(i);//0
		System.out.println(j);//1
		System.out.println(k);//3
    	
	}
	
}

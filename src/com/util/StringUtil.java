package com.util;

import java.util.HashSet;
import java.util.Set;

public class StringUtil {
 
	private final static Set<Character> ESPECIAL_SET = new HashSet<Character>();
	static {
		for (char ch : "~!@#$%^&*_+{}|:\"<>?`-=[]\\;',./·～！@#￥%……&×（）——+『』：“”《》？【】、；‘，。/".toCharArray()) {
			ESPECIAL_SET.add(ch);
		}
	}
	
	public static void main(String[] args) {
		for(Character cha:ESPECIAL_SET){
			System.out.println(cha);
		}
	}
	
}

package com.util;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class StringUtil {
 
	private final static Set<Character> ESPECIAL_SET = new HashSet<Character>();
	static {
		for (char ch : "~!@#$%^&*_+{}|:\"<>?`-=[]\\;',./·～！@#￥%……&×（）——+『』：“”《》？【】、；‘，。/".toCharArray()) {
			ESPECIAL_SET.add(ch);
		}
	}
	
	public static String objectToBase64(Object obj){
		BASE64Encoder b = new BASE64Encoder();
		return b.encode(obj.toString().getBytes());
	}
	
	public static String string64ToString(String str) throws IOException{
		BASE64Decoder d = new BASE64Decoder(); 
		 byte[] bt = d.decodeBuffer(str);
		return new String(bt);
	}
	
	public static void main(String[] args) {
//		for(Character cha:ESPECIAL_SET){
//			System.out.println(cha);
//		}
		try{
			String str = objectToBase64("liuyijiang");
			System.out.println(str);
			System.out.println(string64ToString(str));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}

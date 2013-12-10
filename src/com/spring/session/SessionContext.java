package com.spring.session;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * 这个类 来加载cookie中保存的值 并且
 * @author Administrator
 *
 */
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class SessionContext {
   
	private static final String SYSTEM_PASSWORD = "root123";
	
	public static final String SESSION_KEY = "h_lxs";
	
	private SessionBean session;
	
	public boolean session(HttpServletResponse response,SessionBean data,int maxTime){
		if(data == null || response == null){
		    return false;	
		}
		String json = JSON.toJSONString(data);
		String value = encrypt(json);
		if(value != null){
			Cookie cookie = new Cookie(SessionContext.SESSION_KEY,value);  
		    cookie.setMaxAge(maxTime);
		    response.addCookie(cookie);
		}
		return true;
	}
	
	/**
	 * 加密
	 */
	private String encrypt(String content){
		String value = null;
		 try {             
             KeyGenerator kgen = KeyGenerator.getInstance("AES");  
             kgen.init(128, new SecureRandom(SYSTEM_PASSWORD.getBytes()));  
             SecretKey secretKey = kgen.generateKey();  
             byte[] enCodeFormat = secretKey.getEncoded();  
             SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");  
             Cipher cipher = Cipher.getInstance("AES");// 创建密码器  
             byte[] byteContent = content.getBytes("utf-8");  
             cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化  
             byte[] result = cipher.doFinal(byteContent);  
             BASE64Encoder b = new BASE64Encoder();
             value = b.encode(result);
	     } catch (Exception e) {  
	         e.printStackTrace();  
	     }
		 return value;
	}
	
	/**
	 * 解密
	 */
	private String decrypt(String value){
		 byte[] result = null;
		 try {  
			 BASE64Decoder d = new BASE64Decoder();
			 byte[] bt = d.decodeBuffer(value);
			 KeyGenerator kgen = KeyGenerator.getInstance("AES");  
             kgen.init(128, new SecureRandom(SYSTEM_PASSWORD.getBytes()));  
             SecretKey secretKey = kgen.generateKey();  
             byte[] enCodeFormat = secretKey.getEncoded();  
             SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");              
             Cipher cipher = Cipher.getInstance("AES");// 创建密码器  
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化  
            result = cipher.doFinal(bt);  
	    } catch (Exception e) {  
	    	e.printStackTrace();
	    }
		return new String(result);
	}

	public SessionBean getSession() {
		return session;
	}

	public void setSession(String value) {
		if(value != null){
			String json = decrypt(value);
			this.session = JSON.parseObject(json, SessionBean.class);
		}
	}
	
	
}

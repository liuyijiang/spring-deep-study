package com.spring.session;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
/**
 * 这个类 来加载cookie中保存的值 并且
 * @author Administrator
 *
 */
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class SessionContext {
   
	private String CookeData;

	public String getCookeData() {
		return CookeData;
	}

	public void setCookeData(String cookeData) {
		CookeData = cookeData;
	}
	
	
	
}

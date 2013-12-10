package com.spring.session.filer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.session.SessionContext;

/**
 * 分布式系统session 拦击
 * @author Administrator
 *
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private SessionContext sessionContext;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			if(SessionContext.SESSION_KEY.equals(cookie.getName())){
				System.out.println(cookie.getValue());
				sessionContext.setSession(cookie.getValue());
			}
		}
		return super.preHandle(request, response, handler);
	}
	
}

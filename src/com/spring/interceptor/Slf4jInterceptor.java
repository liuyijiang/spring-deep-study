package com.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.run.TestSlf4J;

/**
 * 使用slf4j + backlog 实现拦截器统一异常捕获
 * @author Administrator
 *
 */
public class Slf4jInterceptor extends HandlerInterceptorAdapter {

	public static final Logger logger = LoggerFactory.getLogger(Slf4jInterceptor.class); 
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion");
//		 Integer t = 1132;  
//		 Integer oldT = 443;
//		logger.debug("Temperature set to {}. Old temperature was {}.", t, oldT);  
//		logger.info("Temperature set to {}. Old temperature was {}.", t, oldT);  
//		logger.error("Temperature set to {}. Old temperature was {}.", t, oldT);
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
		 Integer t = 1132;  
		 Integer oldT = 443;
//		logger.debug("Temperature set to {}. Old temperature was {}.", t, oldT);  
//		logger.info("Temperature set to {}. Old temperature was {}.", t, oldT);  
//		logger.error("Temperature set to {}. Old temperature was {}.", t, oldT);
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		 Integer t = 1132;  
		 Integer oldT = 443;
//		logger.debug("Temperature set to {}. Old temperature was {}.", t, oldT);  
//		logger.info("Temperature set to {}. Old temperature was {}.", t, oldT);  
//		logger.error("Temperature set to {}. Old temperature was {}.", t, oldT);
		 System.out.println("preHandle");
		return super.preHandle(request, response, handler);
	}

	
}

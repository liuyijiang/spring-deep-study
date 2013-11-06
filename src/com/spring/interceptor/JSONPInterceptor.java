package com.spring.interceptor;

import java.lang.reflect.Method;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletResponseWrapper;

public class JSONPInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 
	 */
    @Override  
    public void afterCompletion(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception ex)  
    throws Exception {  
        System.out.println(handler);
        String callback = request.getParameter("callback");
        if(callback != null){
        	Locale l = response.getLocale();
        }
        HttpServletResponseWrapper w = new HttpServletResponseWrapper(response);
        //w.
       // RequestWrapper wrappedRequest = new RequestWrapper((HttpServletRequest) request);  
        //ResponseWrapper wrappedResponse = new ResponseWrapper((HttpServletResponse) response);
        //response.getWriter().
       // response.
        if (handler instanceof HandlerMethod) {
        	HandlerMethod method = (HandlerMethod) handler;
        	Object obj = method.getBean();
        	Method  m = method.getMethod();
        	MethodParameter mp = method.getReturnType();
        	System.out.println(1);
        }
          
    }  
}

package com.spring.interceptor;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.interceptor.annotain.LoginRequired;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion");
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("preHandle");
		if (handler instanceof HandlerMethod) {
            LoginRequired loginRequired = findAnnotation((HandlerMethod) handler, LoginRequired.class);
            if(loginRequired != null){
            	System.out.println(loginRequired.required());
            }
            //            if (loginRequired != null && !loggedIn()) {  
//                redirectToLoginPage(request, response);
//                return false;
//            }
        }
		return super.preHandle(request, response, handler);
	}

	private <T extends Annotation> T findAnnotation(HandlerMethod handler,Class<T> annotationType) {
		System.out.println(handler.getBeanType());//获得cotroller
		T annotation = handler.getBeanType().getAnnotation(annotationType);
		System.out.println(annotation);
        if (annotation != null){
        	 return annotation;
        }
        System.out.println(handler.getMethodAnnotation(annotationType));//获得cotrollerd 方法注解
        return handler.getMethodAnnotation(annotationType);
    }
	
	
}

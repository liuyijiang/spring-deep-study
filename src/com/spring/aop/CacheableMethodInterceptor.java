package com.spring.aop;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CacheableMethodInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {

		Method method = methodInvocation.getMethod();
		Cacheable cacheable = method.getAnnotation(Cacheable.class);
		Object result = methodInvocation.proceed();
//		if(){
//			
//		}else{
//			
//		}
//		System.out.println(cash.cashed());
//		System.out.println("Method arguments : "
//				+ Arrays.toString(methodInvocation.getArguments()));
//		// same with MethodBeforeAdvice
//		System.out.println("HijackAroundMethod : Before method hijacked!");

//		try {
//			// proceed to original method call
//			
//
//			// same with AfterReturningAdvice
//			System.out.println("HijackAroundMethod : Before after hijacked!");
//
//			return result;
//
//		} catch (IllegalArgumentException e) {
//			// same with ThrowsAdvice
//			System.out
//					.println("HijackAroundMethod : Throw exception hijacked!");
//			throw e;
//		}
		return result;
	}
}

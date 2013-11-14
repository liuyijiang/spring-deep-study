package com.mkyong.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.spring.annotaion.annotaion.Cashable;

public class HijackAroundMethod implements MethodInterceptor
{
	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		
		System.out.println("Method name : " 
				+ methodInvocation.getMethod().getName());
		Method me = methodInvocation.getMethod();
		Cashable cash = me.getAnnotation(Cashable.class);
		System.out.println(cash.cashed());
		System.out.println("Method arguments : " 
				+ Arrays.toString(methodInvocation.getArguments()));
		//same with MethodBeforeAdvice
		System.out.println("HijackAroundMethod : Before method hijacked!");
		
		try{
			//proceed to original method call
			Object result = methodInvocation.proceed();
		
			//same with AfterReturningAdvice
			System.out.println("HijackAroundMethod : Before after hijacked!");
		
			return result;
		
		}catch(IllegalArgumentException e){
			//same with ThrowsAdvice
			System.out.println("HijackAroundMethod : Throw exception hijacked!");
			throw e;
		}
		
		
		
	}
	
}

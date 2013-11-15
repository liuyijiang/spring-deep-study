package com.spring.annotaion.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.spring.annotaion.service.TestAopService;


@Aspect
@Component
public class AopTest {

	
	
	@Around("execution (* com.spring.annotaion.service.*.*(..))")
	public void doCash(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("call-doCash");
	    Signature s = pjp.getSignature();
	    MethodSignature methodSignature = (MethodSignature)s;      
System.out.println(methodSignature.getMethod().getReturnType());
System.out.println("-------------");
	    Method m = s.getDeclaringType().getDeclaredMethod(s.getName(), new Class[]{Integer.class});
	    System.out.println(m.getReturnType());
	    Method[] mss = s.getDeclaringType().getDeclaredMethods();
	    
	    StaticPart st =  pjp.getStaticPart();
	    System.out.println(st.getSignature().getDeclaringType());
	    //st.
	    for(Method ml : mss){
	    	if(s.getName().equals(ml.getName())){
	    		System.out.println(ml.getReturnType());
	    	}
	    }
	}
	
	@Around("execution (* com.spring.hibernate.dao.*.*(..))")
	public void doCashs(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("call-doCash");
		Object ob2 = pjp.getTarget();
		System.out.println(ob2);
	}
	
	
	public static void main(String[] args) throws SecurityException, NoSuchMethodException {
		TestAopService ss = new TestAopService();
		Method ms = TestAopService.class.getMethod("find", new Class[]{Integer.class});
		System.out.println(ms.getReturnType());
		Method[] m = TestAopService.class.getDeclaredMethods();
		for (Method mm : m) {
			System.out.println(mm.getReturnType());
		}
	}
	
	
}

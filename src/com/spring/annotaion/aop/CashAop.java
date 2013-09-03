package com.spring.annotaion.aop;

import java.lang.reflect.Field;

import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.spring.annotaion.annotaion.Cashable;

/**
 * 基于spring切面的注解方式缓存
 * @author Administrator
 *
 */
@Aspect
@Component
public class CashAop {

	@Autowired
	@Qualifier("memcachedClient")
	private MemcachedClient mc;
	
	public CashAop(){
		System.out.println("#############################CashAop#############################");
	}
	
//	@Pointcut("execution(* com.spring.annotain.service.TestAnnotaionServiceBase.findDataById(..))")  
//om.spring.annotain.service.*.*(..) 第一个*表示类 第二个*表示方法
	//    public void cashData(){}  
	@Around("execution (* com.spring.annotaion.service.*.testSave(..)) && @annotation(cashable) ")
	public void doCash(ProceedingJoinPoint pjp,Cashable cashable) throws Throwable{
		System.out.println("call-doCash");
		if(cashable.cashed()){
			int exp = cashable.exptime();
			Object obj = pjp.proceed();
			Integer id;
			if(obj != null){
				Field fid = obj.getClass().getDeclaredField("id");
				fid.setAccessible(true);
				id = fid.getInt(obj);
				String text = JSON.toJSONString(obj);
				mc.set("key"+id, exp, text);
				System.out.println("into memncashed");
			}
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Around("execution (* com.spring.annotaion.service.*.findDataById(..)) && @annotation(cashable) ")
	public <T> T findCash(ProceedingJoinPoint pjp,Cashable cashable) throws Throwable{
		System.out.println("call-findCash");
		Object obj = null;
		if(cashable.cashed()){
			int exp = cashable.exptime();
			Object[] args = pjp.getArgs();
			CASValue<Object> casValue = mc.getAndTouch("key"+args[0], exp);
			String data = null;
			if (casValue != null){
				data = casValue.getValue().toString();
				obj = JSON.parseObject(data, (Class)args[1]);
				System.out.println("from memncashed");
			} 
		}else{
			obj = pjp.proceed();
			System.out.println("from database");
		}
		return (T) obj;
	}
	
}

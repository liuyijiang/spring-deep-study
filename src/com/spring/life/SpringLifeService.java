package com.spring.life;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;
/**
 * spring  生命周期测试 
 * @author Administrator
 *
 */
@Service
public class SpringLifeService {

	/**
	 * 使用 @PostConstruct 测试spring初始化的时候
	 */
//	@PostConstruct 
//	private void testPostConstruct(){
//		System.out.println("###################################################################################");
//		System.out.println("spring 生命周期测试 对象初始化的时候 执行");
//		System.out.println("###################################################################################");
//	} 
//	
//	@PreDestroy
//	private void testPreDestroy(){
//		System.out.println("###################################################################################");
//		System.out.println("spring 生命周期测试 -- 对象被销毁的时候执行");
//		System.out.println("###################################################################################");
//	}
	
}

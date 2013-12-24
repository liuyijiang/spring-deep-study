package com.java.cglib;
/**
 * 测试使用cglib
 *  JDK自从1.3版本开始，就引入了动态代理，JDK的动态代理用起来非常简单，但是它有一个限制，就是使用动态代理的对象必须实现一个或多个接口 。如果想代理没有实现接口的类可以使用CGLIB包。
 * CGLIB是一个强大的高性能的代码生成包。它被许多AOP的框架（例如Spring AOP）使用，为他们提供方法的interception（拦截）。
 * Hibernate也使用CGLIB来代理单端single-ended(多对一和一对一)关联。
 * EasyMock通过使用模仿（moke）对象来测试java代码的包。它们都通过使用CGLIB来为那些没有接口的类创建模仿（moke）对象。
　*　CGLIB包的底层是通过使用一个小而快的字节码处理框架ASM，来转换字节码并生成新的类。不鼓励直接使用ASM，因为它要求你必须对JVM内部结构包括class文件的格式和指令集都很熟悉。
 * @author Administrator
 *
 */
public class TestCglib {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 HelloWorld helloWorld=new HelloWorld();
	        CglibProxy cglibProxy=new CglibProxy();
	        HelloWorld hw=(HelloWorld)cglibProxy.createProxy(helloWorld);
	        hw.sayHelloWorld();

	}

}

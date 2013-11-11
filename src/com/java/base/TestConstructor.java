package com.java.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;


public class TestConstructor {
	
  public static void main(String[] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
	
	 // Constructor constructor = Bean.class.getDeclaredConstructor(null);
	  Field[] fi = Bean.class.getFields(); //只能获得共有的
	  for (Field f : fi){
		  System.out.println(f.getName());
	  }
	  System.out.println("&&&&&&&&&&&&&&7");
	  Field[] fis = Bean.class.getDeclaredFields();
	  for (Field f : fis){
		  System.out.println(f.getName());
		  //f.set
	  }
	  //
	  Bean b = new Bean();
	  Constructor constructor = ConstructorBean.class.getDeclaredConstructor(new Class[]{Bean.class,String.class});
	  constructor.setAccessible(true);  //private的也可访问 
	  ConstructorBean bean = (ConstructorBean)constructor.newInstance(new Object[]{b,"ok"});
	  System.out.println(bean);
  }
  
}

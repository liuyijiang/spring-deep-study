package com.java.base;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Table;

public class BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    String str1 = "sss";
		String str2 = "sss";
		System.out.println(str1 == str2);
		BaseTest b = new BaseTest();
		//b.test(Bean.class);
		b.testmethod(Bean.class);
	}

	public void testPageModel(){
		PageModel<Bean> pm = new PageModel<Bean>();
		Bean bean = new Bean();
		pm.add(bean);
	}
	
	//获得类的注解
	public void test(Class<?> clazss){
		//Entity entity = clazss.getAnnotation(Entity.class);//获得类的某一个注解
		//Bean bean = new Bean();
		Annotation a[] = clazss.getAnnotations();//
		for(Annotation an:a){
			if(an instanceof Table){
				Table t = (Table) an;
				System.out.println(t.name());
			}
			System.out.println(an.toString());
		}
	}
	
	public void testmethod(Class<?> clazz){
		String out = "o";
		try {
			PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(clazz).getPropertyDescriptors();
			for(PropertyDescriptor propertydesc : propertyDescriptors){
				System.out.println(propertydesc.getName());
				Method method = propertydesc.getReadMethod();
				if(method!=null ){			//&& method.isAnnotationPresent(EmbeddedId.class)	
					System.out.println(method.getName());
//					PropertyDescriptor[] ps = Introspector.getBeanInfo(propertydesc.getPropertyType()).getPropertyDescriptors();
//					out = "o."+ propertydesc.getName()+ "." + (!ps[1].getName().equals("class")? ps[1].getName(): ps[0].getName());
//					break;
				}
			}
		System.out.println(out);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

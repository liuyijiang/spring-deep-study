package com.java.base;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.persistence.Table;

/**
 * 测试java的一些基础方法
 * 1 isAssignableFrom
 * 2 try catch finally返回值
 * @author Administrator
 *
 */
public class BaseTest {

	public <T extends Base> void get(T t) {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String str1 = "sss";
//		String str2 = "sss";
//		System.out.println(str1 == str2);
		BaseTest b = new BaseTest();
//		// b.test(Bean.class);
//		b.testmethod(Bean.class);
		b.testisAssignableFrom();
	}

	public void testPageModel() {
		PageModel<Bean> pm = new PageModel<Bean>();
		Bean bean = new Bean();
		pm.add(bean);
	}

	// 获得类的注解
	public void test(Class<?> clazss) {
		// Entity entity = clazss.getAnnotation(Entity.class);//获得类的某一个注解
		// Bean bean = new Bean();
		Annotation a[] = clazss.getAnnotations();//
		for (Annotation an : a) {
			if (an instanceof Table) {
				Table t = (Table) an;
				System.out.println(t.name());
			}
			System.out.println(an.toString());
		}
	}

	public void testmethod(Class<?> clazz) {
		String out = "o";
		try {
			PropertyDescriptor[] propertyDescriptors = Introspector
					.getBeanInfo(clazz).getPropertyDescriptors();
			for (PropertyDescriptor propertydesc : propertyDescriptors) {
				System.out.println(propertydesc.getName());
				Method method = propertydesc.getReadMethod();
				if (method != null) { // &&
										// method.isAnnotationPresent(EmbeddedId.class)
					System.out.println(method.getName());
					// PropertyDescriptor[] ps =
					// Introspector.getBeanInfo(propertydesc.getPropertyType()).getPropertyDescriptors();
					// out = "o."+ propertydesc.getName()+ "." +
					// (!ps[1].getName().equals("class")? ps[1].getName():
					// ps[0].getName());
					// break;
				}
			}
			System.out.println(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试java中 instanceof  和  isAssignableFrom
	 */
	public void testisAssignableFrom(){
		System.out.println("##################test instanceof##################");
		ExtendsBase b = new ExtendsBase();
		ExtendsBase b2 = new ExtendsBase();
		Base bb = new Base();
		ImplBean ib = new ImplBean();
		System.out.println(b instanceof ExtendsBase);//instanceof 类要有继承关系  接口不一定需要实现 BaseInterface
		System.out.println(b instanceof BaseInterface);//
		String syr = "11";
		System.out.println(syr instanceof Object );
		Object sysr = "11";
		System.out.println(sysr instanceof Boolean );//object instanceof 所有
		//instanceof操作符主要用于向下造型  
		//ExtendsBase.cl
		System.out.println("##################test isAssignableFrom##################");
		//xx.class 是否能被x.getclass 构建
		System.out.println(ExtendsBase.class.isAssignableFrom(b.getClass())); 
		System.out.println(ExtendsBase.class.isAssignableFrom(bb.getClass())); //ExtendsBase bbb = new Base(); 不能被构建所以为false
		System.out.println(Base.class.isAssignableFrom(b.getClass()));
		
	}
	
	
}

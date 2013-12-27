package com.java.base;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Table;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.RandomStringUtils;

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
//		b.testisAssignableFrom();
		b.testlang();
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
	
	/**
	 *  遍历map
	 */
	public void testmap(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("key1", "Str1");
		map.put("key2", "Str2");
		map.put("key3", "Str3");
		for(Entry<String,String> e : map.entrySet()){
			System.out.println(e.getKey()+" ****  " + e.getValue());
		} 
	}
	
	public void testlang(){
		String userName = "1' or '1'='1";
        String password = "123456";
        String sql = "SELECT COUNT(userId) FROM t_user WHERE userName='" + userName + "' AND password ='" + password + "'";
        System.out.println(sql);
        userName = StringEscapeUtils.escapeSql(userName);
        password = StringEscapeUtils.escapeSql(password);
        sql = "SELECT COUNT(userId) FROM t_user WHERE userName='" + userName + "' AND password ='" + password + "'";
        System.out.println(sql);
        System.out.println(StringEscapeUtils.escapeHtml("<a>dddd</a>"));  
        System.out.println(StringEscapeUtils.escapeHtml("<iframe>dddd</iframe>"));
        System.out.println(StringEscapeUtils.unescapeHtml("&lt;a&gt;dddd&lt;/a&gt;"));
        System.out.println(StringEscapeUtils.escapeJavaScript("<script>alert(1)</script>"));
        System.out.println(StringEscapeUtils.unescapeJavaScript("<script>alert('1111')</script>"));
        System.out.println(StringEscapeUtils.escapeJava("中国"));
//        System.out.println(RandomStringUtils.randomAlphabetic(10));  
//        
//     // 10位英数  
//     System.out.println(RandomStringUtils.randomAlphanumeric(10));  
//       
//     // 10位ASCII码  
//     System.out.println(RandomStringUtils.randomAscii(10));  
//       
//     // 指定文字10位  
//     System.out.println(RandomStringUtils.random(10, "abcde")); 
	}
	
}

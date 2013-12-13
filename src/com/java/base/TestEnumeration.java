package com.java.base;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class TestEnumeration {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestEnumeration t = new TestEnumeration();
		t.testPakegaeClass("com.java.base");

	}

	/**
	 * 得到一个包下的所有类
	 */
	public void testPakegaeClass(String basePackage){
		String relPath = basePackage.replace('.', '/');
		try {
			Enumeration<URL> resources = ClassLoader.getSystemClassLoader().getResources(relPath);
			System.out.println(1);
			while(resources.hasMoreElements()) {
				URL resource = resources.nextElement();
				System.out.println("#package: '{}' becomes Resource: '{}'"+resource.toString());
		
				resource.getPath();
//				if (resource.toString().startsWith("jar:")) {
//					processJarfile(resource, basePackage, classes);
//				} else {
//					processDirectory(new File(resource.getPath()), basePackage, classes);
//				}
			}
			resources = Thread.currentThread().getContextClassLoader().getResources(relPath);
			while(resources.hasMoreElements()) {
				URL resource = resources.nextElement();
				System.out.println("#package: '{}' becomes Resource: '{}'"+resource.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

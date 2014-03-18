package com.java.java7;

public class TestJava7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try(Myclose m = new Myclose()){
			System.out.println("run");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

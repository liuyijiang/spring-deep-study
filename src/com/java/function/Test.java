package com.java.function;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ToFunction t = new ToFunction();
		t.toFunction("xuting", new Function<String, Integer, String>() {
			
			@Override
			public String method(Integer k, String f) {
				return "this is java function src"+ k+ f;
			}
		});

	}

}

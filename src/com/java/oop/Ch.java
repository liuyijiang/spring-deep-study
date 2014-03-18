package com.java.oop;

public class Ch extends Fa {

	public int d=102;
	private int i=21;
	public static int c=22;
	public final int b=20;
	
	public void t(){
		System.out.println("ch");
	}
	
	public void c(){
		System.out.println("ch");
	}
	
	public Ch(){
		//System.out.println(i);
	}
	
	public static void main(String[] args) {
		Fa a = new Ch();
		System.out.println(a.d);
		a.t();
	}
}

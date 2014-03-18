package com.java.base;

public class MyPlane extends Plane {

	@Override
	public void create() {
		System.out.println("my plane create");
		cc();
	}
	
	public static void main(String[] args) {
		System.out.println(1);
		MyPlane y = new MyPlane();
		System.out.println(2);
		//y.cc();
	}

}

//public class MyPlane extends Sprite {
//
//	public void sprite(int i){
//		System.out.println("MyPlane");
//	}
//	
//	public static void main(String[] args) {
//		System.out.println(1);
//		new MyPlane();
//		System.out.println(2);
//	}
//
//}

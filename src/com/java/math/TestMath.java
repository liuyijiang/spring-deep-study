package com.java.math;

public class TestMath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestMath t = new TestMath();
		//t.showangle();
//		System.out.println(Math.toDegrees(t.getRad(3,0,0,4)));
//		System.out.println(30*Math.PI/180);
//		比如对边和邻边分别为a,b
//		设角度为x，则
//		x=atan(a/b); 
//      其中x为弧度制
//		如需转换为角度值，则x*180/3.1415	
//		System.out.println(Math.atan((float)3/4));
		System.out.println(Math.atan2(4, 3) * 180/3.1415 );
		
	}

	public void showangle(){
		//System.out.println(Math.sin(30));
		//System.out.println(Math.toRadians(0.5));
		//System.out.println(Math.asin(3/5));
		//System.out.println(Math.asin(Math.toDegrees(3/5)));
		System.out.println(Math.sin(Math.toRadians(30)));
		System.out.println(Math.asin(3/5)*(180/Math.PI));
		System.out.println(Math.toDegrees(Math.asin(0.5)));
		System.out.println(Math.toDegrees(Math.atan2(3, 4)));
		//System.out.println(Math.sin(Math.toRadians(30)));
		
		System.out.println("####");
		float c = (float)3/4;
		System.out.println(c);
		System.out.println(Math.toDegrees(Math.atan(c)));
		System.out.println(Math.sin(30.0));
	}
	
	public double getRad(float px1, float py1, float px2, float py2) {  
	    //得到两点X的距离  
	    float x = px2 - px1;  
	    //得到两点Y的距离  
	    float y = py1 - py2;  
	    //算出斜边长  
	    float xie = (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));  
	    System.out.println(xie);
	    //得到这个角度的余弦值（通过三角函数中的定理 ：邻边/斜边=角度余弦值）  
	    float cosAngle = x / xie;  
	    //通过反余弦定理获取到其角度的弧度  
	    float rad = (float) Math.acos(cosAngle);  
	    //注意：当触屏的位置Y坐标<摇杆的Y坐标我们要取反值-0~-180  
//	    if (py2 < py1) {  
//	        rad = -rad;  
//	    }  
	    return rad;  
	}
	
	
	public double getRads(float px1, float py1, float px2, float py2) {  
	    //得到两点X的距离  
	    float x = px2 - px1;  
	    //得到两点Y的距离  
	    float y = py1 - py2;  
	    //算出斜边长  
	    float xie = (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));  
	    //得到这个角度的余弦值（通过三角函数中的定理 ：邻边/斜边=角度余弦值）  
	    float cosAngle = x / xie;  
	    //通过反余弦定理获取到其角度的弧度  
	    float rad = (float) Math.acos(cosAngle);  
	    //注意：当触屏的位置Y坐标<摇杆的Y坐标我们要取反值-0~-180  
	    if (py2 < py1) {  
	        rad = -rad;  
	    }  
	    return Math.toDegrees(rad)  ;
	}  
	
	
	public void getRadi(float px1, float py1, float px2, float py2){
		
	}
	
}

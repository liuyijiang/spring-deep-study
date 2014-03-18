package com.java.base;

public class InnerClass {

	public void tt(){
		System.out.println(1);
	}
	
	public void tts(){
		System.out.println(1);
	}
	
	public class IIner{
		public void tt(){
			tts();
	    	   System.out.println(0);
	    }
	}
	
    public static class InInnerClass{

       public void tt(){
    	   //tts();
    	   InnerClass c = new InnerClass();
    	   c.tt();
    	   System.out.println(0);
       }
    }
    
}

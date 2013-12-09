package com.java.eunm;

public enum ShipType {
 
	BB(1),TB(2), TT(12);
	
	private int code;

	private ShipType(int code){
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

	
	
}

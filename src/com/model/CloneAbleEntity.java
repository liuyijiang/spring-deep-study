package com.model;

public class CloneAbleEntity implements Cloneable {

	public String name;  
	public Ship ship;
	
    public Object clone() {  
    	CloneAbleEntity entity = null;
        try {  
        	entity = (CloneAbleEntity) super.clone();  
        	//entity.ship = (Ship) ship.clone(); 深度clone ship类也需要implements Cloneable
        } catch (CloneNotSupportedException e) {  
            e.printStackTrace();  
        }  
        return entity;  
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}  
    
    
	
}

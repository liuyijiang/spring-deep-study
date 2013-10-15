package com.java.forkjoin;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class Task extends RecursiveAction {

	private static final long serialVersionUID = 1L;
	private List lt;Product products;
	private int first;
	private int last;
	private double increment;
    
	public Task (List lt,Product products, int first, int last, double increment) {
		this.products=products;
		this.first=first;
		this.last=last;
		this.increment=increment;
		}
	
	@Override
	protected void compute() {
		
	}

}

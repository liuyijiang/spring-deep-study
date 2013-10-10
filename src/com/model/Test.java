package com.model;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Ship ship = new Ship();
		ship.setName("skk");
		CloneAbleEntity e1 = new CloneAbleEntity();
		e1.setName("liu");
		e1.ship = ship;
		System.out.println(e1.getName());
		System.out.println(e1.ship.getName());
		CloneAbleEntity e2 = (CloneAbleEntity) e1.clone();
		e2.setName("liuyijiang");
		e1.ship.setName("22ll");
		System.out.println(e1.getName());
		System.out.println(e1.ship.getName());
	}

}

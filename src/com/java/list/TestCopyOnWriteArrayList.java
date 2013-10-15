package com.java.list;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnWriteArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List clist = new CopyOnWriteArrayList();
		clist.add(1);// CopyOnWriteArrayList线程安全

	}

}

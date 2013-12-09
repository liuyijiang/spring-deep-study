package com.java.concurrent;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 测试柱塞双端队列
 * @author Administrator
 *
 */
public class TestBlockingDeque {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int   MAX_VALUE = 0x7fffffff;
		System.out.println(MAX_VALUE);
		BlockingDeque queue = new LinkedBlockingDeque();
		try {
			queue.put("ss");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package com.java.thread.executor;

import java.util.concurrent.Callable;

public class Call implements Callable{

	@Override
	public Object call() throws Exception {
		System.out.println("start call");
		Thread.sleep(10000);
		return "ok";
	}

}

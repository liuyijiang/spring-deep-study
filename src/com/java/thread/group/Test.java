package com.java.thread.group;

public class Test {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws Exception {
		A a = new A();
		a.exe();
		B b = new B();
		a.tt();
		b.tt();
        System.out.println("活动的线程b"+b.threadGroup1.activeCount());
        System.out.println("活动的线程a"+a.threadGroup1.activeCount());
        Thread.sleep(5000);
        System.out.println("--活动的线程a"+a.threadGroup1.activeCount());
        System.out.println("--活动的线程b"+b.threadGroup1.activeCount());
	}

}

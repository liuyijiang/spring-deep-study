package com.java.thread;
/**
 * 测试 ThreadGroup 
 * @author Administrator
 *
 */
public class TestThreadGroup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadGroup threadGroup1 = new ThreadGroup("group1");  
		ThreadGroup threadGroup2 = new ThreadGroup("group2");  
		TheadTask task1 = new TheadTask(4);
		TheadTask task2 = new TheadTask(8);
		TheadTask task3 = new TheadTask(6);
		//threadGroup1.
		Thread t1 = new Thread(threadGroup1, task1);
		Thread t2 = new Thread(threadGroup2, task2);
		Thread t3 = new Thread(threadGroup2, task3);
		t1.start();
		t2.start();
		t3.start();
		Thread[] threads = new Thread[threadGroup2.activeCount()]; //activeCount()返回此线程组中活动线程的估计数。
		threadGroup2.enumerate(threads);//enumerate(Thread[] list)把此线程组及其子组中的所有活动线程复制到指定数组中。
		for (Thread t : threads){
			System.out.println(t.getName());
		}
	
	}

}

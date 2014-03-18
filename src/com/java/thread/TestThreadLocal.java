package com.java.thread;

public class TestThreadLocal {

	private static ThreadLocal<String> loacl = new ThreadLocal<String>(){
		/**可以重写这个方法来实现*/
		@Override  
	   protected String initialValue() {
	        return null;
	    }
		
	};
	
	public static String bb;
	
	public static class Local{
		public String aa;

		public String getAa() {
			return aa;
		}

		public void setAa(String aa) {
			this.aa = aa;
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TestThreadLocal.Local l1 = new TestThreadLocal.Local();
//		TestThreadLocal.bb = "bb";
//		l1.aa = "ok1";
//		System.out.println(l1.aa);
//		System.out.println(TestThreadLocal.bb);
//		TestThreadLocal.Local l2 = new TestThreadLocal.Local();
//		TestThreadLocal.bb = "cc";
//		l2.aa = "ok2";
//		System.out.println(l2.aa);
//		System.out.println(l1.aa);
//		System.out.println(TestThreadLocal.bb);
		
		SequenceNumber sn = new SequenceNumber();

		TestClient t1 = new TestClient(sn);

		TestClient t2 = new TestClient(sn);

		TestClient t3 = new TestClient(sn);

		t1.start();

		t2.start();

		t3.start();
	}

}

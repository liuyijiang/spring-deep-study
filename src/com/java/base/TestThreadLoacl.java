package com.java.base;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.ReentrantLock;


public class TestThreadLoacl {

	private AtomicStampedReference<Object> s;	
	private static ThreadLocal<String> THREAD = new ThreadLocal<String>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AtomicInteger ss = new AtomicInteger(12);
		System.out.println(ss.get());
		System.out.println(ss.compareAndSet(11, 13));
		System.out.println(ss.get());
		
		new CopyOnWriteArraySet<>();
		//TimeUnit u = new TimeUnit();
		//u.
		//new CopyOnWriteArrayList();
//		Timer timer = new Timer();
//		timer.schedule(new TimeTaskBean(), 1000,2000);
//		Collections.synchronizedList(new ArrayList());
//		System.out.println(Math.E);
//       for (int i=0 ;i<10;i++) {
//    	   new Thread(new TestThread()).start();
//       }
//      new ConcurrentHashMap();
//      Map map = new ConcurrentSkipListMap();
//      new LinkedHashMap<>();
      
//      Map map = new IdentityHashMap();
//      map.put("key", "1");
//      map.put("key", "2");
//      System.out.println(map.get("key"));
//     new SynchronousQueue();
//     AtomicBoolean s;
//     AtomicInteger in;
    // s.
//      IdentityHashMap<String,Object> map =new IdentityHashMap<String,Object>();  
//      map.put(new String("xx"),"first");  
//      map.put(new String("xx"),"second");  
//      for (Entry<String, Object> entry : map.entrySet()) {  
//          System.out.print(entry.getKey() +"    ");  
//          System.out.println(entry.getValue());  
//      }  
//      System.out.println("idenMap="+map.containsKey("xx"));  
//      System.out.println("idenMap="+map.get("xx"));
//     
//      System.out.println("*******************");
//      
//      HashMap<String,Object> map2 =new HashMap<String,Object>(); 
//      map2.put(new String("xx"),"first");  
//      map2.put(new String("xx"),"second");  
//      for (Entry<String, Object> entry : map2.entrySet()) {  
//          System.out.print(entry.getKey() +"    ");  
//          System.out.println(entry.getValue());  
//      }  
//      
//      Map<MapType,String> m =  new EnumMap<MapType,String>(MapType.class);
	}
	
	public void mais(){
		//this.l
	}
	
	public static class TestThread implements Runnable {

		@Override
		public void run() {
			while(true){
				//Lock lock = new ReentrantLock()
				try {
					int i = (int)(Math.random() * 100);
					if(i > 60){
						TestThreadLoacl.THREAD.set(Thread.currentThread().getName()+"_"+i);
					}
					System.out.println(TestThreadLoacl.THREAD.get());
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public enum MapType {
		KEY1,KEY2
	}
	
	public static class TimeTaskBean extends TimerTask {

		@Override
		public void run() {
			System.out.println(System.currentTimeMillis());
		}
		
	}
    
}

package com.java.thread;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PriorityQueueExample {
  
	public static void main(String[] args) {
	    
		 Queue<Integer> integerPriorityQueue = new PriorityQueue<Integer>(7);
		 Random rand = new Random();
		 for(int i=0;i<7;i++){
			 integerPriorityQueue.add(new Integer(rand.nextInt(100)));
		 }
		 for(int i=0;i<7;i++){
			 Integer in = integerPriorityQueue.poll();
			 System.out.println("Processing Integer:"+in);
		 }
		 
//		 Queue<Customer> customerPriorityQueue = new PriorityQueue<Customer>(7, idComparator);
//		 addDataToQueue(customerPriorityQueue);
//		 pollDataFromQueue(customerPriorityQueue);
    }
	
	//用于往队列增加数据的通用方法
	 private static void addDataToQueue(Queue<Customer> customerPriorityQueue) {
		 Random rand = new Random();
		 for(int i=0; i<7; i++){
			 int id = rand.nextInt(100);
			 customerPriorityQueue.add(new Customer(id, "Pankaj "+id));
		 }
	 }
	 
	 //用于从队列取数据的通用方法
	 private static void pollDataFromQueue(Queue<Customer> customerPriorityQueue) {
		 while(true){
			  Customer cust = customerPriorityQueue.poll();
			  if(cust == null) 
				  break;
			  System.out.println("Processing Customer with ID="+cust.getId());
		 }
	 }
}

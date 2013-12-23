package com.guava;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

public class TestGuava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>(Arrays.asList(new String[]{"RED", "GREEN"})); 
		 Set<String> unmodifiableSet = Collections.unmodifiableSet(set);
		 //Collections.
         try{
        	 set.add("ss");
        	 System.out.println(1113+"\n");
        	// unmodifiableSet.add("ss");
        	 ImmutableSet<String> immutableSet = ImmutableSet.of("RED", "GREEN");
        	 //Immutable
    		 immutableSet.add("s");
         }catch(Exception e){
        	 e.printStackTrace();
         }
	}

	
}

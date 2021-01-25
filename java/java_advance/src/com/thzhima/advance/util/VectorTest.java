package com.thzhima.advance.util;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) throws InterruptedException {
		
        Vector v;
		
		final List list  = Collections.synchronizedList( new LinkedList());
		
		Thread t = new Thread() {
			public void run() {
			
				for(int i=0;i<2000;i++) {
					list.add(i);
					System.out.println("------------------");
				}
				
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
			
				for(int i=0;i<2000;i++) {
					list.add(i);
					System.out.println("====================");
				}
				
			}
		};
		
		t.start();
		t2.start();
		
		t.join();
		t2.join();
		
		System.out.println(list.size());
		
	}
	
	
}

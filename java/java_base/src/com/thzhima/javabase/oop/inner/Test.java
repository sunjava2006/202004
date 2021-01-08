package com.thzhima.javabase.oop.inner;

import com.thzhima.javabase.oop.inner.LinkedList.Node;

public class Test {

	public static void main(String[] args) {
		
	
		
		
		LinkedList list = new LinkedList();
		
//		Node n = list.new Node();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		
		
		
		System.out.println(list.size());
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
}

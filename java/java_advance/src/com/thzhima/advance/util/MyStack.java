package com.thzhima.advance.util;

import java.util.Stack;

public class MyStack<E> extends MyVector<E>{

	public synchronized boolean empty() {
		return this.isEmpty();
	}
	
	public synchronized E peek() {
		return super.get(this.size()-1);
	}
	
	public synchronized E pop() {
		return super.remove(this.size()-1);
	}
	
	public synchronized E push(E e) {
		this.add(e);
		return e;
	}
	
	public synchronized int search(Object o) {
		int count = -1;
		for(int i=this.size()-1; i>=0; i--){
			E e = (E) this.elementData[i];
			if(o==null ? e==null : o.equals(e)) {
				count = this.size()-i;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Stack ss;
		
		MyStack<Integer> s = new MyStack<>();
		
		for(int i=1; i<=10; i++) {
			s.push(i);
		}
		
		System.out.println(s.empty());
		System.out.println(s.size());
		
		System.out.println(s.peek());
		System.out.println("=============================");
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		
		System.out.println(s.search(4));
		
		
	}
}

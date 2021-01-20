package com.thzhima.advance.util;

import java.util.NoSuchElementException;

public interface MyQueue<T> extends MyCollection<T>{

	boolean add(T t)throws IllegalStateException, ClassCastException, NullPointerException, IllegalArgumentException;
	
	T remove() throws NoSuchElementException;
	
	T element() throws NoSuchElementException;
	
	boolean offer(T t);
	
	T poll();
	
	T peek();
	
	
}

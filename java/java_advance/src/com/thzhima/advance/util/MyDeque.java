package com.thzhima.advance.util;

import java.util.NoSuchElementException;

public interface MyDeque<T> extends MyQueue<T>{

	void addFirst(T e)throws IllegalStateException, IllegalArgumentException,ClassCastException, NullPointerException;
	
	void addLast(T e)throws IllegalStateException, IllegalArgumentException,ClassCastException, NullPointerException;
	
	boolean offerFirst(T e);
	
	boolean offerLast(T e);
	
	T removeFirst() throws NoSuchElementException;
	
	T removeLast() throws NoSuchElementException;
	
	T pollFirst();
	
	T pollLast();
	
	T getFirst() throws NoSuchElementException;
	
	T peekFirst();
	
	T getLast()throws NoSuchElementException;
	
	T peekLast();
	
	boolean removeFirstOccurrence(Object o) throws ClassCastException, NullPointerException;
	
	boolean removeLastOccurrence(Object o) throws ClassCastException, NullPointerException;
	
}

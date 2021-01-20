package com.thzhima.advance.util;

public interface MyList<T> extends MyCollection<T>{

	void add(int index, T e);
	
	boolean addAll(int index, MyCollection<? extends T> c);
	
	T get(int index);
	
	int indexOf(Object o);
	
	T remove(int index);
	
	T set(int index, T e);
	
	MyList subList(int from, int to);
}

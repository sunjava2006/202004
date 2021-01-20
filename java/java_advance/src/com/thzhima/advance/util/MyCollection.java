package com.thzhima.advance.util;

public interface MyCollection<T> extends Iterable<T>{

	boolean add(T t);
	
	boolean addAll(MyCollection<? extends T> t);
	
	void clear();
	
	boolean contains(Object o);
	
	boolean containsAll(MyCollection<?> c);
	
	boolean equals(Object o); // 强制重写该方法
	
	int hashCode();  // 强制重写该方法
	
	boolean isEmpty();
	
	boolean remove(Object o);
	
	boolean removeAll(MyCollection<?> c);
	
	boolean retainAll(MyCollection<?> c);
	
	int size();
	
	Object[] toArray();
	
	T[] toArray(T[] a);
	
	
}

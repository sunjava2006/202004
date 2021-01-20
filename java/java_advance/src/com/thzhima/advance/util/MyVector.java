package com.thzhima.advance.util;

import java.util.Arrays;
import java.util.Iterator;

public class MyVector<T> implements MyList<T> {

	/**
	 * 默认初始容量
	 */
	private static final int DEFAULT_CAPACITY = 10;

	
	/**
	 * 一个空数组
	 */
	private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

	
	/**
	 * 存储实际数据元素的数组
	 */
	transient Object[] elementData; // non-private to simplify nested class access
	
	
	/**
	 * 存储元素的个数, 又当最后一个元素的索引。
	 */
	private int size;
	
	public MyVector() {
		this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
	}
	
	public MyVector(int capacity) {
		if(capacity > 0) {
			this.elementData = new Object[capacity];
		}else if(capacity == 0 ) {
			this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
		}else {
			throw new IllegalArgumentException("列表长度给了负值。");
		}
	}
	
	/**
	 * 在添加元素之前，预处理存储空间。
	 * @param leng
	 */
	private synchronized void calculateCapacity(int leng) {
		if(! (size+leng < this.elementData.length-1) ){
			Object[] newElementsData = new Object[size+leng+DEFAULT_CAPACITY];
			System.arraycopy(this.elementData, 0, newElementsData, 0, this.elementData.length);
			this.elementData = newElementsData;
		}
	}

	@Override
	public synchronized boolean add(T t) {
		this.calculateCapacity(1);
		this.elementData[this.size] = t;
		size++;
		return true;
	}

	@Override
	public synchronized boolean addAll(MyCollection<? extends T> c) {
		for(T o : c) {
			this.add(o);
		}
		return true;
	}

	@Override
	public synchronized void clear() {
		Arrays.fill(this.elementData, null);
		
		this.size = 0;

	}

	@Override
	public synchronized boolean contains(Object o) {
		boolean contain = false;
		
		for(int i=0; i<this.size; i++) {
			if(this.elementData[i].equals(o)){
				contain = true;
				break;
			}
		}
		
		return contain;
	}

	@Override
	public synchronized boolean containsAll(MyCollection<?> c) {
		boolean contains = true; 
		
		for(Object o : c) {
			boolean flag = false;
			
			for(Object i : this) {
				if(o != null) {

					if(o.equals(i)) {
						flag = true;
						break;
					}
				}
			}
			if(!flag) {
				contains = false;
				break;
			}
		}
		
		return contains;
	}

	@Override
	public synchronized boolean isEmpty() {
		
		return this.size==0 ? true:false;
	}

	@Override
	public synchronized boolean remove(Object o) {
		boolean exist = false;
		int curridx = 0;
		for(; curridx<this.size; curridx++) {
			if(this.elementData[curridx].equals(o)){
				exist = true;
				break;
			}
		}
		if(exist) {
			for(;curridx<this.size-1; curridx++) {
				this.elementData[curridx] = this.elementData[curridx+1];
			}
			size--;
		}
		return exist;
	}

	@Override
	public synchronized boolean removeAll(MyCollection<?> c) {
		boolean b = false;
		
		for(Object t : c) {
			if(this.remove(t)) {
				b = true;
			}
		}
		
		
		return b;
	}

	@Override
	public synchronized boolean retainAll(MyCollection<?> c) {
		boolean update = false;
		
		Object[] retain = new Object[this.size];
		int count = 0;
		for(Object i : this) {
			for(Object j : c) {
				if(i != null) {
					if(i.equals(j)) {
						retain[count] = i;
						count++;
						update = true;
					}
				}
			}
		}
		
		this.elementData=retain;
		this.size = count;
		
		return update;
	}

	@Override
	public synchronized int size() {

		return this.size;
	}

	@Override
	public synchronized Object[] toArray() {
		return Arrays.copyOfRange(this.elementData, 0, this.size);
	}

	@Override
	public synchronized T[] toArray(T[] a) {
		System.arraycopy(this.elementData, 0, a, 0, this.size);
		return a;
	}

	@Override
	public synchronized Iterator<T> iterator() {
		
		return new Iterator<T>() {

			private int index = 0;
			
			@Override
			public boolean hasNext() {
				
				return this.index< MyVector.this.size;
			}

			@Override
			public T next() {
				T t = MyVector.this.get(this.index);
				this.index++;
				
				return t;
			}
			
			@Override
			public void remove() {
				MyVector.this.remove(this.index-1);
				this.index--;
			}
			
		};
	}

	@Override
	public synchronized void add(int index, T e) {
		this.calculateCapacity(index<this.size? 1 : index);
		for(int i = size-1; i>= index; i--) {
			this.elementData[i+1] = this.elementData[i];
		}
		this.elementData[index] = e;
		this.size++;

	}

	@Override
	public synchronized boolean addAll(int index, MyCollection<? extends T> c) {
		// 扩容
		this.calculateCapacity(c.size());
		
		// 移动index以及之后的元素，向后移c.size位。
		System.arraycopy(this.elementData, index, this.elementData, index+c.size(), this.size-index);
		
		
		// 将添加的元素，加到index之后
		for(T i : c) {
			this.elementData[index] = i;
			index++;
		}
		
		this.size += c.size();
		return true;
	}

	@Override
	public synchronized T get(int index) {
		
		return (T)this.elementData[index];
	}

	@Override
	public synchronized int indexOf(Object o) {
		int idx = -1;
		
		for(int i=0;i<this.size;i++) {
			if(this.elementData[i].equals(o)) {
				idx = i;
				break;
			}
		}
		
		return idx;
	}

	@Override
	public synchronized T remove(int index) {
		T t = (T)this.elementData[index];
		
		for(int i=index; i<this.size-1;i++) {
			this.elementData[i] = this.elementData[i+1];
		}
		
		size--;
		
		return t;
	}

	@Override
	public synchronized T set(int index, T e) {
		if(index>=this.size) {
			throw new IndexOutOfBoundsException();
		}

		T t = (T)this.elementData[index];
		this.elementData[index] = e;
		

		return t;
	}

	@Override
	public synchronized MyList subList(int from, int to) {
		MyArrayList<T> li = new MyArrayList(to-from);
		
		for(int i=from; i<to ; i++) {
			li.add((T)this.elementData[i]);
		}
		
		return li;
	}

	
	public synchronized String toString() {
		return Arrays.toString(Arrays.copyOfRange(this.elementData, 0, size));
	}
}

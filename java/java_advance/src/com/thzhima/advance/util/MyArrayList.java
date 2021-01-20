package com.thzhima.advance.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;


/**
 * @author wangrui
 *
 * @param <T>
 */
public class MyArrayList<T> implements MyList<T>, Serializable{

	
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
	
	public MyArrayList() {
		this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
	}
	
	public MyArrayList(int capacity) {
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
	private void calculateCapacity(int leng) {
		if(! (size+leng < this.elementData.length-1) ){
			Object[] newElementsData = new Object[size+leng+DEFAULT_CAPACITY];
			System.arraycopy(this.elementData, 0, newElementsData, 0, this.elementData.length);
			this.elementData = newElementsData;
		}
	}

	@Override
	public boolean add(T t) {
		this.calculateCapacity(1);
		this.elementData[this.size] = t;
		size++;
		return true;
	}

	@Override
	public boolean addAll(MyCollection<? extends T> c) {
		for(T o : c) {
			this.add(o);
		}
		return true;
	}

	@Override
	public void clear() {
		Arrays.fill(this.elementData, null);
		
		this.size = 0;

	}

	@Override
	public boolean contains(Object o) {
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
	public boolean containsAll(MyCollection<?> c) {
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
	public boolean isEmpty() {
		
		return this.size==0 ? true:false;
	}

	@Override
	public boolean remove(Object o) {
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
	public boolean removeAll(MyCollection<?> c) {
		boolean b = false;
		
		for(Object t : c) {
			if(this.remove(t)) {
				b = true;
			}
		}
		
		
		return b;
	}

	@Override
	public boolean retainAll(MyCollection<?> c) {
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
	public int size() {

		return this.size;
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOfRange(this.elementData, 0, this.size);
	}

	@Override
	public T[] toArray(T[] a) {
		System.arraycopy(this.elementData, 0, a, 0, this.size);
		return a;
	}

	@Override
	public Iterator<T> iterator() {
		
		return new Iterator<T>() {

			private int index = 0;
			
			@Override
			public boolean hasNext() {
				
				return this.index< MyArrayList.this.size;
			}

			@Override
			public T next() {
				T t = MyArrayList.this.get(this.index);
				this.index++;
				
				return t;
			}
			
			@Override
			public void remove() {
				MyArrayList.this.remove(this.index-1);
				this.index--;
			}
			
		};
	}

	@Override
	public void add(int index, T e) {
		this.calculateCapacity(index<this.size? 1 : index);
		for(int i = size-1; i>= index; i--) {
			this.elementData[i+1] = this.elementData[i];
		}
		this.elementData[index] = e;
		this.size++;

	}

	@Override
	public boolean addAll(int index, MyCollection<? extends T> c) {
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
	public T get(int index) {
		
		return (T)this.elementData[index];
	}

	@Override
	public int indexOf(Object o) {
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
	public T remove(int index) {
		T t = (T)this.elementData[index];
		
		for(int i=index; i<this.size-1;i++) {
			this.elementData[i] = this.elementData[i+1];
		}
		
		size--;
		
		return t;
	}

	@Override
	public T set(int index, T e) {
		if(index>=this.size) {
			throw new IndexOutOfBoundsException();
		}

		T t = (T)this.elementData[index];
		this.elementData[index] = e;
		

		return t;
	}

	@Override
	public MyList subList(int from, int to) {
		MyArrayList<T> li = new MyArrayList(to-from);
		
		for(int i=from; i<to ; i++) {
			li.add((T)this.elementData[i]);
		}
		
		return li;
	}

	
	public String toString() {
		return Arrays.toString(Arrays.copyOfRange(this.elementData, 0, size));
	}
	
	public static void main(String[] args) {
		MyArrayList<String> list = new MyArrayList<>();
		
//		Object[] a = list.toArray();
//		System.out.println(Arrays.toString(a));
		
		list.add("hello");
		list.add("hi");
		list.add("java");
		list.add("python");
		
		MyArrayList<String> li = new MyArrayList<>();
		li.add("hello");
		li.add("java");
		li.add("google");
		
		
		list.addAll(list.size()+1, li);
		System.out.println(list);
		
//		list.removeAll(li);
		
//		System.out.println(list);
		
//		System.out.println(list.containsAll(li));
//		
//		
//		list.retainAll(li);
//		
//		System.out.println(list);
//		System.out.println(list.size());
		
//		System.out.println(list.size());
//		System.out.println(list.contains("hello"));
//		System.out.println(list.contains("hi"));
//		
//		list.remove("hi");
//		System.out.println(list.size());
//		
//		list.add(0, "I");
//		list.add(4, ".");
//		list.add(2,"ok");
//        String[] barray = list.toArray(new String[list.size()]);
//		
//		System.out.println(Arrays.toString(barray));
//		System.out.println(list.contains("hi"));
//		
//		
//		System.out.println("================================");
//		for(int i=0;i<list.size();i++) {
//			System.out.println(list.get(i));
//		}
//		System.out.println("==============remove (2)==================");
//		list.remove(2);
//		list.set(list.size()-1, "!");
//		System.out.println(list);
//		
//		
//		System.out.println(list.subList(1, 4));
//		
//		for(String s : list) {
//			System.out.println(s);
//		}
//		
//		System.out.println("==================================================");
//		Iterator<String> iter = list.iterator();
//		
//		while(iter.hasNext()) {
//			String s = iter.next();
//			
//			
//			System.out.print(s + "\t");
//			if("java".equals(s)) {
//				iter.remove();
//			}
//		}
//		System.out.println("\n==================================================");
//		System.out.println(list);
//		Object[] a = list.toArray();
//		System.out.println(Arrays.toString(a));
		
		
		
		
		
//		String[] sarray = {"a", "b", "c"};
//		
//		Object[] oarray = sarray;
//		
//		
//		sarray = (String[]) oarray;
		
//		int[] a = {1,2,3,4,5,6,7,8,9,10, 0, 0, 0, 0, 0, 0};
//		
//		System.arraycopy(a, 6, a, 6+2, 4);
//		System.out.println(Arrays.toString(a));
		
		
		
		
	}
}

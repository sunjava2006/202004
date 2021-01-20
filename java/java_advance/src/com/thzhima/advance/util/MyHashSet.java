package com.thzhima.advance.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class MyHashSet<T> implements Set<T>{

	private Map<T, Object> map = new MyHashMap<>();
	
	private static final Object PRESENT = new Object();
	
	@Override
	public int size() {
		return this.map.size();
	}

	@Override
	public boolean isEmpty() {
		return this.map.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		
		return this.map.containsKey(o);
	}

	@Override
	public Iterator<T> iterator() {
		System.out.println("----------------Iterator<T> iterator-----------------");
		
		return new  Iterator<T>(){

			Set<Entry<T, Object>> set = MyHashSet.this.map.entrySet();
			Iterator<Entry<T, Object>> iter= set.iterator();
			
			@Override
			public boolean hasNext() {
				
				return iter.hasNext();
			}

			@Override
			public T next() {
				
				return (T) iter.next().getKey();
			}
			
			public void remove() {
				iter.remove();
			}
			
		};
	}

	@Override
	public Object[] toArray() {
		Object array[] = new Object[this.map.size()];
		int count = 0;
		for(Object i : this) {
			array[count++] = i;
		}
		
		return array;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		int count = 0;
		for(Object t : this) {
			a[count++] = (T) t;
		}
		
		return a;
	}

	@Override
	public boolean add(T e) {
		boolean contain = this.map.containsKey(e);
		if(! contain) {
			this.map.put(e, MyHashSet.PRESENT);
		}
		return !contain;
	}

	@Override
	public boolean remove(Object o) {
		
		boolean exists = this.map.containsKey(o);
		if(exists) {
			this.map.remove(o);
		}
		return exists;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		boolean exist = true;
		
		for(Object i : c) {
			boolean eq = false;
			for(T t : this) {
				if(c==null ? t==null : c.equals(t)) {
					eq = true;
					break;
				}
			}
			if(!eq) {
				exist = false;
				break;
			}
		}
		
		return exist;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		boolean add = false;
		for(T t : c) {
			if(this.add(t)) {
				add = true;
			}
		}
		return add;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		
		MyHashMap m = new MyHashMap();
		for(Object o : c) {
			for(T t : this) {
				if (o==null ? t==null : o.equals(t)) {
					m.put(o, MyHashSet.PRESENT);
				}
			}
		}
		
		
		boolean flag = m.size()==this.size() ? false: true;
		this.map = m;
		
		return flag;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean update = false;
		
		for(Object o : c) {
			if(this.remove(o)) {
				update = true;
			}
		}
		
		return update;
	}

	@Override
	public void clear() {
		this.map.clear();
		
	}
	
	
	
	@Override
	public String toString() {
		return Arrays.toString(this.toArray());
	}

	public static void main(String[] args) {
		Set<String> set = new MyHashSet<>();
		
		set.add("a");
		set.add("b");
		set.add("c");
		
		for(String i : set) {
			System.out.println(i);
		}
		
		System.out.println("remove(d):"+set.remove("d"));
//		System.out.println("remove(a):" + set.remove("a"));
		System.out.println(Arrays.toString(set.toArray()));
		
		
		System.out.println("================================");
		Set<String> set2 = new MyHashSet<>();
		
		set2.add("a");
		set2.add("b");
		set2.add("c");
		set2.add("d");
		
		System.out.println(set.addAll(set2));
		System.out.println(set.size());
		System.out.println(Arrays.toString(set.toArray()));
		
		set2.remove("a");
		
		System.out.println(set.retainAll(set2));
		System.out.println(Arrays.toString(set.toArray()));
		
		System.out.println("set2:" + set2);
		
		set2.clear();
		
		System.out.println("after clear set2:" +  set2);
		set2.add("b");
		set2.add("c");
		
		System.out.println("set:" + set);
		System.out.println(set.removeAll(set2));
		System.out.println("set:" + set) ;
	}

}

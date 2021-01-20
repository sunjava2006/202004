package com.thzhima.advance.util.hash;

public class HashTest<T> {
	
	private T[] array = (T[]) new Object[16];
	
	
	public void save(T e) {
		int idx = this.hash(e.hashCode());
		this.array[idx] = e;
	}
	
	public T get(int hashCode) {
		int idx = this.hash(hashCode);
		return this.array[idx];
	}
	
	public int hash(int hashCode) {
		
		return hashCode%array.length;
	}
	
	
	public static void main(String[] args) {
		HashTest<Integer> ha = new HashTest<>();
		
		Integer a = 100;
		Integer b = 124;
		Integer c = 3;
		
		ha.save(a);
		
		ha.save(b);
		
		ha.save(c);
	
		
		Boolean bb;
		
		System.out.println("100:"+100%16+":" + ha.get(a.hashCode()) );
		System.out.println("124:"+124%16+":"  + ha.get(b.hashCode()) );
		System.out.println("3:" +3%16+":" + ha.get(c.hashCode()) );
	}
	
}

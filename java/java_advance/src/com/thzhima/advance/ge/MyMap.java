package com.thzhima.advance.ge;

public interface MyMap<K, V> {

//	K k = 90;  �����ԣ���Ϊ�ӿ���������static.
	
	void put(K k, V v);
	
	V get(K k);
	
}


class MyHashMap<K, V> implements MyMap<K, V>{

	@Override
	public void put(K k, V v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V get(K k) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
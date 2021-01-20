package com.thzhima.advance.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



public class MyHashMap<K, V> implements Map<K, V>{
	
	transient Node<K,V>[] table = new Node[16];
	
	
	transient int size;
	
	
	private int hash(Object k) {
		return Math.abs(k.hashCode()% table.length);
	}
	

	@Override
	public int size() {
		
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		
		return size==0 ? true: false;
	}

	@Override
	public boolean containsKey(Object key) {
		boolean contain = false;
		int idx = this.hash(key);
		
		Node<K, V> n = this.table[idx];
		if(n != null) {
			Node<K, V> curr = n;
			do {
				if(key==null? curr.getKey()==null : key.equals(curr.getKey())) {
					contain = true;
					break;
				}
				
				curr = curr.next;
				
			
			}while(curr!=null);
		}
		return contain;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		V v = null;
		
		int idx = this.hash(key);
		Node n = this.table[idx];
		
		if(null != n) {
			Node<K, V> curr = n;
			do {
				if(curr.key.equals(key)) {
					v = curr.getValue();
					break;
				}
				curr = curr.next;
			}while(null != curr);
		}

		return v;
	}

	@Override
	public V put(K key, V value) {
		V v = null;
		int idx= this.hash(key);
		
		Node<K, V> node = this.table[idx]; // 第一个链表节点
		if(node == null) { // 该桶中原先没有元素。
			Node<K, V> n = new Node<>(key, value, null);
			this.size++;
			this.table[idx] = n;
		}else { // 已经有节点，要向其中添加链表节点
			Node<K,V> curr = node;
			
			boolean exist = false;
			
			do{
				if(curr.getKey()==null? key==null : curr.getKey().equals(key)) {
					v = curr.getValue();
					curr.setValue(value);
					exist = true;
					break;
				}
				if(curr.next!=null) {
					curr = curr.next;
				}
				
			}while(null!=curr.next) ;
			
			if(! exist) {
				Node<K, V> n = new Node<>(key, value, curr, null);
				curr.next = n;
				size++;
			}
			
		}
		return v;
	}

	@Override
	public V remove(Object key) {
		V v = null;
		
		int idx = this.hash(key);
		Node<K,V> n = this.table[idx];
		if(null != n) {
			do {
				if(key==null ? n.getKey()==null : key.equals(n.getKey())) {
					v = n.getValue();
					
					if(n.previous==null && n.next==null) { // 唯一节点
						n=null;
						this.table[idx] = null;
					}else if(n.previous==null && n.next!=null) {// 头节点
						n.next.previous = null;
						
						this.table[idx]=n.next;
						n.next = null;
						n = null;
					}
					else if(n.previous!=null && n.next!=null) { // 中间节点
						n.previous.next = n.next;
						n.next.previous = n.previous;
						n.previous=null;
						n.next = null;
						n = null;
					}else { // 尾节点
						n.previous.next = null;
						n.previous = null;
						n=null;
								
					}

							
					size--;
					break;
				}
				n = n.next;
			}while(n != null);
		}
		
		return v;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		Set<?> set =  m.entrySet();
		for(Object i : set) {
			Map.Entry<K, V> i2 = (Entry<K, V>) i;
			this.put(i2.getKey(), i2.getValue());
		}
		
	}

	@Override
	public void clear() {
		Arrays.fill(this.table, null);
		size = 0;
	}

	@Override
	public Set<K> keySet() {
		MyHashSet<K> set = new MyHashSet<>();
		for(Map.Entry<K, V> i : this.entrySet()) {
			System.out.println("key: "+i.getKey());
			set.add(i.getKey());
		}
		return set;
	}

	@Override
	public Collection<V> values() {
		Set<V> set = new MyHashSet<>();
		for(Map.Entry<K, V> i : this.entrySet()) {
			set.add(i.getValue());
		}
		return set;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K,V>> set = new Set<Map.Entry<K,V>>() {

			
			Map<Entry<K, V>, Object> map = new MyHashMap<>();
			
			{
				
				for(Node n : MyHashMap.this.table) {
					if(n != null) {
						do {
							map.put(n, null);
							n = n.next;
						}while(n != null);
					}
				}
			}
			
			@Override
			public int size() {
				
				return size;
			}

			@Override
			public boolean isEmpty() {
				
				return MyHashMap.this.isEmpty();
			}

			@Override
			public boolean contains(Object o) {
				
				return MyHashMap.this.containsKey(o);
			}

			@Override
			public Iterator<Entry<K, V>> iterator() {
				Iterator<Entry<K, V>> iter = new Iterator<Map.Entry<K,V>>() {

					private int index = 0;
					
					Entry<K,V>[] a = toArray(new Entry[size]);
					
					@Override
					public boolean hasNext() {
						
						return this.index<=a.length-1;
					}

					@Override
					public Entry<K, V> next() {
						
						return a[index++];
					}
					
					@Override
					public void remove() {
						map.remove(a[index--]);
					}
					
				};
				return iter;
			}

			@Override
			public Object[] toArray() {
				Object[] array = new Object[size];
				int count = 0;
				for(Node n : MyHashMap.this.table) {
					if(n != null) {
						do {
							array[count++] = n;
							n = n.next;
						}while(n != null);
					}
				}
				return array;
			}

			@Override
			public <T> T[] toArray(T[] a) {
				int count = 0;
				for(Node n : MyHashMap.this.table) {
					if(n != null) {
						do {
							a[count++] = (T) n;
							n = n.next;
						}while(n != null);
					}
				}
				return a;
			}

			@Override
			public boolean add(Entry<K, V> e) {
				boolean exist = this.map.containsKey(e.getKey());
				this.map.put(e, null);
				return exist;
			}

			@Override
			public boolean remove(Object o) {
				
				boolean exist = this.map.containsKey(o);
				this.map.remove(o);
				return exist;
			}

			@Override
			public boolean containsAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean addAll(Collection<? extends Entry<K, V>> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean retainAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean removeAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}
		};
		
		return set;
	}
	
	class Node<K, V> implements Map.Entry<K, V>{
		
		private final K key;
		private V value;
		Node<K,V> next;
		Node<K,V> previous;
		
		
		
		Node(K k, V v, Node previous, Node next){
			this.key = k;
			this.value = v;
			this.previous = previous;
			this.next = next;
		}
		Node(K k, V v, Node next){
			this.key = k;
			this.value = v;
			this.next = next;
		}

		@Override
		public K getKey() {
			
			return this.key;
		}

		@Override
		public V getValue() {
			
			return this.value;
		}

		@Override
		public V setValue(V value) {
			V v = this.value;
			this.value = value;
			return v;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

		private MyHashMap getEnclosingInstance() {
			return MyHashMap.this;
		}
		
		
		
	}
	
//	static final int MAXIMUM_CAPACITY = 1 << 30;
//	
//	 static final int tableSizeFor(int cap) {
//	        int n = cap - 1;
//	        n |= n >>> 1;
//	        n |= n >>> 2;
//	        n |= n >>> 4;
//	        n |= n >>> 8;
//	        n |= n >>> 16;
//	        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
//	    }
	
	
	public static void main(String[] args) {
		MyHashMap<Object, String> m = new MyHashMap<>();
		
		System.out.println(m.put(100, "oneH"));
		System.out.println(m.put(2, "two"));
		System.out.println(m.put('d', "d"));
		System.out.println(m.put(2,  "TWO"));
		System.out.println("=========================================");
		System.out.println(m.get(100));
		System.out.println(m.get(2));
		System.out.println(m.get('d'));
		System.out.println("------------------------------------");
		System.out.println(m.size);
		System.out.println(m.get('d'));
//		System.out.println((char)100);
//		System.out.println(new Character('d').hashCode());
		System.out.println("===============================================");
//		System.out.println(m.remove("xx"));
//		System.out.println(m.remove(100));
//		System.out.println(m.remove(100));
//		System.out.println(m.remove('d'));
//		System.out.println(m.remove('d'));
//		System.out.println(m.remove(2));
//		System.out.println(m.size);
		
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		Set<Map.Entry<Object, String>> set = m.entrySet();
		
		for(Map.Entry<Object, String> i: set) {
			System.out.println(i.getKey()+":"+i.getValue());
		}
		System.out.println("****************************");
		Set<Object> s = m.keySet();
	
		for(Object i : s) {
			System.out.println(i);
			
		}
	}
}

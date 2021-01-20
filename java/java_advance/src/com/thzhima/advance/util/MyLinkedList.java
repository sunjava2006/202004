package com.thzhima.advance.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T>, MyDeque<T>, Serializable{

	private int size;
	private Node first;
	private Node last;
	
	
	public MyLinkedList(){
		
	}
	
	public MyLinkedList(MyCollection<? extends T> c) {
		
		
		if(c != null && c.size()>0) {
			
			Iterator<? extends T> iter = c.iterator();
			
			while(iter.hasNext()) {
				T t = iter.next();
				
				// Ϊ����c��ÿһ��Ԫ�أ������½ڵ㡣
				Node n = new Node(t);
				
				if(this.size==0){  // Ҫ���ص���ͷ�ڵ�
					this.first = this.last = n;
					
				}else { // �����½ڵ㵽β�ڵ�֮��
					this.last.next = n;
					n.previous = this.last;
					this.last = n;
				}
				
				size++;
			}
				
			
		}
		
		
	}
	
	
	@Override
	public boolean add(T t) {
		// 1������һ���½ڵ�
		Node n = new Node(t);
		
		// 2�����ڵ���ӵ�������
		if(size == 0) { // ��ӵ�һ��Ԫ��
			this.first = n;
			this.last = n;
		}else { // ������β֮�����һ����Ԫ��
			
			// ��������ڵ�֮���˫�����
			n.previous = this.last; 
			this.last.next = n;
			
			// �ƶ�βָ�룬ָ�����Ľڵ�
			this.last = n;
			
		}
		// 3��size ++
		this.size++;
		
		return true; // ��List��Deque�ӿ�������LinkedList���޽�ġ�
	}

	@Override
	public boolean addAll(MyCollection<? extends T> c) {
		// ������ӵ����ݼ��ϣ�ȡ��ÿһ��Ԫ�أ���ӵ������С�
		for(T i : c) {
			this.add(i);
		}
		return true;
	}

	@Override
	public void clear() {
		// �������нڵ㣬���ᱻGC��
		size = 0;
		this.first = this.last = null;
	}

	@Override
	public boolean contains(Object o) {
		boolean have = false;
		if(size>0) {
			Node curr = first;
			do {
				// �ж϶����Ƿ���ȣ���Ϊnull .
				if(o==null? curr.value==null : o.equals(curr.value) ) {
					have = true;
					break;
				}
				
			}while(null!= (curr = curr.next));
		}
		return have;
	}

	@Override
	public boolean containsAll(MyCollection<?> c) {
		boolean contain = true; // �Ƿ������Ӽ�
		
		// ����c��ÿһ��Ԫ�أ��������Ԫ���Ƿ��ڵ�ǰ�б��С�
		for(Object o : c) {
			boolean eq = false;   // �������o��ͬ��Ԫ�أ�eq Ϊ�档
			for(Object i : this) {
				if(o==null? i==null: o.equals(i)) {
					eq = true;
					break;
				}
			}
			if(!eq) { // ֻ��c����һ��Ԫ�ز����ڣ�c �Ͳ������Ӽ���
				contain = false;
				break;
			}
		}
		return contain;
	}

	@Override
	public boolean isEmpty() {
		
		return size==0 ? true : false;
	}

	@Override
	public boolean remove(Object o) {
		boolean update = false;
		
		Node curr = this.first;
		do {
			if(o==null ? curr.value==null : o.equals(curr.value)) {
				curr.previous.next = curr.next;
				curr.next.previous = curr.previous;
				curr.previous = null;
				curr.next = null;
				update = true;
				size--;
			}
		}while(null != (curr = curr.next));
		
		return update;
	}

	@Override
	public boolean removeAll(MyCollection<?> c) {
		boolean update = false;
		
		for(Object o : c) {
			
			if(this.remove(o)) {
				update = true;
			}
			
		}
		
		return update;
	}

	@Override
	public boolean retainAll(MyCollection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		
		return this.size;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
		
		Node curr = this.first;
		for(int i=0; i<size; i++) {
//			System.out.println(i +":"+curr);
			array[i] = curr.value;
			curr = curr.next;
		}

		return array;
	}

	@Override
	public T[] toArray(T[] a) {
		Node curr = this.first;
		for(int i=0; i<size; i++) {
			a[i] = curr.value;
			curr = curr.next;
		}
		return a;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){

			private int idx = 0;
			
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return this.idx<size ? true : false;
			}

			@Override
			public T next() {
				T t =MyLinkedList.this.get(idx);
				idx++;
				return t;
			}
			
			@Override
			public void remove() {
				MyLinkedList.this.remove(--idx);
				
			}
			
		};
	}
	
	@Override
	public void add(int index, T e) {
		// 1������һ���½ڵ㣬��������
		Node n= new Node(e);
		
		if(index==0) {
			// �����������
			this.first.previous = n;
			n.next = this.first;
			this.first = n;
		}else if(index>0 && index<size) {
			// 2���ҵ�indexλ�õĽڵ㣬
			Node curr = first;
			for(int i=0;i<index; i++, curr=curr.next);
			
			// 3����index�ڵ�ǰ����½ڵ㣬�����������
			curr.previous.next = n;
			n.next = curr;
			n.previous = curr.previous;
			curr.previous = n;
			
			
		}else { // ������β�����һ��
			// �����������
			this.last.next = n;
			n.previous = this.last;
			this.last = n;
		}
		
		size++;

		
	}

	@Override
	public boolean addAll(int index, MyCollection<? extends T> c) {
		boolean add = false;
		
		// 1������c����һ������
		MyLinkedList<T> subList = new MyLinkedList<T>(c);
		
		if(subList.size>0) {
			add = true;
			
			// 2������index��ָ����λ�ã���������ͷ�������С�����β���в�ͬ�Ĵ���
			if(index <= 0) { // ��ӵ�����ͷ
				this.first.previous = subList.last;
				subList.last.next = this.first;
				this.first = subList.first;
				
			}else if(index<this.size) {  // ��ӵ�������
				
				// ��λ��indeָ���Ľڵ�
				Node curr = first;
				for(int i=0;i<index; i++, curr=curr.next);
				
				// inde֮ǰ�Ľڵ�
				Node pre = curr.previous; // 
				
				// pre����������
				pre.next = subList.first;
				subList.first.previous = pre;
				
				// curr����������
				subList.last.next = curr;
				curr.previous = subList.last;
				
				
			}else {  // ��ӵ�����β
				this.last.next = subList.first;
				subList.first.previous = this.last;
				this.last = subList.last;
				
			}
			
			// 3��size�ı�
			size += c.size();
		}
	   
		
		return add;
	}

	@Override
	public T get(int index) {
		T t  = null;
		Node curr = first;
		for(int i=0; i<index; i++) {
			curr = curr.next;
		}
		t = curr.value;
		return t;
	}

	@Override
	public int indexOf(Object o) {
		int idx = -1;
		
		Node curr = this.first;
		Iterator<T> iter = this.iterator();
		
		int i = 0;
		while(iter.hasNext()) {
			T t = iter.next();
			if(t==null? o==null : t.equals(o)) {
				idx = i;
				break;
			}
			i++;
			
		}

		return idx;
	}

	@Override
	public T remove(int index) {
		T t = null;
		
		// 1�����ҵ�indexָ���Ľڵ�
		Node curr = first;
		for(int i=0; i<index; i++) {
			curr = curr.next;
		}
		t = curr.value;
		
		// 2���Ͽ���ǰ�ڵ㣬������ڵ�ǰ����Ľڵ��������
		if(curr != first && curr != last) {
			curr.previous.next = curr.next;
			curr.next.previous = curr.previous;
			curr.previous = curr.next = null;
		}
		
		if(first == last) {
			this.clear();
			return t;
		}else {
			if(curr == first) {
				first = first.next;
				first.previous.next = null;
				first.previous = null;
			}
			if(curr == last) {
				
					last = last.previous;
					last.next.previous = null;
					last.next = null;
				
			}
		}
		
		
		
		
		size--;
		
		return t;
	}

	@Override
	public T set(int index, T e) {
		T t = null;
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("index �����б��ȷ�Χ�ڡ�");
		}else {
			// ���ҵ�indexָ���Ľڵ�
			Node curr = this.first;
			for(int i=0;i<index; i++, curr=curr.next);
			
			// ȡ�ڵ�ԭֵ��������ֵ��
			t = curr.value;
			curr.value = e;
		}
		
		return t;
	}

	@Override
	public MyList subList(int from, int to) {
		MyLinkedList<T> sub = null;
		if(from > to || from<0 || to>size ) {
			throw new IndexOutOfBoundsException("�������ڷ�Χ�ڡ�");
		}else if(from == to) {
			sub = new MyLinkedList<>();
		}
		else  {
			
			// ƴ�ճ�һ��������
			// 1���ҵ�from�ڵ� 2���ҵ�to֮ǰ�Ľڵ�
			Node currNode = first;
			Node fromNode = currNode;
		    Node toNode = null;
			
			for(int i=0; i<to-1; i++) {
				if(i == from) {
					fromNode = currNode;
				}
				currNode = currNode.next;
			}
			
			toNode = currNode;
			
			
			// 3������һ���µ��������������������ͷ��βָ�룬ָ������������Ӧ�Ľڵ㡣
			
			sub = new MyLinkedList<>();
			sub.size = to-from;
			sub.first = fromNode;
			sub.last = toNode;
			
		}
		return sub;
	}
	
	
//=====================================================================================================
	@Override
	public T remove() throws NoSuchElementException {
		T t = null;
		if(this.size==0) {
			throw new NoSuchElementException("��ǰ�������Ѿ�Ϊ�գ�û��Ԫ���ˡ�");
		}else {
			t = this.remove(0);
		}
		return t;
	}

	@Override
	public T element() throws NoSuchElementException {
		T t = null;
		if(this.size==0) {
			throw new NoSuchElementException("��ǰ�������Ѿ�Ϊ�գ�û��Ԫ���ˡ�");
		}else {
			t = this.get(0);
		}
		return t;
	}

	@Override
	public boolean offer(T t) {
		return this.add(t);
	}

	@Override
	public T poll() {
		T t = null;
		if(size>0) {
			t = this.remove(0);
		}
		return t;
	}

	@Override
	public T peek() {
		T t = null;
		if(size>0) {
			t = this.get(0);
		}
		return t;
	}

	@Override
	public void addFirst(T e)
			throws IllegalStateException, IllegalArgumentException, ClassCastException, NullPointerException {
		this.add(0, e);
		
	}

	@Override
	public void addLast(T e)
			throws IllegalStateException, IllegalArgumentException, ClassCastException, NullPointerException {
		this.add(e);
		
	}

	@Override
	public boolean offerFirst(T e) {
		
		boolean ok = true;
		try {
			this.add(0,e);
		}catch(Exception ex) {
			ex.printStackTrace();
			ok = false;
		}
		
		return ok;
	}

	@Override
	public boolean offerLast(T e) {
		boolean ok = true;
		try {
			this.add(e);
		}catch(Exception ex) {
			ex.printStackTrace();
			ok = false;
		}
		return ok;
	}

	@Override
	public T removeFirst() throws NoSuchElementException {
		T t = null;
		if(size == 0) {
			throw new NoSuchElementException("��ǰ�������Ѿ�Ϊ�գ�û��Ԫ���ˡ�");
		}else {
			t = this.remove(0);
		}
		return t;
	}

	@Override
	public T removeLast() throws NoSuchElementException {
		T t = null;
		if(size == 0) {
			throw new NoSuchElementException("��ǰ�������Ѿ�Ϊ�գ�û��Ԫ���ˡ�");
		}else {
			t = this.remove(size-1);
		}
		return t;
	}

	@Override
	public T pollFirst() {
		T t = null;
		if(size>0){
			t = this.remove(0);
		}
		return t;
	}

	@Override
	public T pollLast() {
		T t = null;
		if(size>0){
			t = this.remove(size-1);
		}
		return t;
	}

	@Override
	public T getFirst() throws NoSuchElementException {
		return this.element();
	}

	@Override
	public T peekFirst() {
		
		return this.peek();
	}

	@Override
	public T getLast() throws NoSuchElementException {
		T t = null;
		if(size == 0) {
			throw new NoSuchElementException("��ǰ�������Ѿ�Ϊ�գ�û��Ԫ���ˡ�");
		}else {
			t = this.get(size-1);
		}
		return t;
	}

	@Override
	public T peekLast() {
		T t = null;
		if(size>0) {
			t = this.get(size-1);
		}
		return t;
	}

	@Override
	public boolean removeFirstOccurrence(Object o) throws ClassCastException, NullPointerException {
		boolean del = false;
		
		Iterator<T> iter = this.iterator();
		while(iter.hasNext()) {
			T t = iter.next();
			if(t==null ? o == null : t.equals(o)) {
				iter.remove();
				del = true;
				break;
			}
		}
		return del;
	}

	@Override
	public boolean removeLastOccurrence(Object o) throws ClassCastException, NullPointerException {
		boolean del = false;
		int idx = -1;
		
		Node curr = last;
		if(curr.value==null? o==null : curr.value.equals(o)) {
			del = true;
			idx = this.size-1;
		}else {
			for(int i=size-1;i>=0;i--) {
				if(curr.value==null? o==null : curr.value.equals(o)) {
					del = true;
					idx = i;
					break;
				}
				curr = curr.previous;
			}
			
		}
		
		if(del) {
			this.remove(idx);
		}
		
		
		return del;
	}

	
	
	public String toString() {
		return Arrays.toString(this.toArray());
	}
	
	private class Node{
		T value;
		Node previous;
		Node next;
		
		Node(){
			
		}
		
		Node(T value, Node previous, Node next){
			this.value = value;
			this.previous = previous;
			this.next = next;
		}
		
		Node(T value){
			this(value, null, null);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			
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
			
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

		
	}
	
	@Override
	public int hashCode() {
		int h = 1;
		h += 31*h + size;
		h += 31*h + this.first.hashCode(); 
		h += 31*h + this.last.hashCode(); 
		for(T t : this) {
			h += 31*h + t.hashCode();
		}
		return h;
	}
	
	@Override
	public boolean equals(Object o) {
	    if(this == o) {
	    	return true;
	    }
	    if(o==null) {
	    	return false;
	    }
	    if(! (o instanceof MyLinkedList)) {
	    	return false;
	    }
	    MyLinkedList oth = (MyLinkedList) o;
	    if(this.size != oth.size) {
	    	return false;
	    }
	    if(this.size==oth.size && this.first==oth.first && this.last==oth.last) {
	    	return true;
	    }
	    
	    Iterator<T> aiter = this.iterator();
	    Iterator<T> oiter = oth.iterator();
	    while(aiter.hasNext() && oiter.hasNext()) {
	    	T t1=  aiter.next();
	    	T t2 = oiter.next();
	    	
	    	if(!(t1==null? t2==null: t1.equals(t2))) {
	    		return false;
	    	}
	    }
	    
	    return true;
	    
	}
	
	
	public static void main(String[] args) {
		MyDeque<String> que = new MyLinkedList<>();

		
		que.offer("java");
		que.offer("python");
		que.offer("c");
		que.offer("js");
		que.offerLast("c++");
		que.offerLast("c#");
		
		
		
        MyDeque<String> que2 = new MyLinkedList<>();

		
		que2.offer("java");
		que2.offer("python");
		que2.offer("c");
		que2.offer("js");
		
		que2.offerLast("c#");
		que2.offerLast("c++");
		
//		System.out.println(que.peek());
//		System.out.println(que.peek());
//		System.out.println(que.peekFirst());
//		System.out.println("-------------------------------");
//		
//		System.out.println(que.poll());
//		System.out.println(que.pollFirst());
//		System.out.println(que.poll());
//		System.out.println(que.pollFirst());
//		
//		
//		//==================================================
//		que.offerFirst("english");
//		que.offerFirst("chinese");
//		que.addFirst("Japan");
//		
//		System.out.println(que);
//		
//		System.out.println(que.pollLast());
//		System.out.println(que.removeLast());
//		System.out.println(que.pollLast());
//		System.out.println(que.removeLast());
//		System.out.println(que.pollLast());
//		System.out.println(que.pollLast());
//		System.out.println(que.pollLast());
//		System.out.println(que.pollLast());
//		
//		System.out.println(que.removeLast());
//		
		System.out.println(que.hashCode());
	
		System.out.println(que.hashCode());
		
		
		System.out.println(que.equals(que2));
	}
	

}

package com.thzhima.javabase.oop.inner;

public class LinkedList {

	private int size = 0; // ˽�У��ṩһ����ȡ���ݵķ�������������Ա�Ϊֻ�����ԡ�
	
	private Node first, last ;
	
	
	public void add(Object e) {
		if(0 == size) {// �б�ǰΪ�յġ���ӵ���ͷһ���ڵ�
			Node newNode = new Node(e, null, null);
			this.first = newNode;
			this.last = newNode;
		}else { // ���ǵ�һ���ڵ��ˡ� 
			Node newNode = new Node(e, this.last, null);
			this.last.next = newNode;
			this.last = newNode;
		}
		
		this.size++;
	}
	
	public int size() {
		return this.size;
	}
	
	public Object get(int idx) {
		Object v = null;
		if(this.size>0) {
			if(idx >= 0 && idx<this.size) {
				Node curr = this.first;
				for(int i=0; i< idx; i++) {
					curr = curr.next;
				}
				v = curr.value;
			}
		}
		return v;
	}
	
	class Node{
		Object value;
		Node previous;
		Node next;
//		int size = LinkedList.this.size;
		Node(){
			
		}
		
		Node(Object v, Node p, Node n){
			this.value = v;
			this.previous = p;
			this.next = n;
		}
	}
	

}

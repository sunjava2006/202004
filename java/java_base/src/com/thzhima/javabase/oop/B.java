package com.thzhima.javabase.oop;

public class B extends A{

	String name = "B";
	
	void print() {
		System.out.println(this.name+super.name);
	}
	
	public static void main(String[] args) {
		B b = new B();
		
		System.out.println(b.name);
		b.print();
	}
}

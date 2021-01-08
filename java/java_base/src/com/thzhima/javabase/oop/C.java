package com.thzhima.javabase.oop;

public class C extends B{

	String name = "C";
	
    void print() {
    	System.out.println(this.name + super.name);
    }
    
    public static void main(String[] args) {
		C c= new C();
		System.out.println(c.name);
//		c.print();
		
		B b = c;
		System.out.println(b.name);
		
		A a = c;
		System.out.println(a.name);
	}
}

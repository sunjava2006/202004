package com.thzhima.javabase.oop;

public class Param1 {

	void a(int a, int b) {
		a--;
		System.out.println(a + b); // 99
	}
	
	public static void main(String[] args) {
		Param1 p = new Param1();
		
		int i = 10;
		int j = 90;
		
		p.a(i, j);
		System.out.println(i + j); // 100
		
	}
	
}

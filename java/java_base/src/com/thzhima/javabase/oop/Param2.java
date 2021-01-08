package com.thzhima.javabase.oop;

public class Param2 {
	
	void a(Human h) {
		h = new Human("男", "LI", "中国");
		System.out.println(h); // "男", "LI", "中国
	}
	
	void b(Human h) {
		h.gender="女"; //
		System.out.println(h); // "女", "LiSa", "Tailand"
	}
	
	public static void main(String[] args) {
		Param2 p = new Param2();
		
		Human h = new Human("人妖", "LiSa", "Tailand");
		
		p.b(h);
		System.out.println(h); // "女", "LiSa", "Tailand"
		
		
	}
}

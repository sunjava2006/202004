package com.thzhima.javabase.oop;

public class Param2 {
	
	void a(Human h) {
		h = new Human("��", "LI", "�й�");
		System.out.println(h); // "��", "LI", "�й�
	}
	
	void b(Human h) {
		h.gender="Ů"; //
		System.out.println(h); // "Ů", "LiSa", "Tailand"
	}
	
	public static void main(String[] args) {
		Param2 p = new Param2();
		
		Human h = new Human("����", "LiSa", "Tailand");
		
		p.b(h);
		System.out.println(h); // "Ů", "LiSa", "Tailand"
		
		
	}
}

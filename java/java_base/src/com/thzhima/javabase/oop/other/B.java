package com.thzhima.javabase.oop.other;


class B extends A{
	public static String a = "b";
	static{
//		B.a = "B";
		System.out.println(A.a);
	}

//	@Override
//	public static void todo() {
//		System.out.println("=====================");
//	}
	
	public static void main(String[] args) {
		A a = new B();
		a.todo();
		
		B b = (B)a;
		b.todo();
		
		A.todo();
		B.todo();
	}
}

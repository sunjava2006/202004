package com.thzhima.javabase.oop;

public final  class People {
	public static final String ORIGIN ; //= "EARTH"; // 申明初始化
	
	Integer i;

	public final String gender ;
	
	{
//		this.gender = ""; //代码块也可以初始化常量
	}
	
	static {
		ORIGIN = "Duno"; // 初始化静态常量
	}
	
	public People(String gender) {
		this.gender = gender;   // 构造初始化常量
	}
	
	public final void sleep() { // 不能被重写
		System.out.println("sleep.............");
	}
}


//class Worker extends People{
//
//	public Worker(String gender) {
//		super(gender);
//	}
//	
////	public final void sleep() {
////		System.out.println("sleep.............");
////	}
//	
//}
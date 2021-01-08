package com.thzhima.javabase.oop;

public class A {

	String  name = "A";  //  实例变量
	static public String country = "中国"; // 在类上分配存储空间并赋值。静态变量
	
	String myCountry =  country;
//	static String myName = name;
	
	
	static void about() {
		System.out.println(A.country);
		A a = new A();
		System.out.println(a.name);
	}
	
	
	static {
		System.out.println(); // 在类加载时运行。类只加载1次。静态块也只执行一次。初始化静态数据。
	}
	
	{
		System.out.println();
	}
	
	public static void main(String[] args) {
//		A a = new A();
//		A b = new A();
//		
//		A.country = "China";
//		System.out.println(A.country);  // 因为静态成员是属于类的， 所以直接通过类名来访问。
//		
//		System.out.println(a.country);
//		System.out.println(b.country);
	}
	
}

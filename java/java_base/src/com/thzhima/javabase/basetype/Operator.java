package com.thzhima.javabase.basetype;

public class Operator {

	public static void main(String[] args) {
		
		
		int a = 2;
//		a = a ** 2;
		
		System.out.println(3/2);
		System.out.println(3f/2);
		System.out.println(3.0/2);
		System.out.println((int)(3.0/2));
		
		System.out.println(String.valueOf(1) == "1");
		System.out.println(1 == Integer.parseInt("1"));
		
		int i = 1==1?10:20;
		System.out.println(i);
		
		String s = "hello"; // String是对象类型。不是基本数据类型
		System.out.println(s instanceof String);
		
	}
}

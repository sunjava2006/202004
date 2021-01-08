package com.thzhima.javabase.basetype;

public class Array {

	public static void main(String[] args) {
		int a[]; // C 
		int[] b;  // Java
		
		b = new int[3]; // new 是创建对象。[ ]中指明数组的长度。会缺省初始化数组元素。数值类型都初始化为0.
		
		for(int i : b) {
			System.out.println(i);
		}
		
		boolean[] barray = new boolean[3]; // boolean类型数组，每个元素缺省初始化为false。
		for(boolean i : barray) {
			System.out.println(i);
		}
		
		char[] carray = new char[3]; // char类型数组，每个元素缺省初始化为0编码的字符。
		for(char i : carray) {
			System.out.println((int)i);
		}
		
		String[] sarray = new String[3]; // 对象类型的数组，每个元素缺省初始化为null。
		for(String i : sarray) {
			System.out.println(i);
		}
		
		b[0] = 10;
		b[1] = 20;
		b[2] = 30;
		for(int i=0; i<b.length; i++) {
			System.out.println(i + ":" + b[i]);
		}
		
	}
}

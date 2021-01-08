package com.thzhima.javabase.basetype;

public class TypeChange {

	public static void main(String[] args) {
		
		// boolean类型与任何类型之间都不可以转换
//		int a = false;
//		boolean b = 1;
		
		byte b = 124;
		int i = b;
		long l = i;
		short s = b;  // 隐式类型转换。
		i = (int)l;  // 大存储空间的数据要放到小的存储空间中, 强制类型转换。
		
		int ii = 'a';
		char c = 90;
		
		long l2 = 90; // 一个整数，默认是int类型。
		long l3 = 90L;
		
		float f = 3.14F;
		double d = f;
		f = (float)d; // 大存储空间的数据要放到小的存储空间中, 强制类型转换。
		
		//========================================
		float f2 = Long.MAX_VALUE;
		System.out.println(Long.MAX_VALUE);
		System.out.println(f2);
		
		double dd = Long.MAX_VALUE;
		System.out.println(dd);
		
		final int age = 90;
//		age ++;  final 关键字，用来修饰常量。常量只能初始化一次。
		
	}
}

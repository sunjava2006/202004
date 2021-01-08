package com.thzhima.javabase.basetype;

public class BaseType {

	public static void main(String[] args) {
		// boolean类型值只有true\false
		boolean b = true;
		boolean b2;
//		System.out.println(b2);
		
		// 任何类型都不能转换成boolean类型。
		if(1==1) {
			
		}
		
		// char，单个字符类型，用  单引号括起来(  '  )
		char c = '中';
		char c2 = 20013;
		System.out.println(c);
		System.out.println((int)c);
		System.out.println(c2);
		
		// byte字节，8位。  （bit位）
		byte by = 127;
		
		// short 短整型， 16位
		short s = -32768;
		
		// int 整型， 32位
		int i = 2147483647+1;
		System.out.println(i);
		
		// long 长整型， 64位
		long l = Long.MAX_VALUE;
		long l2 = Long.MIN_VALUE;
		
		// float类型。小数，32位。
		float f = 3.14F;
		
		// double双精度小数类型，64位。
		double d = 3.14;
		
		
	}
}

package com.thzhima.javabase.basetype;

public class TypeChange {

	public static void main(String[] args) {
		
		// boolean�������κ�����֮�䶼������ת��
//		int a = false;
//		boolean b = 1;
		
		byte b = 124;
		int i = b;
		long l = i;
		short s = b;  // ��ʽ����ת����
		i = (int)l;  // ��洢�ռ������Ҫ�ŵ�С�Ĵ洢�ռ���, ǿ������ת����
		
		int ii = 'a';
		char c = 90;
		
		long l2 = 90; // һ��������Ĭ����int���͡�
		long l3 = 90L;
		
		float f = 3.14F;
		double d = f;
		f = (float)d; // ��洢�ռ������Ҫ�ŵ�С�Ĵ洢�ռ���, ǿ������ת����
		
		//========================================
		float f2 = Long.MAX_VALUE;
		System.out.println(Long.MAX_VALUE);
		System.out.println(f2);
		
		double dd = Long.MAX_VALUE;
		System.out.println(dd);
		
		final int age = 90;
//		age ++;  final �ؼ��֣��������γ���������ֻ�ܳ�ʼ��һ�Ρ�
		
	}
}

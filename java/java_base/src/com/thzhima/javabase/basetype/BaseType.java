package com.thzhima.javabase.basetype;

public class BaseType {

	public static void main(String[] args) {
		// boolean����ֵֻ��true\false
		boolean b = true;
		boolean b2;
//		System.out.println(b2);
		
		// �κ����Ͷ�����ת����boolean���͡�
		if(1==1) {
			
		}
		
		// char�������ַ����ͣ���  ������������(  '  )
		char c = '��';
		char c2 = 20013;
		System.out.println(c);
		System.out.println((int)c);
		System.out.println(c2);
		
		// byte�ֽڣ�8λ��  ��bitλ��
		byte by = 127;
		
		// short �����ͣ� 16λ
		short s = -32768;
		
		// int ���ͣ� 32λ
		int i = 2147483647+1;
		System.out.println(i);
		
		// long �����ͣ� 64λ
		long l = Long.MAX_VALUE;
		long l2 = Long.MIN_VALUE;
		
		// float���͡�С����32λ��
		float f = 3.14F;
		
		// double˫����С�����ͣ�64λ��
		double d = 3.14;
		
		
	}
}

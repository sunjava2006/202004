package com.thzhima.javabase.basetype;

public class Array {

	public static void main(String[] args) {
		int a[]; // C 
		int[] b;  // Java
		
		b = new int[3]; // new �Ǵ�������[ ]��ָ������ĳ��ȡ���ȱʡ��ʼ������Ԫ�ء���ֵ���Ͷ���ʼ��Ϊ0.
		
		for(int i : b) {
			System.out.println(i);
		}
		
		boolean[] barray = new boolean[3]; // boolean�������飬ÿ��Ԫ��ȱʡ��ʼ��Ϊfalse��
		for(boolean i : barray) {
			System.out.println(i);
		}
		
		char[] carray = new char[3]; // char�������飬ÿ��Ԫ��ȱʡ��ʼ��Ϊ0������ַ���
		for(char i : carray) {
			System.out.println((int)i);
		}
		
		String[] sarray = new String[3]; // �������͵����飬ÿ��Ԫ��ȱʡ��ʼ��Ϊnull��
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

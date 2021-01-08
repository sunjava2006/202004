package com.thzhima.javabase.basetype;

import java.util.Arrays;

/**
 * @author wangrui
 *
 */
public class Array2 {

	public static void main(String[] args) {
		int[] a = new int[] {10, 20, 30};
		int[] b = {10,20,30}; // ֻ��������ʱ����ʼ����
		
		int[] c;
		c = new int[] {10, 20, 30};
		
		/* ������a�е�Ԫ�أ�ȫ���Ϊ1.
		Arrays.fill(a, 1);*/
		for(int i : a) {
			System.out.println(i);
		}
		
		/**
		 * Arrays���鹤���࣬�ṩ��copy��Ӧ�ķ�����
		 */
		c = Arrays.copyOf(a, a.length);
		System.out.println(Arrays.toString(c));
		
		c = Arrays.copyOfRange(a, 1, 3);
		System.out.println(Arrays.toString(c));
		
		int[] d = new int[10];
		
		/**
		 * System���ṩ�ķ�����
		 */
		System.arraycopy(a, 1, d, 2, 2);
		System.out.println(Arrays.toString(d));
		
		/**
		 * Object�ж����clone������
		 */
		int[] e = d.clone();
		
		
		
	}
}

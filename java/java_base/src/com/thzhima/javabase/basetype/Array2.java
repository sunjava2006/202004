package com.thzhima.javabase.basetype;

import java.util.Arrays;

/**
 * @author wangrui
 *
 */
public class Array2 {

	public static void main(String[] args) {
		int[] a = new int[] {10, 20, 30};
		int[] b = {10,20,30}; // 只能在申明时，初始化。
		
		int[] c;
		c = new int[] {10, 20, 30};
		
		/* 将数组a中的元素，全填充为1.
		Arrays.fill(a, 1);*/
		for(int i : a) {
			System.out.println(i);
		}
		
		/**
		 * Arrays数组工具类，提供了copy相应的方法。
		 */
		c = Arrays.copyOf(a, a.length);
		System.out.println(Arrays.toString(c));
		
		c = Arrays.copyOfRange(a, 1, 3);
		System.out.println(Arrays.toString(c));
		
		int[] d = new int[10];
		
		/**
		 * System中提供的方法。
		 */
		System.arraycopy(a, 1, d, 2, 2);
		System.out.println(Arrays.toString(d));
		
		/**
		 * Object中定义的clone方法。
		 */
		int[] e = d.clone();
		
		
		
	}
}

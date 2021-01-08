package com.thzhima.javabase.basetype;

import java.util.Arrays;

public class Array3 {
	public static void main(String[] args) {
		int[] a = {10, 20, 30};
		int[] a2 = a;
		System.out.println(a == a2);
		System.out.println(a);
		System.out.println(a2);
		int[] b = Arrays.copyOf(a, a.length);
		System.out.println(b);
		
		b[0] = 5;
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(a));
		
		//==================================
		People[] ps = {new People("Li", 3), new People("Zhang", 2), new People("Wang", 1)};
		People[] p2 = ps.clone();//Arrays.copyOf(ps, ps.length);
		
		ps[0] = new People("Huang", 4);
		ps[1].age = 10;
		
		System.out.println(Arrays.toString(ps));
		System.out.println(Arrays.toString(p2));
		
	}
}

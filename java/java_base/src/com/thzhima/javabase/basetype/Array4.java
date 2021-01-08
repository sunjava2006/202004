package com.thzhima.javabase.basetype;

import java.util.Arrays;

public class Array4 {

	public static void main(String[] args) {
		int[][] a = new int[3][2];
		
		for(int[] i: a) {
			System.out.println(Arrays.toString(i));
		}
		
		a[0][0] = 1;
		a[1][1] = 10;
		a[2][0] = 20;
		a[2][1] = 20;
		for(int[] i: a) {
			System.out.println(Arrays.toString(i));
		}
		
		int[][] b = new int[3][];
		b[0] = new int[]{10};
		b[1] = new int[] {20, 30};
		b[2] = new int[] {40, 50, 60};
		for(int[] i: b) {
			System.out.println(Arrays.toString(i));
		}
		
		int[][] c = {{10},{20, 30},{40, 50, 60}};
		
		int[][][][] d = new int[2][][][];
	}
	
}

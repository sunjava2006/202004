package com.thzhima.javabase.basetype;

public class Nine9 {

	public static void main(String[] args) {
		
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=i; j++) {
				
				System.out.print(j + "*" + i + "=" + j*i + "  ");
			}
			System.out.println();
		}
		
		int[] a = {10, 20, 30};
		
		// JavaÖÐfor...eachµÄÐ´·¨¡£
		for(int i : a) {
			System.out.println(i);
		}
		
		
	}
}

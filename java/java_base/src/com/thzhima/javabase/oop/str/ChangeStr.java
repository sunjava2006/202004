package com.thzhima.javabase.oop.str;

public class ChangeStr {

	public static void main(String[] args) {
		int count = 100000;
		
		String s = "";
//		StringBuffer sb = new StringBuffer();
		StringBuilder sb = new StringBuilder();
		
		long start = System.currentTimeMillis();
		
		for(int i=0;i<count;i++) {
			s += i;
		}
		
		long end = System.currentTimeMillis();
		System.out.println("用时："+ (end-start));
		
		
		
		start = System.currentTimeMillis();
		for(int i=0;i<count;i++) {
			sb.append(i);
		}
		end = System.currentTimeMillis();
		System.out.println("用时："+ (end-start));
	}
}

package com.thzhima.javabase.oop.str;

public class StrBuilderBuffer {

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer("i like java.");
		
		System.out.println(sb.capacity());
		
		sb.ensureCapacity(60);
		System.out.println(sb.capacity());
		
		sb.trimToSize();
		System.out.println(sb.capacity());
		
		sb.append(50);
		sb.append("hi");
		System.out.println(sb);
		
		sb.insert(0, 'C');
		System.out.println(sb);
		sb.replace(12, 17, "**");
		System.out.println(sb);
		sb.delete(12, 14);
		System.out.println(sb);
		sb.setCharAt(2, '_');
		System.out.println(sb);
		
		
	}
}

package com.thzhima.javabase.oop.str;

public class Demo {
	
	public static void main(String[] args) {
		String s = "china";
		
		System.out.println(s.replaceAll("in", "IN"));
		
		System.out.println(s);
		
		
		String ss = new String("china");
		System.out.println(ss == s);
		
		// ������, �������洢�ڳ������У�Java�����Ϊ�˽�Լ�ռ䣬���������������ֵͬ����ָ��ͬһ���󣬶��������¶���
		Character c = 'c'; 
		Character c2 = 'c';
		Character c3 = new Character('c'); // new��ȷָ���ڶ��д���һ���¶���
			
		System.out.println("c == c2 : " + (c == c2));  // true
		System.out.println("c == c3 : " + (c == c3));  // false
	}
}

package com.thzhima.javabase.oop.str;

public class Demo {
	
	public static void main(String[] args) {
		String s = "china";
		
		System.out.println(s.replaceAll("in", "IN"));
		
		System.out.println(s);
		
		
		String ss = new String("china");
		System.out.println(ss == s);
		
		// 字面量, 字面量存储在常量池中，Java虚拟机为了节约空间，如果是字面量赋相同值，则指向同一对象，而不创建新对象。
		Character c = 'c'; 
		Character c2 = 'c';
		Character c3 = new Character('c'); // new明确指定在堆中创建一个新对象。
			
		System.out.println("c == c2 : " + (c == c2));  // true
		System.out.println("c == c3 : " + (c == c3));  // false
	}
}

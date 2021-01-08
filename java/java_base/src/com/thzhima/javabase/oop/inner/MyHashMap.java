package com.thzhima.javabase.oop.inner;

import java.util.Map;

public class MyHashMap {

	int a = 0;
	private static int b = 1;
	
	
	
	static class MyEntry{
//		int c = a;
		int d = b;
		static int e = b;
		
		void cc() {
//			System.out.println(a);
			System.out.println(b);
		}
	}
	
	
//	int f = MyEntry.this.d;
	int g = MyEntry.e;
}

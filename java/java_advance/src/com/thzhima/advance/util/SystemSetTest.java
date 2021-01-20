package com.thzhima.advance.util;

import java.util.HashSet;
import java.util.Set;

public class SystemSetTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		Set<String> set2 = new HashSet<>();
		
		
		set.add("java");
		
		
		set2.add("java");
		set2.add("js");
		set2.add("py");
		
		System.out.println(set.addAll(set2));
		System.out.println(set);
		
		
		System.out.println(set2.add("jsp"));
		
		set2.add(null);
		
		System.out.println(set2.contains(null));
		
		
		
		
		
		
	}
}

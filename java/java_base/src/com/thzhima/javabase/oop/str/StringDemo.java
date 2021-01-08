package com.thzhima.javabase.oop.str;

import java.io.UnsupportedEncodingException;

public class StringDemo {

	public static void main(String[] args) {
		
		
		
		try {
			String s = "i like java, 我也喜欢吃。";
			
			char[] values = s.toCharArray();
			values[0] = 'I';
			
			String s2 = String.valueOf(values);
			System.out.println(s2);
			
			byte[] data = s2.getBytes("utf-8");
			System.out.println(new String(data, "utf-8"));
			System.out.println(new String(data));
			
			System.out.println((int)s.charAt(0)); // 取字符串中指定位置的字符。
			System.out.println(s.codePointAt(0)); // 取字符串中指定位置字符的编码。
			
			System.out.println(s.replaceAll("\\b", "*"));
			System.out.println(s.matches("^.+\\.$"));
			System.out.println(s.toLowerCase());
			System.out.println(s.toUpperCase());
			System.out.println(s.indexOf("like"));
			System.out.println(s.contains("java2"));
			System.out.println(s.equals("I like java, 我也喜欢吃。"));
			System.out.println(s.equalsIgnoreCase("I Like Java, 我也喜欢吃。"));
		
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		
	}
}

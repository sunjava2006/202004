package com.thzhima.javabase.basetype;

public class SwitchTest {

	public static void main(String[] args) {
		
		Season s = Season.AUTTOM;
		
		switch (s) {
		case SPRING:
			System.out.println(Season.SPRING);
			break;
		case SUMMER:
			System.out.println(Season.SUMMER);
			break;
        case AUTTOM:
        	System.out.println(Season.AUTTOM);
        	 break;
        case WINTER:
        	System.out.println(Season.WINTER);
	         break;
		default:
			break;
		}
		
		
		
		switch ((int)(Math.random()*10)+"") {
		case "0":
			System.out.println("zero");
			break;
		case "1":
			System.out.println("one");
			break;
		default:
			System.out.println("´óÓÚ1");
			break;
		}
		
	}
}

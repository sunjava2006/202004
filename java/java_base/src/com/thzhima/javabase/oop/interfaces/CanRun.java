package com.thzhima.javabase.oop.interfaces;

public interface CanRun {

	void run();
	
	public default void todo() {
		System.out.println("hello");
	}
	
	
	public static void todo3() {
		System.out.println("hello");
	}
}

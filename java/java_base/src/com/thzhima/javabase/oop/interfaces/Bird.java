package com.thzhima.javabase.oop.interfaces;

public class Bird implements Flyable{

	@Override
	public void fly() {
		System.out.println("С��ɷ� ����������������");
	}
	
	public void sleep() {
		System.out.println("sleep..........");
	}

}

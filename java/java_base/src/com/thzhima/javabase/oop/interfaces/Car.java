package com.thzhima.javabase.oop.interfaces;

public class Car extends Loader{

	@Override
	public void load() {
		System.out.println("��װ�ػ���");
	}

	
	public static void main(String[] args) {
		Car car = new Car();
		Loader l = car;
		Loadable lb = car;
		
		lb.load();
		System.out.println(lb.MIN_LOAD);
	}
}

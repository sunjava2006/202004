package com.thzhima.javabase.oop.abs;

public class TV extends AbsTV{
	
	public TV() {
		
	}
	
	public TV(String brand, int size) {
		super(brand, size);
	}

	@Override
	public	void watch() {
		System.out.println(" ��ʾ�������� ");
	}

	public static void main(String[] args) {
		AbsTV tv = new TV("mi", 65);
		
		tv.open();
		tv.watch();
	}
}

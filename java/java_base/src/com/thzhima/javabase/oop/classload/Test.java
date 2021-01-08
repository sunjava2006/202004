package com.thzhima.javabase.oop.classload;

public class Test {

	
	static {
		System.out.println("---------static Test-----------");
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		for(int i=0;i<10;i++) {
			B b = new B();
		}
		
		

	}
}

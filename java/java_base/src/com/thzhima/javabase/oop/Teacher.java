package com.thzhima.javabase.oop;

public class Teacher extends Human {

	@Override
	public void sleep() {
		System.out.println(this.name+" sleeping................");
	}
	
	
	public static void main(String[] args) {
		Human h = null;
		
		if((int)(Math.random()*10)%2==0) {
			h = new Student("Xie", "��", 22, "���", "Ī˹�ƴ�ѧ","1234567890");
		}else {
//			h = new Teacher();
			h = new Human();
		}
		
		h.sleep();
	}
}

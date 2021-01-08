package com.thzhima.javabase.basetype;

public class People {
	public String name;
	public int age;
	
	public People(String name, int age){
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + "]";
	}
	
}

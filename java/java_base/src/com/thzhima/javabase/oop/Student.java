package com.thzhima.javabase.oop;

public class Student extends Human{
	
	String schoolName;
	String studentID;
	
	Student(){
		super();
	}
	
	{
	    System.out.println();	
	}
	
	Student(String name, String gender, int age, String nation, String schoolName, String studentID){
//		super(gender, name, nation);
//		super();
		this.gender = gender;
		this.name = name;
		this.nation = nation;
		this.age = age;
		this.schoolName = schoolName;
		this.studentID = studentID;
	}
	
	
	public void study() {
		System.out.println(this.name + " 正在学习 。");
	}
	
	
	
	public void add(int a, int b) {
//		this.calculate(a, b);
		super.calculate(a, b);
	}
	
	@Override
	public void sleep() {
		System.out.println(this.name+"站着睡");
		super.sleep();
//		return 0;
	}
	
	
	@Override
	public String toString() {
		return "Student [schoolName=" + schoolName + ", studentID=" + studentID + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + ", nation=" + nation + "]";
	}

	public void print() {
		this.about();
	}

//	@Override
	public void talks() {
		System.out.println("-----------------------");
	}

	public static void main(String[] args) {
//		Student s = new Student("Xie", "男", 22, "俄国", "莫斯科大学","1234567890");
//		System.out.println(s);
//		s.sleep();
//		System.out.println();
//		s.about();
//		s.print();
		
		Human h = new Student("Xie", "男", 22, "俄国", "莫斯科大学","1234567890");
		System.out.println(h.nation);
		
		h.sleep();
		
		Student s = (Student) h;
		s.study();
		
		s.talks();
		
		
		
	}
	
}

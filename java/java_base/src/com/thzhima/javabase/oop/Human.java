package com.thzhima.javabase.oop;

// class 用来定义类。Human类型定义。
public class Human {

	// 定义Human类型的属性
	String name; 
	int age = 1;
	String gender;
	String nation = "中国";
	private int nomey = 10; // 这个成员只有自己可以用（可以取值，赋值，调用），
	
	
	private void talks() {
		System.out.println("=========================");
	}
	
	public void about(){
		System.out.println(this.nomey);
	}
	

	{
		System.out.println("-----------代码块-----------");
		this.name = "Wang";
	}
	
	// 无参，也什么都不做的构造函数。缺省构造。只有当我们什么构造都没有显示定义的情况下，就编译器提供了。
	Human(){
		System.out.println("---------------Human()-------------");
	}
	
	Human(String gender,String name, String nation){
		System.out.println("---------------有参构造中---------------");
		this.gender = gender;
		this.name = name;
		this.nation = nation;
	}
	
	Human(String gender,String name){
		this(gender, name, "中国");
		System.out.println("---------------有参构造中---------------");
	}

	
	// 方法  修饰符 返回类型 方法名(参数列表)
	void run() {
		
		System.out.println(this.name + "running.");
	}
	// 方法重载
	void run(int round) {
		for(int i=0; i<round; i++) {
			System.out.println(this.name +" running" + (i+1));
		}
	}
	
    Object run2() {
		
		System.out.println(this.name + "running.");
		return new Object();
	}
	
	
	
	void sleep() {
		System.out.println(this.name + "睡觉中.");
	}
	
	int calculate(int a, int b) {
		return a+b;
	}
	

	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + ", gender=" + gender + ", nation=" + nation + "]";
	}
	

}

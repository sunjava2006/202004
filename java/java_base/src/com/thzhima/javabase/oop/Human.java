package com.thzhima.javabase.oop;

// class ���������ࡣHuman���Ͷ��塣
public class Human {

	// ����Human���͵�����
	String name; 
	int age = 1;
	String gender;
	String nation = "�й�";
	private int nomey = 10; // �����Աֻ���Լ������ã�����ȡֵ����ֵ�����ã���
	
	
	private void talks() {
		System.out.println("=========================");
	}
	
	public void about(){
		System.out.println(this.nomey);
	}
	

	{
		System.out.println("-----------�����-----------");
		this.name = "Wang";
	}
	
	// �޲Σ�Ҳʲô�������Ĺ��캯����ȱʡ���졣ֻ�е�����ʲô���춼û����ʾ���������£��ͱ������ṩ�ˡ�
	Human(){
		System.out.println("---------------Human()-------------");
	}
	
	Human(String gender,String name, String nation){
		System.out.println("---------------�вι�����---------------");
		this.gender = gender;
		this.name = name;
		this.nation = nation;
	}
	
	Human(String gender,String name){
		this(gender, name, "�й�");
		System.out.println("---------------�вι�����---------------");
	}

	
	// ����  ���η� �������� ������(�����б�)
	void run() {
		
		System.out.println(this.name + "running.");
	}
	// ��������
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
		System.out.println(this.name + "˯����.");
	}
	
	int calculate(int a, int b) {
		return a+b;
	}
	

	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + ", gender=" + gender + ", nation=" + nation + "]";
	}
	

}

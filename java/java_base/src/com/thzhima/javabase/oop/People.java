package com.thzhima.javabase.oop;

public final  class People {
	public static final String ORIGIN ; //= "EARTH"; // ������ʼ��
	
	Integer i;

	public final String gender ;
	
	{
//		this.gender = ""; //�����Ҳ���Գ�ʼ������
	}
	
	static {
		ORIGIN = "Duno"; // ��ʼ����̬����
	}
	
	public People(String gender) {
		this.gender = gender;   // �����ʼ������
	}
	
	public final void sleep() { // ���ܱ���д
		System.out.println("sleep.............");
	}
}


//class Worker extends People{
//
//	public Worker(String gender) {
//		super(gender);
//	}
//	
////	public final void sleep() {
////		System.out.println("sleep.............");
////	}
//	
//}
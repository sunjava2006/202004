package com.thzhima.javabase.oop;

public class A {

	String  name = "A";  //  ʵ������
	static public String country = "�й�"; // �����Ϸ���洢�ռ䲢��ֵ����̬����
	
	String myCountry =  country;
//	static String myName = name;
	
	
	static void about() {
		System.out.println(A.country);
		A a = new A();
		System.out.println(a.name);
	}
	
	
	static {
		System.out.println(); // �������ʱ���С���ֻ����1�Ρ���̬��Ҳִֻ��һ�Ρ���ʼ����̬���ݡ�
	}
	
	{
		System.out.println();
	}
	
	public static void main(String[] args) {
//		A a = new A();
//		A b = new A();
//		
//		A.country = "China";
//		System.out.println(A.country);  // ��Ϊ��̬��Ա��������ģ� ����ֱ��ͨ�����������ʡ�
//		
//		System.out.println(a.country);
//		System.out.println(b.country);
	}
	
}

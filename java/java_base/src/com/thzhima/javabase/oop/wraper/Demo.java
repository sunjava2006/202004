package com.thzhima.javabase.oop.wraper;

public class Demo {

	public static void main(String[] args) {
		
//		Boolean b = new Boolean(false);
//		
//		Boolean b2 = new Boolean("TRUE");
//		
//		
//		
//		Boolean b3 = true;
//		Integer i = new Integer(90);//90;
//		
//		Long l = 90L;
//		Double d = 90D;
//		Character c = 'c';  // װ��
//		
//		int ii = i.intValue();//i;
//		long ll = l.longValue();
//		double dd = d;  // ����
		
		
		Short s = new Short((short)30);
		Short s2 = s;  // s��s2 ����ͬһ������
		System.out.println(s == s2);
		
		s = new Short("80"); // 
		System.out.println(s == s2);
		System.out.println(s);
		System.out.println(s2);
	}
	
	
	
}

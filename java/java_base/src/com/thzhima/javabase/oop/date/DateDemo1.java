package com.thzhima.javabase.oop.date;

import java.util.Calendar;
import java.util.Date;

public class DateDemo1 {
	
	public static void main(String[] args) {
		
		Date now = new Date(-System.currentTimeMillis());
		System.out.println(now);
		
		
		Date birthDate = new Date(95, 2, 3);
		System.out.println(birthDate);
		
		//=================================================
		
		Calendar c = Calendar.getInstance();
		
		
//		c.set(1995, 1, 3);
		
//		c.set(Calendar.YEAR, 2009);// �����������ڵ�ĳһ�����֡�
		
		Date date = c.getTime(); //  ��Calendar��ȡDate����
		
		System.out.println(date);
		
		System.out.println(c.get(Calendar.HOUR)); // ������ȡ���ڵ�ָ�����֡�
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		System.out.println(c.get(Calendar.YEAR));
		
	}
	
}

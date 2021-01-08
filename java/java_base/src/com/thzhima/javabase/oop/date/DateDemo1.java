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
		
//		c.set(Calendar.YEAR, 2009);// 单独设置日期的某一个部分。
		
		Date date = c.getTime(); //  从Calendar获取Date对象
		
		System.out.println(date);
		
		System.out.println(c.get(Calendar.HOUR)); // 单独获取日期的指定部分。
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		System.out.println(c.get(Calendar.YEAR));
		
	}
	
}

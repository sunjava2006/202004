package com.thzhima.javabase.oop.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatDemo {

	public static void main(String[] args) throws ParseException {
		
		Date now = new Date();
		
//		DateFormat fmt = DateFormat.getInstance(); // 21-1-7 ����11:36
//		DateFormat fmt = DateFormat.getDateInstance(); //2021-1-7
//		DateFormat fmt = DateFormat.getDateInstance(DateFormat.SHORT);
		DateFormat fmt = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		
		String dateStr = fmt.format(now);
		System.out.println(dateStr);
		
		Date dd = fmt.parse("2021��1��7�� ����11ʱ50��14��");
		System.out.println(dd);
		
		// =========================================================
		SimpleDateFormat sfmt = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
		
		dateStr = sfmt.format(now);
		
		System.out.println(dateStr);
		
		Date d = sfmt.parse("2021-01-07 ���� 11:48:02");
		System.out.println(d);
		
	}
	
}

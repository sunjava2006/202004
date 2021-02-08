package com.thzhima.springlearning.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		
		Home h = (Home) app.getBean("home"); // 向Spring容器“要”对象。
		
		h.watchTV();
		
		
		
	}
}

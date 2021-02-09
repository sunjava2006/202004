package com.thzhima.springlearning.annotationioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class HomeTest extends TestCase {
	
	ClassPathXmlApplicationContext app;
	Home home;
	
	public HomeTest() {
		app = new ClassPathXmlApplicationContext("app2.xml");
		home = app.getBean(Home.class);
	}

	public void testGetCar() {
		Car car = home.getCar();
		System.out.println(car);
		assertNotNull(car);
	}

}

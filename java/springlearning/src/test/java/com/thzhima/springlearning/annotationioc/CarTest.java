package com.thzhima.springlearning.annotationioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class CarTest extends TestCase {

	ClassPathXmlApplicationContext app;
	Car car;
	
	public CarTest() {
		app = new ClassPathXmlApplicationContext("app2.xml");
//		this.car = app.getBean(Car.class);
		this.car = (Car) app.getBean("car");
		
	}

	public void testGetBean() {
		System.out.println(this.car.getBrand());
		
		assertNotNull(car);
	}
	
	public void testSingleton() {
		Car c = (Car) app.getBean("car2");
		System.out.println(c == car);
		assertNotSame(c, this.car);
	}
	
}

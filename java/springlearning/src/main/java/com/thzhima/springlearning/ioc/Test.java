package com.thzhima.springlearning.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		
//		Home h = (Home) app.getBean("home"); // 向Spring容器“要”对象。
//		
//		h.watchTV();
		
//		Home2 h = app.getBean(Home2.class);
//		h.watchTV();
//		
//		System.out.println(h.getClass().getName());
//		
//		h.createTV().play();
		
//		Home3 h = app.getBean(Home3.class);
//		h.makeTV("海信");
//		h.watchTV();
		
//		CarFactory f = new CarFactory(); // 实例工厂
//		Car car = f.createCar();
		
//		Car c = Factory.createCar(); // 静态工厂。
		
		Car car = app.getBean(Car.class);
		car.run();
	}
}

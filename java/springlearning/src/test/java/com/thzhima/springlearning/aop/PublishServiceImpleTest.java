package com.thzhima.springlearning.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class PublishServiceImpleTest extends TestCase {
	
	PublishService ps;
	
	public PublishServiceImpleTest(){
		System.out.println("========================");
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app3.xml");
		ps = (PublishService) app.getBean("publish");
	}
	

	public void testPublish() {
		System.out.println("------------------------");
		ps.publish("Java 编程思想");
	    assertNull(null);
		
	}
	
	
	

}

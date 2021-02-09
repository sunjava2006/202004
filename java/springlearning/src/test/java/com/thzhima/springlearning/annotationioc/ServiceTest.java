package com.thzhima.springlearning.annotationioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class ServiceTest extends TestCase {

	public void testCreate() {
		ClassPathXmlApplicationContext app  = new ClassPathXmlApplicationContext("app2.xml");
		Service s = app.getBean(Service.class);
		
		s.service();
		
		assertNotNull(s);
		
		app.destroy();
	}
	
	
	
}

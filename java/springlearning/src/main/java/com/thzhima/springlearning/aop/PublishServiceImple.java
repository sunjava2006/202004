package com.thzhima.springlearning.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class PublishServiceImple implements PublishService{
	
	public void publish(String article) {
		System.out.println("发表文章" + article);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app4.xml");
		PublishService ps = app.getBean(PublishService.class);
		
		ps.publish("c++");
	}
}

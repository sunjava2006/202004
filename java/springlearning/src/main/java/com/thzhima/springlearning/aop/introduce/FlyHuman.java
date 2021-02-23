package com.thzhima.springlearning.aop.introduce;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class FlyHuman {

	@DeclareParents(defaultImpl = Bird.class, 
			        value = "com.thzhima.springlearning.aop.introduce.Human")
	Flyable flyman;
	
	
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app4.xml");
		
		Flyable fly = (Flyable) app.getBean("human");
		
		
		fly.fly();
		
		Human man = (Human) fly;
		man.work();
	}
}

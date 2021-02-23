package com.thzhima.springlearning.aop.introduce;

import org.springframework.stereotype.Component;

@Component
public class Bird implements Flyable{

	@Override
	public void fly() {
		System.out.println("-------------fly------------");
	}

}

package com.thzhima.springlearning.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestTime {

	long s;
	
	@Before("execution(* com.thzhima.springlearning.aop.PublishServiceImple.publish(..))")
	public void start() {
		s = System.currentTimeMillis();
	}
	@After("execution(* com.thzhima.springlearning.aop.PublishServiceImple.publish(..))")
	public void end() {
		long e = System.currentTimeMillis();
		System.out.println("用时："+ (e-s));
	}
	
	@Before("execution(* com.thzhima.springlearning.aop.PublishServiceImple.publish(..))")
	public void log() {
		System.out.println("===================log======================");
	}
	
}

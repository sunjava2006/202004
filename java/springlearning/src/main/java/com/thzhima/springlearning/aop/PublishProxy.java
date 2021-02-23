package com.thzhima.springlearning.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PublishProxy implements InvocationHandler{

	PublishService ps;
	TestTime test;
	public PublishProxy(PublishService ps, TestTime test) {
		this.ps = ps;
		this.test = test;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		test.start();

		if(method.getName().equals("publish")) {
			ps.publish((String)args[0]);
		}
		test.end();
		return null;
	}
	
	public static void main(String[] args) {
		
		System.out.println("========================");
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app3.xml");
		PublishService ps = (PublishService) app.getBean("publish");
		
		
		
//		PublishServiceImple ps = new PublishServiceImple();
//		TestTime test = new TestTime();
//		
//		PublishService o = (PublishService) Proxy.newProxyInstance(PublishService.class.getClassLoader(), PublishServiceImple.class.getInterfaces(), new PublishProxy(ps, test));
//		
		ps.publish("aop编程");
		
	
	}

}

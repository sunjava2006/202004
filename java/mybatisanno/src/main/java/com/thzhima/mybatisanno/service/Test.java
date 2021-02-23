package com.thzhima.mybatisanno.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Test {

	@Around("@annotation(com.thzhima.mybatisanno.dao.Transaction)")
	public void testTime(ProceedingJoinPoint pjp) throws Throwable {
		
		long s = System.currentTimeMillis();
		
		pjp.proceed();
		
		long e = System.currentTimeMillis();
		
		System.out.println(" 用时" + (e-s));
		
	}
}

package com.thzhima.mybatisanno.dao;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransactionManage {
	boolean error;

//	@After("execution(* com.thzhima.mybatisanno.service.*.*(..))")
	@After("@annotation(com.thzhima.mybatisanno.dao.Transaction)")
	public void commit() {
		if(!error) {
			System.out.println("正常提交");
			SessionUtil.getSession().commit();
		}
		
		
	}
	
//	@AfterReturning("execution(* com.thzhima.mybatisanno.service.*.*(..))")
	@AfterReturning("@annotation(com.thzhima.mybatisanno.dao.Transaction)")
	public void close() {
		SessionUtil.close();
	}
	
//	@AfterThrowing("execution(* com.thzhima.mybatisanno.service.*.*(..))")
	@AfterThrowing("@annotation(com.thzhima.mybatisanno.dao.Transaction)")
	public void rollback() {
		System.out.println("异常处理.....................");
		error = true;
		SessionUtil.getSession().rollback();
	}
}

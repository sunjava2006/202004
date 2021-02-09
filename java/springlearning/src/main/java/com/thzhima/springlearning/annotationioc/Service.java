package com.thzhima.springlearning.annotationioc;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Service {

	@PostConstruct
	public void init() {
		System.out.println("------------- 初始化 -------------");
	}
	
	
	public void service() {
		System.out.println("================服务中===============");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("---------------- 资源回收 ----------------");
	}
}

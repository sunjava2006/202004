package com.thzhima.springlearning.ioc;

public abstract class Home2 {

	private TV tv ;
	
	public abstract TV createTV();
	
	public void watchTV() {
		tv = createTV();
		tv.play();
	}
	
}

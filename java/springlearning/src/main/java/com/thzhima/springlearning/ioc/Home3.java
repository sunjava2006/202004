package com.thzhima.springlearning.ioc;

public abstract class Home3 {

	private TV tv;
	
	abstract void makeTV(String brand);
	
	public void watchTV() {
		this.tv.play();
	}

	public TV getTv() {
		return tv;
	}

	public void setTv(TV tv) {
		this.tv = tv;
	}
	
	
}

package com.thzhima.springlearning.ioc;

public class TV {

	private String brand;
	
	public TV(String brand) {
	    this.brand = brand;	
	}
	
	public TV() {
		
	}
	
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
	void play() {
		System.out.println(this.brand + "电视播放中 。。。。。。。。。。。。。。。。。");
	}
}

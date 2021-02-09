package com.thzhima.springlearning.ioc;

public class Factory {

	public static Car createCar() { // 静态工厂
		return new Car() {};
	}
}

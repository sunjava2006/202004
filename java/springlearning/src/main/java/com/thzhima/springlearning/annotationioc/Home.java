package com.thzhima.springlearning.annotationioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Home {
	
	public Home(Car car) {
		this.car = car;
	}

	public Home() {
		
	}

	private Car car;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	
}

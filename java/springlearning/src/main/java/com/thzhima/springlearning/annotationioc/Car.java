package com.thzhima.springlearning.annotationioc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("car")

//@Scope("singleton")
public class Car {

	@Value(value = "中华")
	private String brand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + "]";
	}
	
	
}

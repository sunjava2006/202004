package com.thzhima.javabase.oop.interfaces;

public interface Flyable {

	public static final int LOADING = 50; // 只能申明初始化,是常量。默认就是public static final不能修改。	
	
	
	public abstract void fly();  // 接口中只能定义抽象方法。接口方法,默认就是public abstract不能修改。
	
}

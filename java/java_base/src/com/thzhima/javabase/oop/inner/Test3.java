package com.thzhima.javabase.oop.inner;

import com.thzhima.javabase.oop.abs.*;

public class Test3 {

	AbsTV tv = new AbsTV() { // 匿名类用法，直接创建该类的子类对象。适用于只创建一个这样的对象。

		@Override
		public void watch() {
			System.out.println("-----------------------");
		}
	};
	
	AbsTV tv2 = new AbsTV() { // 匿名类用法，直接创建该类的子类对象。适用于只创建一个这样的对象。

		@Override
		public void watch() {
			System.out.println("-----------------------");
		}
	};

}

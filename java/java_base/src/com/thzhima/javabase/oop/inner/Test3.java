package com.thzhima.javabase.oop.inner;

import com.thzhima.javabase.oop.abs.*;

public class Test3 {

	AbsTV tv = new AbsTV() { // �������÷���ֱ�Ӵ���������������������ֻ����һ�������Ķ���

		@Override
		public void watch() {
			System.out.println("-----------------------");
		}
	};
	
	AbsTV tv2 = new AbsTV() { // �������÷���ֱ�Ӵ���������������������ֻ����һ�������Ķ���

		@Override
		public void watch() {
			System.out.println("-----------------------");
		}
	};

}

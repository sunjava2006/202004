package com.thzhima.advance.thread;

public class MainThread {

	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println(t.getId());
		System.out.println(t.getName());
		
		
		Thread t2 = new Thread("打印线程") {
			@Override
			public void run() {
				long id = Thread.currentThread().getId();
				String name = Thread.currentThread().getName();
				
				System.out.println(id + ":" + name);
			}
		};
		
		
		
		Thread t3 = new Thread("进度条输出线程") {   //  编写Thread子类，覆盖run方法。这个线程的线程体（工作内容）是固定的。
			@Override
			public void run() {
				long id = Thread.currentThread().getId();
				String name = Thread.currentThread().getName();
				
				System.out.println(id + ":" + name);
			}
		};
		
		
		
		
		Runnable r1 = new Runnable() { // 线程体接口

			@Override
			public void run() {
				System.out.println("hello----------------------------");
			}
			
		};
		
		Thread t4 = new Thread(r1);  // 传入一个Runnable对象。线程与线程体相分离的。
		
		
//		t2.start();
//		t3.start();
		
		t2.run();
		t3.run();
		t4.start();
		
	}
}

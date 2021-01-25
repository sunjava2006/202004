package com.thzhima.advance.thread;

public class SleepTest {

	public static void main(String[] args) throws InterruptedException {

		Thread main = Thread.currentThread();

		Thread t2 = new Thread(() -> {

			try {
				System.out.println("-----------start------------");
				Thread.currentThread().interrupt();
				Thread.sleep(10000);
				System.out.println("============end=============");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		});

		Thread t = new Thread(() -> {
			try {
//				Thread.sleep(1000);
				System.out.println("我将要打断主线程的休眠。");
				t2.interrupt();
				System.out.println("after interrupt....");
			} catch (Exception e) {
				e.printStackTrace();
			}

		});

//		t.start();
	
		t2.start();

	}
}

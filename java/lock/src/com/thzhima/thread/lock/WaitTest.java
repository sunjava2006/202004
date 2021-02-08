package com.thzhima.thread.lock;

public class WaitTest {

	public static void main(String[] args) {
		
		System.out.println("--------------------------");
		
		Object o = new Object();
		
		Thread t = new Thread(()->{
			synchronized (o) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("��Ҫ֪ͨ�ȴ�o���߳�");
				o.notifyAll();
			}
		});
		t.start();
		
		
		try {
			synchronized (o) {
				System.out.println("will wait o ");
				o.wait();
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("===========================");
	}
}

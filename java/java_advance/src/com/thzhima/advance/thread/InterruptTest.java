package com.thzhima.advance.thread;

public class InterruptTest {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(()->{
			while(true) {
//				Thread  my = Thread.currentThread();
//				boolean isInterupt = my.isInterrupted(); // ������ж�״̬���
				
				boolean isInterupt = Thread.interrupted(); // ����ж�״̬���
				
				if(isInterupt) {
					System.out.println(Thread.interrupted());
					break;
				}
				System.out.println("-----------------------------");
			}
		});
		
		t.start();
		
		
		Thread.sleep(2000);
		
		t.interrupt();
	}

}

package com.thzhima.advance.thread;

public class InterruptTest {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(()->{
			while(true) {
//				Thread  my = Thread.currentThread();
//				boolean isInterupt = my.isInterrupted(); // 不清除中断状态标记
				
				boolean isInterupt = Thread.interrupted(); // 清除中断状态标记
				
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

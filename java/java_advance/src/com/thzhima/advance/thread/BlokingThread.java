package com.thzhima.advance.thread;

public class BlokingThread {

	int[] array = new int[10];
	int idx = 0;
	Object o = new Object();
	
	public  void add(int i) {
		
		synchronized (o) {
			System.out.println("-----------"+Thread.currentThread().getName());
			if(idx<array.length) {
				array[idx++]  = i;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("==========="+Thread.currentThread().getName());
		}
		
	}
	
	public  void sum() {
		
		synchronized(o) {
			try {
				System.out.println("**************"+Thread.currentThread().getName());
//			        Thread.sleep(10);
			    System.out.println("##############"+Thread.currentThread().getName());
			} catch (Exception e) {
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		BlokingThread bt = new BlokingThread();
		
		
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				for(int i=100;i<110;i++) {

//					bt.add(i);
					bt.sum();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Runnable r1 = ()->{
			for(int i=0;i<10;i++) {

//				bt.add(i);
				bt.sum();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread t = new Thread(r1);
		
		Thread t2 = new Thread(r2);
		
		
		Thread t3 = new Thread(()->{
			while(true) {
				System.out.println("t: " + t.getState());
				System.out.println("t2: " + t2.getState());
				
//				try {
//					Thread.sleep(1);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
		});
		
		t.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
//		t3.setDaemon(true); // 设置为守护线程
//		t3.start();
		t.start();
		t2.start();
		
		
		
		
	}
}

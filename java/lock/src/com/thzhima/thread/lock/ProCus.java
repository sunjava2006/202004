package com.thzhima.thread.lock;

import java.util.ArrayList;
import java.util.List;

public class ProCus {

	public static void main(String[] args) {
		
		List<Integer> store = new ArrayList<>();
		
		Runnable pro = ()->{
			
			try {
				int sn = 1;
				while(true) {
					synchronized (store) {
						
						for(int i=1;i<=10;i++) {
							System.out.println("生产: " + sn);
							
							store.add(sn++);
							Thread.sleep(500);
						}
						store.notifyAll();
						store.wait();
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		};
		
		
		Runnable cus = ()->{
			try {
				synchronized (store) {
					for(;;) {
						for(int i=store.size()-1;i>=0;i--) {
							System.out.println("消费：" + store.remove(i));
							Thread.sleep(500);
						}
						
						store.notifyAll();
						store.wait();
					}
					
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		};
		
		
		
		
		Thread p = new Thread(pro);
		Thread c = new Thread(cus);
		
		p.start();
		c.start();
		
		
	}
	
}

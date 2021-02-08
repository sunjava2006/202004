package com.thzhima.advance.thread;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	ReentrantLock lock = new ReentrantLock();
	
	public void todo() {
		
		try {
			lock.lock();
			lock.lock();
			String name = Thread.currentThread().getName();
			System.out.println("---------------------"+name);
			Thread.sleep(500);
			System.out.println("====================="+name);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			
			lock.unlock();
			lock.unlock();
		}
		
	}
	
	public static void main(String[] args) {
		
		LockTest lt = new LockTest();
		
		
		Runnable run = ()->{
			for(int i=0;i<20;i++) {
				lt.todo();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		};
		
		
		Thread t = new Thread(run);
		Thread t2 = new Thread(run);
		t.start();
		t2.start();
	}
}

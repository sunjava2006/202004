package com.thzhima.advance.thread;

public class MainThread {

	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println(t.getId());
		System.out.println(t.getName());
		
		
		Thread t2 = new Thread("��ӡ�߳�") {
			@Override
			public void run() {
				long id = Thread.currentThread().getId();
				String name = Thread.currentThread().getName();
				
				System.out.println(id + ":" + name);
			}
		};
		
		
		
		Thread t3 = new Thread("����������߳�") {   //  ��дThread���࣬����run����������̵߳��߳��壨�������ݣ��ǹ̶��ġ�
			@Override
			public void run() {
				long id = Thread.currentThread().getId();
				String name = Thread.currentThread().getName();
				
				System.out.println(id + ":" + name);
			}
		};
		
		
		
		
		Runnable r1 = new Runnable() { // �߳���ӿ�

			@Override
			public void run() {
				System.out.println("hello----------------------------");
			}
			
		};
		
		Thread t4 = new Thread(r1);  // ����һ��Runnable�����߳����߳��������ġ�
		
		
//		t2.start();
//		t3.start();
		
		t2.run();
		t3.run();
		t4.start();
		
	}
}

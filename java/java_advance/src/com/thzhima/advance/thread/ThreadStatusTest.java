package com.thzhima.advance.thread;

public class ThreadStatusTest {

	public static void main(String[] args) {
		
		Thread t = new Thread(()->System.out.println(Thread.currentThread().getName()));
		
		System.out.println("t �߳���start֮ǰ��״̬�ǣ� " + t.getState());
		
		t.start();
		System.out.println("t �߳���start֮��״̬�ǣ� " + t.getState());
		System.out.println("t �߳���start֮��״̬�ǣ� " + t.getState());
		System.out.println("t �߳���start֮��״̬�ǣ� " + t.getState());
		System.out.println("t �߳���start֮��״̬�ǣ� " + t.getState());
		System.out.println(t.getState()==Thread.State.RUNNABLE ? "����״̬": "��������״̬");
		System.out.println(t.getState()==Thread.State.TERMINATED ? "�ս�״̬": "�����ս�״̬");

	}

}

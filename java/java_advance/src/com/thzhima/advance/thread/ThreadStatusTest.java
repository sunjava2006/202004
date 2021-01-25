package com.thzhima.advance.thread;

public class ThreadStatusTest {

	public static void main(String[] args) {
		
		Thread t = new Thread(()->System.out.println(Thread.currentThread().getName()));
		
		System.out.println("t 线程在start之前，状态是： " + t.getState());
		
		t.start();
		System.out.println("t 线程在start之后，状态是： " + t.getState());
		System.out.println("t 线程在start之后，状态是： " + t.getState());
		System.out.println("t 线程在start之后，状态是： " + t.getState());
		System.out.println("t 线程在start之后，状态是： " + t.getState());
		System.out.println(t.getState()==Thread.State.RUNNABLE ? "运行状态": "不是运行状态");
		System.out.println(t.getState()==Thread.State.TERMINATED ? "终结状态": "不是终结状态");

	}

}

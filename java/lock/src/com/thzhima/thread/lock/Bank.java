package com.thzhima.thread.lock;

import java.math.BigDecimal;

public class Bank {

	static Object o = new Object();
	
	public synchronized void save(Account account, BigDecimal amount) {
		synchronized(account) {
			BigDecimal newAmount = account.amount.add(amount);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			account.amount = newAmount;
			System.out.format("存入%s, 余额%s。\n",amount.toString(), account.amount.toString() );
		}
		
	}
	
	public  BigDecimal get(Account account, BigDecimal amount) {
		synchronized(account) {
			System.out.println("----------------------------");
			BigDecimal n = null;
			if(account.amount.compareTo(amount)>=0) {
				n = amount;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				account.amount = account.amount.subtract(amount);
			}
			System.out.println("===========================");
			return n;
		}
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		Bank bank = new Bank();
		
		Account account = new Account();
		Account account2 = new Account(10000);
		
		Runnable r = ()->{
			
			bank.save(account, new BigDecimal(2000));
			
		};
		
		Runnable r2 = ()->{
			System.out.println("取出金额：" + bank.get(account, new BigDecimal(1600)));
		};
		
		Runnable r3 = ()->{
			System.out.println("取出金额：" + bank.get(account2, new BigDecimal(6000)));
		};
		
		
		Thread t = new Thread(r);
		t.start();
		
		t.join();
		
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		Thread t4 = new Thread(r2);
		t2.start();
		t3.start();
		t4.start();
	}
	
}


class Account{
	int accountNO;
	
	BigDecimal amount ;
	
	Account(){
		amount = new BigDecimal(0);
	}
	
	Account(int amount){
		this.amount = new BigDecimal(amount);
	}
}
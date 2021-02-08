package com.thzhima.springlearning.ioc;

/**
 * @author wangrui
 *
 */
public class Home {

	private TV tv;
	
	
	/**
	 *  构造注入
	 * @param tv
	 */
	public Home(TV tv) {
		this.tv = tv;
	}
	
	public void watchTV() {
		System.out.println("打开电视");
		this.tv.play();
	}
	
}

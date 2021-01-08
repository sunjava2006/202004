package com.thzhima.javabase.oop.exce;

public class CalculateUtil {
	
	
	public static double chu(double a, double b) throws ParamException{
		double result = 0;
		
		if(b==0) {
			throw new ParamException("除数为0，参数输入错误。");
		}
		
		result = a/b;
		
		return result;
		
	}
	
	public static void main(String[] args) {
		try {
			double result = CalculateUtil.chu(2, 0);
			System.out.println(result);
		} catch (ParamException e) {
			e.printStackTrace();
		}
	}

}

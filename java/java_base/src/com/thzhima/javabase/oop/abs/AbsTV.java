package com.thzhima.javabase.oop.abs;

public abstract class AbsTV {

	String brand;
	int size;
	
	public AbsTV(){
		
	}
	
    public AbsTV(String brand, int size){
		this.brand = brand;
		this.size = size;
	}
    
	public void open() {
		System.out.println("打开电视");
	}
	
	abstract public void watch();
	
//	public static void main(String[] args) {
//		AbsTV tv = new AbsTV() ;
//	}
	
	
}

//public class XXXX{
//	
//}
//
//class BBB{
//	
//}

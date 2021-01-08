package com.thzhima.javabase.oop.inner;

public class Local {
    int aa = 0;
	void a() {
	    int c = 0;
	    {
	    	class B{
			   	int d = c;
			    int e = aa;
			}
			
			B b = new B();
	    }
//	    B b = new B();
	}
	
	
//	B c = new B();
}

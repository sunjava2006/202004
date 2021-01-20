package com.thzhima.advance.ge;

public class Home<T> {

	public T pet ; // = new T();²»ÄÜ new
	
	T[] array ;// = new T[2];
	
	
	
	
	public static void main(String[] args) {
		Home<Dog> home = new Home<Dog>();
		home.pet = new Dog();
		
		Home<Cat> home2 = new Home<Cat>();
		home2.pet = new Cat();
		
		Home<?> home3 =  new Home<>();//= home; // ´íÎó¡£
		
		Home<? extends Pet> h = new Home<>();
		h =  home;
		
		home3 = home;
		
		
		
		Home<? super Dog> h3 = null;
		Home<Pet> h4 = new Home<>();
		h3 = h4;
	}
}

package com.thzhima.springlearning.ioc;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class LibraryTest extends TestCase {

	ClassPathXmlApplicationContext app ;
	Library lib;
	
	public LibraryTest() {
		app = new ClassPathXmlApplicationContext("app.xml");
		lib = app.getBean(Library.class);
	}
	
	
	
	public void testGetName() {
		
		assertEquals(lib.getName(), "南京图书馆");
	}
	
	public void testBuildTime() {
		int time = lib.getBuildTime();
		assertEquals(time, 2010);
	}
	
	public void testMasterName() {
		String name = lib.getMaster();
		assertNull(name, null);
	}
	
	public void testBookNames() {
		Set<String> set = lib.getBookNames();
		Set<String> s = new HashSet<>();
		s.add("java");
		s.add("python");
		s.add("oracle");
		
		assertEquals(set, s);
	}
	
	public void testSingelton() {
		Library lib2 = app.getBean(Library.class);
		System.out.println(lib == lib2);
		assertNotSame(lib, lib2);
	}

}

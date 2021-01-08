package com.thzhima.javabase.oop.exce;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Except {

	public static void main(String[] args) {
//		int len = -3;
//		
//		int[] a = new int[len];
//		
//		System.out.println( 1/ 0 );
		
		
		File file = new File("d://abc.txt");
		try {
			FileInputStream in = new FileInputStream(file);
			Class.forName("xxccx.Aaaa");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (Exception ex) {
			System.out.println("这个文件不存在");
		} finally {
			
		}
		
		
	}
}

package com.thzhima.advance.io.fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class FileUtil {

	/**
	 * 向文件中写入二进制数据。
	 * @param fileName
	 * @param data
	 * @param append
	 * @throws IOException
	 */
	public static void writeFile(String fileName, byte[] data, boolean append) throws IOException {
		
		FileOutputStream out = null;
		
		try {
			out = new FileOutputStream(fileName, append);
			
			// 1、每次写入一个字节
//			for(byte i : data) {
//				out.write(i);
//			}
			
//			写入整个字节数组数据
			out.write(data);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} finally {
			if(null != out) {
				out.close();
			}
		}
		
	}
	
	
	public static byte[] readFile(String fileName) throws IOException {
		byte[] data = null;
		
		FileInputStream in = null;
		try {
			File file = new File(fileName);
			in = new FileInputStream(file);
			System.out.println("文件大小：" + file.length());
			System.out.println("流中文件还有：" + in.available());
			
			// 在文件还没有读取的情况下，获取可读取的数据大小。以此大小来创建数据读入缓冲区。
			data = new byte[in.available()]; 
			
			in.read(data);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} finally {
			if (null != in) {
				in.close();
			}
		}
		
		return data;
	}
	
	public static void writeMsgToFile(String fileName, String msg, boolean append) throws IOException {
		
		FileWriter writer = null;
		try {
			writer = new FileWriter(fileName, append);
			writer.write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if ( null != writer ) {
				writer.close();
			}
		}
		
	}
	
	
	public static String readFileContent(String fileName) throws IOException {
		StringBuffer sb = new StringBuffer();
		
		FileReader  in = null;
		try {
			in = new FileReader(fileName);
			
			char[] buffer = new char[4];
			int count = -1;
			while( -1 != (count=in.read(buffer)) ) {
//				String str = new String(buffer, 0, count);
//				sb.append(str);
				sb.append(buffer, 0, count);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} finally {
			if ( null != in ) {
				in.close();
			}
		}
		
		return sb.toString();
	}
	
	
	public static void writeEncode(String fileName, String msg, boolean addend, String charsetName) throws IOException{
		
		OutputStreamWriter outWriter = null;
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(fileName, addend); //  字节输出流
			outWriter = new OutputStreamWriter(out, charsetName); // 字符在字节输出流上的桥接流。
			
			outWriter.write(msg);  // 输出
			
			outWriter.flush(); // 写入物理文件
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if( null != outWriter) {
				outWriter.close();
			}
			if( null != out ) {
				out.close();
			}
		}
	}
	
	
	
	
	
	public static String readDecode(String fileName, String charsetName) throws IOException {
		StringBuffer sb = new StringBuffer();
		
		FileInputStream in = null;
		InputStreamReader inReader = null;
		try {
			in = new FileInputStream(fileName);
			inReader = new InputStreamReader(in, charsetName);
			char[] buffer  = new char[1024]; // 固定大小缓冲区
			int count = 0;
			
			while( -1 != (count=inReader.read(buffer)) ) {  // 文件不结束（clunt != -1） ，一直读。
				sb.append(buffer, 0, count);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if( null != inReader) {
				inReader.close();
			}
			if( null != in ) {
				in.close();
			}
		}
		
		return sb.toString();
	}
	
	
	public static void copy(String source, String target) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			in = new FileInputStream(source);
			out = new FileOutputStream(target);
			byte[] buffer  = new byte[1024];
			int count = 0;
			
			// 边读边写。
			while( -1 != (count = in.read(buffer)) ) {
				out.write(buffer, 0, count);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if( null != out) {
				out.close();
			}
			if( null != in ) {
				in.close();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
//		String fileName = "d:/abc.txt";
		
//		byte[] data = "hello world. I like Java.我也喜欢Python。你呢？".getBytes("utf-8");
		
//		FileUtil.writeFile(fileName, data, false);
		
//		byte[] result = FileUtil.readFile(fileName);
//		System.out.println(Arrays.toString(result));
//		System.out.println(new String(result));
		
//		FileUtil.writeMsgToFile(fileName, "大家好，明天休息。", true);
		
//		FileUtil.writeEncode(fileName, "大家好.", false, "utf-8");
		
//		String value = FileUtil.readFileContent(fileName);
//		System.out.println(value);
		
//		String value = FileUtil.readDecode(fileName, "utf-8");
//		System.out.println(value);
		
		FileUtil.copy("D:\\录频\\153_Java概述.mp4", "D:\\录频\\概述.mp4");
		
	}
}

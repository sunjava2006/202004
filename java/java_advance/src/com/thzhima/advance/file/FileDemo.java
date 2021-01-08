package com.thzhima.advance.file;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

public class FileDemo {

	public static void main(String[] args) {
		
		try {
			File adir = new File("d:/", "adir");
			
			boolean exists = adir.exists(); // 获取文件或目录是否存在。
			
//			if(!exists) {
				adir.mkdirs(); // 创建目录
//			}
			
			// 获取文件对象的“绝对路径”
			System.out.println(adir.getAbsolutePath()+ "在磁盘上存在吗?" + adir.exists());
			
			System.out.println("adir是："+ (adir.isDirectory()?"目录":"文件"));
			//========================================================
			File f = new File("d:/a");
			
//			if(!f.exists()) {
				f.createNewFile(); // 创建一个新文件
//			}
			System.out.println(f.getAbsolutePath()+ "在磁盘上存在吗?" + f.exists());
			
			f.setReadable(true, false);
		    f.setWritable(true, false);
		    f.setExecutable(true, true);
		    
			System.out.println("可读：" + f.canRead());
			System.out.println("可写: " + f.canWrite());
			System.out.println("可执行: " + f.canExecute());
			
			System.out.println("f是：" + (f.isFile()?"文件":"目录"));
			
			f.setLastModified(System.currentTimeMillis());
			
			long time = f.lastModified();
			Date lastModifyTime = new Date(time);
			System.out.println(lastModifyTime);
			
			//---------------------------------------------------------------
			System.out.println(f.length()); // 文件大小
			System.out.println(f.getTotalSpace()); // 文件所在磁盘分区大小
			System.out.println(f.getFreeSpace());  // 文件所在磁盘分区空闲空间大小
			System.out.println(f.getUsableSpace()); // 文件所在磁盘分区可用空间大小
			
			
			//===============================================================
//			adir.delete();
//			f.delete();
			
			//==================================================================
			System.out.println("绝对路径：" + f.getAbsolutePath());
			System.out.println("文件名：" + f.getName());
			System.out.println("父目录：" +f.getParent());
			System.out.println("path: "+f.getPath());
			
			
			//=============================================================
			String[] child = adir.list();
			System.out.println(Arrays.toString(child));
			
			File[] children = adir.listFiles();
			for(File i : children) {
				System.out.println(i.getAbsolutePath() + i.isDirectory());
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
	
}

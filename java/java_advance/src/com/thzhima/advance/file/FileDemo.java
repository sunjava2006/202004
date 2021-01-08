package com.thzhima.advance.file;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

public class FileDemo {

	public static void main(String[] args) {
		
		try {
			File adir = new File("d:/", "adir");
			
			boolean exists = adir.exists(); // ��ȡ�ļ���Ŀ¼�Ƿ���ڡ�
			
//			if(!exists) {
				adir.mkdirs(); // ����Ŀ¼
//			}
			
			// ��ȡ�ļ�����ġ�����·����
			System.out.println(adir.getAbsolutePath()+ "�ڴ����ϴ�����?" + adir.exists());
			
			System.out.println("adir�ǣ�"+ (adir.isDirectory()?"Ŀ¼":"�ļ�"));
			//========================================================
			File f = new File("d:/a");
			
//			if(!f.exists()) {
				f.createNewFile(); // ����һ�����ļ�
//			}
			System.out.println(f.getAbsolutePath()+ "�ڴ����ϴ�����?" + f.exists());
			
			f.setReadable(true, false);
		    f.setWritable(true, false);
		    f.setExecutable(true, true);
		    
			System.out.println("�ɶ���" + f.canRead());
			System.out.println("��д: " + f.canWrite());
			System.out.println("��ִ��: " + f.canExecute());
			
			System.out.println("f�ǣ�" + (f.isFile()?"�ļ�":"Ŀ¼"));
			
			f.setLastModified(System.currentTimeMillis());
			
			long time = f.lastModified();
			Date lastModifyTime = new Date(time);
			System.out.println(lastModifyTime);
			
			//---------------------------------------------------------------
			System.out.println(f.length()); // �ļ���С
			System.out.println(f.getTotalSpace()); // �ļ����ڴ��̷�����С
			System.out.println(f.getFreeSpace());  // �ļ����ڴ��̷������пռ��С
			System.out.println(f.getUsableSpace()); // �ļ����ڴ��̷������ÿռ��С
			
			
			//===============================================================
//			adir.delete();
//			f.delete();
			
			//==================================================================
			System.out.println("����·����" + f.getAbsolutePath());
			System.out.println("�ļ�����" + f.getName());
			System.out.println("��Ŀ¼��" +f.getParent());
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

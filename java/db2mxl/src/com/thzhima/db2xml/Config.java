package com.thzhima.db2xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

	public static String URL;
	public static String USER;
	public static String PWD;

	public static boolean loadConfig() {
		// 加载配置文件
		String path = System.getProperty("user.dir");
		File f = new File(path + "/" + App.CONFIG_FILE_NAME);
		if (f.exists()) {
			FileInputStream in = null;
			try {
				in = new FileInputStream(f);

				Properties p = new Properties();
				p.load(in);

				URL = p.getProperty("url");
				USER = p.getProperty("user");
				PWD = p.getProperty("pwd");
				
				if(null != in) {
					in.close();
				}

			} catch (IOException e1) {
				e1.printStackTrace();
			} 
			return URL !=null && USER!=null && PWD!=null 
					&& !"".equals(URL) && !"".equals(USER) && !"".equals(PWD) ? true : false;
		}
		
		return false;
	}
	
	public static boolean configOk() {
		return URL !=null && USER!=null && PWD!=null 
				&& !"".equals(URL) && !"".equals(USER) && !"".equals(PWD) ? true : false;
	}
	
	public static void setProperty(String ip, String port, String instanceName, String user, String pwd) throws IOException {
		Properties p  = new Properties();
		String url = "jdbc:oracle:thin:@"+ip+":"+port+"/"+instanceName;
		System.out.println(url);
		p.put("url", url);
		p.put("user", user);
		p.put("pwd", pwd);
	
		// 更新已有的配置
		URL = url;
		USER = user;
		PWD = pwd;		
		
		FileOutputStream writer = null;
		try {
			String path = System.getProperty("user.dir"); // 从系统变量中获取当前工作目录
			System.out.println(path);
			writer = new FileOutputStream(path+"/"+App.CONFIG_FILE_NAME); // 创建输出流
			p.store(writer, "DataBase Configuration"); // 保存配置文件
			
			
		} catch (IOException ex) {
			
			throw ex;
			
		} finally {
			if(writer != null) {
				writer.close();
			}
		}
	}
}

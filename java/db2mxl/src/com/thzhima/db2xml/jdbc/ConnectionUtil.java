package com.thzhima.db2xml.jdbc;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.thzhima.db2xml.Config;

public class ConnectionUtil {
	
	
	private static String url, user, pwd;
	
	
	static { // 静态块中的代码在类加载时执行，类的加载仅加载一次。
		InputStream in = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver"); // 注册驱动，只需要1次。
			Config.loadConfig();
			
			url = Config.URL;
			user = Config.USER;
			pwd = Config.PWD;
			
			
		} catch (ClassNotFoundException  e) {
			e.printStackTrace();
		} 
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		
		conn = DriverManager.getConnection(url, user, pwd);
		
		return conn;
	}
	
	public static void release(Connection conn) throws SQLException {
		conn.close();
	}
	
	

}

package com.thzhima.db2xml.jdbc;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.thzhima.db2xml.Config;

public class ConnectionUtil {
	
	
	private static String url, user, pwd;
	
	
	static { // ��̬���еĴ����������ʱִ�У���ļ��ؽ�����һ�Ρ�
		InputStream in = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver"); // ע��������ֻ��Ҫ1�Ρ�
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

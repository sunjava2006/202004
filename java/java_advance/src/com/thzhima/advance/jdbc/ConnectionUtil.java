package com.thzhima.advance.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	
	private static String url, user, pwd;
	
	
	static { // ��̬���еĴ����������ʱִ�У���ļ��ؽ�����һ�Ρ�
		InputStream in = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver"); // ע��������ֻ��Ҫ1�Ρ�
			
			// �������ļ��еĲ���
			Properties p = new Properties();
			
			
			in = ConnectionUtil.class.getResourceAsStream("/db.properties");
			
			p.load(in);
			
			url = p.getProperty("url");
			user = p.getProperty("user");
			pwd = p.getProperty("pwd");
			if( null != in) {
				in.close();
			}
			
		} catch (ClassNotFoundException | IOException e) {
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
	
	public static void main(String[] args) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		
		System.out.println(conn.isClosed());
		
		conn.close();
	}

}

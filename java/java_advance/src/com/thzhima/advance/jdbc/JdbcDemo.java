package com.thzhima.advance.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {

	public static void main(String[] args) throws SQLException {

		Connection conn = null;  // ����
		Statement stm = null;  // ���
		ResultSet rst = null;
		
		try {
			// 1��ע������,��ȡ����
//			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "fruit", "123456");
			
			// 2������������ִ��SQL���
			stm = conn.createStatement();  // ����������
			String sql = "select id, admin_name, pwd, status from admin";
			rst = stm.executeQuery(sql);   // ִ��SQL�����ؽ����
			
			
			// 3�������ѯ�����ResultSet�����αָ꣬�����ݿ��в�ѯ�Ľ����������������ݿ��С�
			while(rst.next()) {
				int id = rst.getInt(1);
				String adminName = rst.getString("admin_name");
				String pwd = rst.getString("pwd");
				boolean status = rst.getBoolean(4);
				
				System.out.println(id + "," + adminName + "," + pwd + "," + status);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			
		} finally {
			// 4���ͷ���Դ
			if (null != rst) {
				rst.close();
			}
			
			if (null!= stm) {
				stm.close();
			}
			
			if(null != conn) {
				conn.close();
			}
		}

	}

}

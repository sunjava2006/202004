package com.thzhima.advance.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {

	public static void main(String[] args) throws SQLException {

		Connection conn = null;  // 连接
		Statement stm = null;  // 语句
		ResultSet rst = null;
		
		try {
			// 1、注册驱动,获取连接
//			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "fruit", "123456");
			
			// 2、创建语句对象，执行SQL语句
			stm = conn.createStatement();  // 创建语句对象
			String sql = "select id, admin_name, pwd, status from admin";
			rst = stm.executeQuery(sql);   // 执行SQL，返回结果。
			
			
			// 3、处理查询结果，ResultSet内置游标，指向数据库中查询的结果。结果还是在数据库中。
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
			// 4、释放资源
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

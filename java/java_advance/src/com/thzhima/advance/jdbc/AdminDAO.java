package com.thzhima.advance.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class AdminDAO {

	public static boolean add(String name, String pwd) throws SQLException {
		String sql = "insert into admin(id, admin_name, pwd, status) values (seq_admin.nextval, ?, ?, 1)";
		return JdbcTemplate.saveOrUpdate(sql, name, pwd);
	}
	
	public static boolean updateStatus(int adminID, boolean active) throws SQLException {
		String sql = "update admin set status=? where id=?";
		return JdbcTemplate.saveOrUpdate(sql, active? 1: 0, adminID);
	}
	

	public static void delete(int ...ids) throws SQLException {
		String sql = "delete from admin where id=?";
		Object[][] array = new Object[ids.length][1];
		for(int i=0;i<ids.length;i++) {
			array[i][0]=ids[i];
			System.out.println(Arrays.toString(array[i]));
		}
		
		
		JdbcTemplate.saveOrUpdate(sql, array );
	}
	
	public static void main(String[] args) throws SQLException {

		delete(122, 1, 109);
	}
}

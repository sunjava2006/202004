package com.thzhima.advance.jdbc;

import java.sql.SQLException;

public class UserDAO {

	public static void delete(int id) throws SQLException {
		String sql = "delete from orders where user_id="+id;
		String sql2 = "delete from user_addresses where user_id="+id;
		String sql3 = "delete from users where id="+id;
		
		JdbcTemplate.saveOrUpdate(new String[] {sql, sql2, sql3});
	}
	
	public static void main(String[] args) throws SQLException {
		delete(24);
	}
}

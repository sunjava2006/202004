package com.thzhima.advance.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.thzhima.advance.jdbc.bean.User;



public class UserDAO {

	public static void delete(int id) throws SQLException {
		String sql = "delete from orders where user_id="+id;
		String sql2 = "delete from user_addresses where user_id="+id;
		String sql3 = "delete from users where id="+id;
		
		JdbcTemplate.saveOrUpdate(new String[] {sql, sql2, sql3});
	}
	
	
	public static User login(String name, String pwd) throws SQLException {
		User u = null;
		
		String sql = "select * from users where user_name=? and pwd=?";
		
		ResultSetExtractor exter = new ResultSetExtractor() {
			@Override
			public User extract(ResultSet rst) throws SQLException {
				
				User u = null;
				if(rst.next()) {
					Integer ID = rst.getInt("id");
					String userName = rst.getString("user_name");
					String PWD = rst.getString("pwd");
					Integer status = rst.getInt("status");
					String phone = rst.getString("phone");
					
					u = new User(ID, userName, PWD, status, phone);
				}
				
				return u;
			}
		};
		
		u = JdbcTemplate.query(sql, exter, name, pwd);
		
		return u;
	}
	
	public static void main(String[] args) throws SQLException {
		User u = UserDAO.login("ภ๎ถþนท", "123456");
		System.out.println(u);
	}
}

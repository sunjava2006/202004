package com.thzhima.mybatisanno.dao;

import org.apache.ibatis.jdbc.SQL;

import com.thzhima.mybatisanno.bean.User;

public class DynamicSQL {

	public static String selectUser(User u) {
		String s = null;
		SQL sql = new SQL();
		
		sql.SELECT("*").FROM("reg_user");
		if(u.getUserID()!=null) {
			sql.WHERE("user_id = #{userID}");
		}else {
			
			if(u.getRegName()!=null) {
				sql.WHERE("reg_name=#{regName}");
			}
		
			if(u.getPWD()!= null) {
				sql.AND();
				sql.WHERE("pwd= #{PWD}");
			}
		
			if(u.getEmail()!= null) {
				sql.AND();
				sql.WHERE("email=#{email}");
			}
			
			if(u.getQuestion()!=null) {
				sql.AND();
				sql.WHERE("question=#{question}");
			}
			
			if(u.getAnswer()!= null) {
				sql.AND();
				sql.WHERE("answer = #{answer}");
			}
		}
		
		s = sql.toString();
		return s;
	}
}

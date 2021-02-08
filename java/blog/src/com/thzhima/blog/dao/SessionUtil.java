package com.thzhima.blog.dao;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtil {

	static SqlSessionFactory factory;
	
	static {
	
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//		factory = builder.build(SessionUtil.class.getResourceAsStream("/config.xml"));
		
		try {
			factory = builder.build(Resources.getResourceAsReader("Config.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession  getSession() {
		SqlSession s = null;
		s = factory.openSession();
		return s;
	}
	
	public static void main(String[] args) {
		SqlSession s = getSession();
		System.out.println(s);
		s.close();
	}
}

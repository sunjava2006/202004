package com.thzhima.mybatisanno.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtil {

	private static SqlSessionFactory factory ;
	private static ThreadLocal<SqlSession> tl = new ThreadLocal<>();
	
//	public static Map<Thread, SqlSession> map = new ConcurrentHashMap<>();
	
	static {
		SqlSessionFactoryBuilder b = new SqlSessionFactoryBuilder();
		
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("Config.xml");
			factory = b.build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static SqlSession getSession() {
		SqlSession s = null;
		s = tl.get();
//		s = map.get(Thread.currentThread());
		if(s == null) {
			s = factory.openSession();
//			map.put(Thread.currentThread(), s);
			tl.set(s);
			System.out.println("getSession:"+s);
		}
		
		return s;
	}
	
	public static void close() {
		System.out.println("session closed.");
        SqlSession s = null;
//		s = map.get(Thread.currentThread());
        s  = tl.get();
		if(s!=null) {
			System.out.println("clsseSession:"+s);
			s.close();
//			map.remove(Thread.currentThread());
			tl.remove();
		}
	}
	
	public static void main(String[] args) {
		SqlSession s = getSession();
		
		System.out.println(s);
		s.close();
	}
}

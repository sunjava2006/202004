package com.thzhima.blog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.thzhima.blog.bean.Article;

public class MybatisTemplate {

	public static int saveOrUpdate(String methodid, Object arg) {
		int count = -1;
        SqlSession session = null;
		
		try {
			session = SessionUtil.getSession();
		
			count = session.insert(methodid, arg);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}
	
	public static <T> T selectOne(String methodid, Object arg) {
        SqlSession session = null;
        T t = null;
		
		try {
			session = SessionUtil.getSession();
			t = session.selectOne(methodid, arg);
			
			session.commit();
			
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return t;
	}
	
	public static <T> List<T> selectList(String methodid, Object arg) {
        SqlSession session = null;
        List<T> list = null;
		
		try {
			session = SessionUtil.getSession();
			list = session.selectList(methodid, arg);
			session.commit();
			
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	public static int update(String methodid, Object arg) {
		int count = -1;
		
		SqlSession session = null;
		try {
			session = SessionUtil.getSession();
			count = session.update(methodid, arg);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			Logger.getLogger(MybatisTemplate.class).error(e);
		} finally {
			session.close();
		}
		
		return count;
	}
	
	public static int insert(String methodid, Object arg) {
		int count = -1;
		
		SqlSession session = null;
		try {
			session = SessionUtil.getSession();
			count = session.insert(methodid, arg);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			Logger.getLogger(MybatisTemplate.class).error(e);
		} finally {
			session.close();
		}
		
		return count;
	}
	
	
	
	public static void main(String[] args) {
		Article a = selectOne(Article.class.getName()+".selectByID", 1);
		a = selectOne(Article.class.getName()+".selectByID", 1);
		System.out.println(a);
		a.setTitle("Python###");
		update(Article.class.getName()+".update", a);
		a = selectOne(Article.class.getName()+".selectByID", 1);
		System.out.println(a);
		
	}
}

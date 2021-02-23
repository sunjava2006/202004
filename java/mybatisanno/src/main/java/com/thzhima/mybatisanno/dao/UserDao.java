package com.thzhima.mybatisanno.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.thzhima.mybatisanno.bean.User;

public class UserDao {

	
	public static int save(User u) {
		SqlSession s = null;
		int count = -1;
		try {
			s = SessionUtil.getSession();
			UserMapper m = s.getMapper(UserMapper.class); // 获取映射接口的实现
			count = m.add(u); // 调用接口实现方法
			s.commit();
		} catch (Exception e) {
			s.rollback();
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return count;
	}
	
	public static User login(User u) {
		SqlSession s = null;
		
		try {
			s = SessionUtil.getSession();
			UserMapper m = s.getMapper(UserMapper.class); // 获取映射接口的实现
			u = m.fingByNameAndPWD(u); // 调用接口实现方法
			s.commit();
		} catch (Exception e) {
			s.rollback();
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return u;
	}
	
	public static List<User> select(User u) {
		SqlSession s = null;
		List<User> li = null;
		try {
			s = SessionUtil.getSession();
			UserMapper m = s.getMapper(UserMapper.class); // 获取映射接口的实现
			li = m.select(u); // 调用接口实现方法
			s.commit();
		} catch (Exception e) {
			s.rollback();
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return li;
	}
	
	public static void main(String[] args) {
		User u = new User(5, "小狗","123123", null, null, null);
//		System.out.println(save(u));
		
	    List<User> li  = select(u);
	    for(User i: li) {
	    	System.out.println(i);
	    	System.out.println(i.getBlog());
	    }
	}
	
}

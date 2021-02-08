package com.thzhima.blog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.thzhima.blog.bean.User;

public class UserDao {

	public static int add(User u) {
		
			String method = u.getClass().getName()+".addUser";
			return MybatisTemplate.saveOrUpdate(method, u);
		
	}
	
	
	public static User selectOne (User u) {
		User user = null;
		String methodid = u.getClass().getName()+".select";
		user = MybatisTemplate.selectOne(methodid, u);
		return user;
	}
	
	public static int userCount() {
		return MybatisTemplate.selectOne(User.class.getName()+".user_count", null);
	}
	
	public static List<Map> listByPage(int page, int size){
		
		Logger logger = Logger.getLogger(UserDao.class);
		
		
		logger.debug("-----------分页查询用户--------------------------");
		
		logger.info("==================info ===============");
		
		Map m = new HashMap();
		m.put("page", page);
		m.put("size", size);
		return MybatisTemplate.selectList(User.class.getName()+".listByPage", m);
	}
	
	public static void main(String[] args) {
//		add(new User(0, "LiLi", "122113", "mail@mail.com", "1+1", "2"));
		User u = selectOne(new User(null, "wang", "123456", null, null, null));
		System.out.println(u);
		System.out.println(u.getBlog());
		
//		System.out.println(userCount());
		
//		System.out.println(listByPage(2, 1));
		
	}
	
	
	
}

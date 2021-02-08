package com.thzhima.blog.service;

import com.thzhima.blog.bean.User;
import com.thzhima.blog.dao.UserDao;

public class UserService {

	public static boolean regist(String userName, String pwd, String email, String question, String answer) {
		boolean ok = true;
		
		int count = UserDao.add(new User(null, userName, pwd, email, question, answer));
		if(count != 1) {
			ok = false;
		}
		
		return ok;
	}
	
	public static User login(String userName, String pwd) {
		return UserDao.selectOne(new User(null, userName, pwd, null, null, null));
	}
}

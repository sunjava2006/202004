package com.thzhima.blog.service;

import com.thzhima.blog.bean.Blog;
import com.thzhima.blog.dao.BlogDao;

public class BlogService {

	public static Blog apply(Blog b) {
		BlogDao.add(b);
		return b;
	}
	
	public static Blog selectByID(int id) {
		return BlogDao.selectOne(new Blog(id, null, null, null, null, null));
	}
}

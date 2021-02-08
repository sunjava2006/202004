package com.thzhima.blog.dao;

import com.thzhima.blog.bean.Blog;

public class BlogDao {

	public static int add(Blog b) {
		return MybatisTemplate.saveOrUpdate(b.getClass().getName()+".add", b);
	}
	
	public static Blog selectOne(Blog blog) {
		return MybatisTemplate.selectOne(Blog.class.getName()+".select", blog);
	}
}

package com.thzhima.mybatisanno.dao;

import com.thzhima.mybatisanno.bean.Blog;

import junit.framework.TestCase;

public class BlogDaoTest extends TestCase {

	public void testFindByUserID() {
		Blog b = BlogDao.findByUserID(5);
		System.out.println(b);
		assertNotNull(b);
	}

}

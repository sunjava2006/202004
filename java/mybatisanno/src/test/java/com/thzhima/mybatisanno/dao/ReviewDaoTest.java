package com.thzhima.mybatisanno.dao;

import java.util.List;

import com.thzhima.mybatisanno.bean.Review;

import junit.framework.TestCase;

public class ReviewDaoTest extends TestCase {

	public void testSelectByArticleID() {
		List<Review> list = ReviewDao.selectByArticleID(1);
		System.out.println(list);
		assertEquals(list.size(), 10);
	}
}

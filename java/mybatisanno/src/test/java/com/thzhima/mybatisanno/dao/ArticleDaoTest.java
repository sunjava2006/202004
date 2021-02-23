package com.thzhima.mybatisanno.dao;

import com.thzhima.mybatisanno.bean.Article;

import junit.framework.TestCase;

public class ArticleDaoTest extends TestCase {

	public void testFindByID() {
		Article a = ArticleDao.findByID(1);
		System.out.println(a);
		System.out.println(a.getReviews());
		assertNotNull(a);
	}

}

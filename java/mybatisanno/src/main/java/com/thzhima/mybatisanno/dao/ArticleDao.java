package com.thzhima.mybatisanno.dao;

import org.apache.ibatis.session.SqlSession;

import com.thzhima.mybatisanno.bean.Article;

public class ArticleDao {

	public static Article findByID(int id) {
		Article a = null;
		SqlSession s = null;
		try {
			s = SessionUtil.getSession();
			ArticleMapper m = s.getMapper(ArticleMapper.class);
			a = m.selectByID(1);
			s.commit();
		} catch (Exception e) {
			s.rollback();
			e.printStackTrace();
		} finally {
			s.close();
		}
		return a;
	}
	
	public static int delByBlog(int blogID) {
		int count = -1;
		SqlSession s = null;
	
			s = SessionUtil.getSession();
			ArticleMapper m = s.getMapper(ArticleMapper.class);
			count = m.delByBlog(blogID);

		return count;
	}
}

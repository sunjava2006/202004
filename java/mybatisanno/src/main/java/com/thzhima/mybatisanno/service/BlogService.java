package com.thzhima.mybatisanno.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.thzhima.mybatisanno.dao.ArticleDao;
import com.thzhima.mybatisanno.dao.ArticleMapper;
import com.thzhima.mybatisanno.dao.BlogDao;
import com.thzhima.mybatisanno.dao.BlogMapper;
import com.thzhima.mybatisanno.dao.SessionUtil;
import com.thzhima.mybatisanno.dao.Transaction;

@Service
public class BlogService {

	@Transaction
	public void delBlog(int blogID) {
		ArticleDao.delByBlog(blogID);
		BlogDao.delete(blogID);
		
//		SqlSession s = null;
//		int count = -1;
//		try {
//			s = SessionUtil.getSession();
//			ArticleMapper am = s.getMapper(ArticleMapper.class);
//			am.delByBlog(blogID);
//			BlogMapper m = s.getMapper(BlogMapper.class);
//			count = m.del(blogID);
//			s.commit();
//		} catch (Exception e) {
//			s.rollback();
//		} finally {
//			s.close();
//		}
//		
		
	}
	
	
	public void abc() {
		System.out.println("----------------------------------------------------------");
	}
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app4.xml");
		BlogService bs = app.getBean(BlogService.class);
		bs.delBlog(1);
		
		bs.abc();
	}
}

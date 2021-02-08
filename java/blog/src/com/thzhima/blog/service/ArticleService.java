package com.thzhima.blog.service;

import java.util.List;

import com.thzhima.blog.bean.Article;
import com.thzhima.blog.dao.ArticleDao;

public class ArticleService {

	
	public static Article publish(Article a) {
		return ArticleDao.add(a);
	}
	
	public static List<Article> listByPage(int page, int size, int blogID){
		return ArticleDao.list(page, size, blogID);
	}
	
}

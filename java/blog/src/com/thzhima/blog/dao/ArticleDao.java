package com.thzhima.blog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thzhima.blog.bean.Article;

public class ArticleDao {

	public static Article findByID(int id) {
		return MybatisTemplate.selectOne(Article.class.getName()+".selectByID", id);
	}
	
	public static Article add(Article a) {
		MybatisTemplate.insert(Article.class.getName()+".add", a);
		return a;
	}
	
	
	
	public static List<Article> list(int page, int size, int blogID){
		Map<String, Integer> m = new HashMap<>();
		m.put("page", page);
		m.put("size", size);
		m.put("blogID", blogID);
		return MybatisTemplate.selectList(Article.class.getName()+".articleListByBlogID", m);
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println(findByID(1));
	}
}

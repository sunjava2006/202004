package com.thzhima.mybatisanno.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.thzhima.mybatisanno.bean.Article;

public interface ArticleMapper {

	@Select("select * from article where article_id=#{id}")
	@Results(id = "articleMap",
	 		 value = {@Result(column = "article_id", property = "articleID", id=true),
	 				  @Result(column = "blog_id", property = "blogID"),
	 				  @Result(column = "title", property = "title"),
	 				  @Result(column = "content", property = "content"),
	 				  @Result(column = "article_id", property = "reviews" ,
	 				  many = @Many(select = "com.thzhima.mybatisanno.dao.ReviewMapper.findByArticleID")),
	 				 
	 		 }
			)
	public Article selectByID(int id);
	
	@Delete("delete from article where blog_id=#{blogID}")
	public int delByBlog(int BlogID);
}

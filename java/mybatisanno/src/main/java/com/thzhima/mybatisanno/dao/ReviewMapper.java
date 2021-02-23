package com.thzhima.mybatisanno.dao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.thzhima.mybatisanno.bean.Review;

public interface ReviewMapper {

	@Select("select * from review where article_id=#{articleID}")
	@Results(id="reviewMap", 
	         value = {@Result(column = "review_id", property = "reviewID", id=true),
	        		 @Result(column = "article_id", property = "articleID"),
	        		 @Result(column = "content", property = "content"),
	        		 @Result(column = "user_id", property = "user",
	        		         one = @One(select = "com.thzhima.mybatisanno.dao.UserMapper.findByID"))} 
			)
	public List<Review> findByArticleID(int articleID);
}

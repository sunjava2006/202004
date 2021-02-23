package com.thzhima.mybatisanno.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.thzhima.mybatisanno.bean.Blog;

public interface BlogMapper {

	@Select("select * from blog where user_id=#{userid}")
	@Results(id = "blogMap",
	 		 value = {@Result(column = "blog_id", property = "blogID", id=true),
	 				  @Result(column = "blog_name", property = "blogName"),
	 				  @Result(column = "nick_name", property = "nickName"),
	 				  @Result(column = "photo", property = "photo"),
	 				  @Result(column = "description", property = "description"),
	 				  @Result(column = "user_id", property = "userID"),
	 		 }
			
			)
	public Blog findByUserID(int userid);
	
	
	@Delete("delete from blog where blog_id=#{id}")
	public int del(int id) ;
	
}

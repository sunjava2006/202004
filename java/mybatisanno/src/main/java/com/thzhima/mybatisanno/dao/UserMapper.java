package com.thzhima.mybatisanno.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.thzhima.mybatisanno.bean.User;
import com.thzhima.mybatisanno.dao.DynamicSQL;

public interface UserMapper {

	@Insert(value = "insert into reg_user values (seq_reg_user.nextval, #{regName}, #{PWD}, #{email}, #{question}, #{answer})")
	public int add(User u);
	
	
	@Select(value = "select * from reg_user where reg_name=#{regName} and pwd = #{PWD}")
	@Results(id="userMap",
	         value = {@Result(column = "user_id", property = "userID", id = true),
	        		  @Result(column = "reg_name", property = "regName"),
	        		  @Result(column = "pwd", property = "PWD"),
	        		  @Result(column = "email", property = "email"),
	        		  @Result(column = "question", property = "question"),
	        		  @Result(column = "answer", property = "answer"),
	        		  @Result(column = "user_id", property = "blog",
	        		          one=@One(select = "com.thzhima.mybatisanno.dao.BlogMapper.findByUserID"
                                      ))
	                  }
	         )
	public User fingByNameAndPWD(User u);
	
	@SelectProvider(type=DynamicSQL.class, method = "selectUser")
	@ResultMap("userMap")
	public List<User> select(User u);
	
	@Select("select * from reg_user where user_id=#{userid}")
	@Results(id="userMapNoBlog",
    value = {@Result(column = "user_id", property = "userID", id = true),
   		  @Result(column = "reg_name", property = "regName"),
   		  @Result(column = "pwd", property = "PWD"),
   		  @Result(column = "email", property = "email"),
   		  @Result(column = "question", property = "question"),
   		  @Result(column = "answer", property = "answer")
   		}
    )
	public User findByID(int userid);
	
}

package com.thzhima.mybatisanno.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.thzhima.mybatisanno.bean.Review;

public class ReviewDao {

	public static List<Review> selectByArticleID(int articleID){
		List<Review> list = null;
		
		
		SqlSession s = null;

		try {
			s = SessionUtil.getSession();
			ReviewMapper m = s.getMapper(ReviewMapper.class); // 获取映射接口的实现
			list = m.findByArticleID(articleID) ;// 调用接口实现方法
			s.commit();
		} catch (Exception e) {
			s.rollback();
			e.printStackTrace();
		} finally {
			s.close();
		}
		return list;
	}
}

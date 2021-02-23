package com.thzhima.mybatisanno.dao;

import org.apache.ibatis.session.SqlSession;

import com.thzhima.mybatisanno.bean.Blog;

public class BlogDao {

	public static Blog findByUserID(int id) {
		Blog b = null;

		SqlSession s = null;

		try {
			s = SessionUtil.getSession();
			BlogMapper m = s.getMapper(BlogMapper.class); // 获取映射接口的实现
			b = m.findByUserID(id); // 调用接口实现方法
			s.commit();
		} catch (Exception e) {
			s.rollback();
			e.printStackTrace();
		} finally {
			s.close();
		}

		return b;
	}
	
	
	public static int delete(int id) {
		SqlSession s = null;
		int count = -1;
		
			s = SessionUtil.getSession();
			BlogMapper m = s.getMapper(BlogMapper.class);
			count = m.del(id);

		return count;
	}
	
}

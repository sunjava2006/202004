package com.thzhima.blog.dao;

import java.util.List;

import com.thzhima.blog.bean.Review;

public class ReviewDao {

	public static List<Review> listArticleReview(int articleID){
		return MybatisTemplate.selectList(Review.class.getName()+".selectByArticle", articleID);
	}
	
	
	public static void main(String[] args) {
		System.out.println(listArticleReview(1));
	}
}

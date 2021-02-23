package com.thzhima.mybatisanno.bean;

import java.io.Serializable;

public class Review implements Serializable{

	private Integer reviewID;
	private Integer articleID;
	private String content;
	private User user;
	
	public Integer getReviewID() {
		return reviewID;
	}
	public void setReviewID(Integer reviewID) {
		this.reviewID = reviewID;
	}
	public Integer getArticleID() {
		return articleID;
	}
	public void setArticleID(Integer articleID) {
		this.articleID = articleID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Review(Integer reviewID, Integer articleID, String content, User user) {
		super();
		this.reviewID = reviewID;
		this.articleID = articleID;
		this.content = content;
		this.user = user;
	}
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Review [reviewID=" + reviewID + ", articleID=" + articleID + ", content=" + content + ", user=" + user
				+ "]";
	}
	
	
	
}

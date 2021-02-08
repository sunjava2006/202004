package com.thzhima.blog.bean;

import java.io.Serializable;
import java.util.List;

public class Article implements Serializable{
	private Integer articleID;
	private Integer blogID;
	private String title;
	private String content;
	private List<Review> reviews; // 对多的关联关系
	public Integer getArticleID() {
		return articleID;
	}
	public void setArticleID(Integer articleID) {
		this.articleID = articleID;
	}
	public Integer getBlogID() {
		return blogID;
	}
	public void setBlogID(Integer blogID) {
		this.blogID = blogID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public Article(Integer articleID, Integer blogID, String title, String content, List<Review> reviews) {
		super();
		this.articleID = articleID;
		this.blogID = blogID;
		this.title = title;
		this.content = content;
		this.reviews = reviews;
	}
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Article [articleID=" + articleID + ", blogID=" + blogID + ", title=" + title + ", content=" + content
				+ ", reviews=" + reviews + "]";
	}
	
	
	
	
	
}

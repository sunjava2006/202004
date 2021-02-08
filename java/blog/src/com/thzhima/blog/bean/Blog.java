package com.thzhima.blog.bean;

import java.io.Serializable;

public class Blog implements Serializable{

	private Integer blogID;
	private String blogName;
	private String nickName;
	private String photo;
	private String description;
	private Integer userID;
	
	public Integer getBlogID() {
		return blogID;
	}
	public void setBlogID(Integer blogID) {
		this.blogID = blogID;
	}
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
	@Override
	public String toString() {
		return "Blog [blogID=" + blogID + ", blogName=" + blogName + ", nickName=" + nickName + ", photo=" + photo
				+ ", description=" + description + ", userID=" + userID + "]";
	}
	public Blog(Integer blogID, String blogName, String nickName, String photo, String description, Integer userID) {
		super();
		this.blogID = blogID;
		this.blogName = blogName;
		this.nickName = nickName;
		this.photo = photo;
		this.description = description;
		this.userID = userID;
	}
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

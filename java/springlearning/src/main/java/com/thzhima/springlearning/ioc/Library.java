package com.thzhima.springlearning.ioc;

import java.util.Set;

public class Library {

	private String name;
	private int buildTime;
	private String master = "李小红";
	private Set<String> bookNames;
	

	public Set<String> getBookNames() {
		return bookNames;
	}

	public void setBookNames(Set<String> bookNames) {
		this.bookNames = bookNames;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public int getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(int buildTime) {
		this.buildTime = buildTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}

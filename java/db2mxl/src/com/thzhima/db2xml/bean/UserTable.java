package com.thzhima.db2xml.bean;

public class UserTable {

	private String tableName;
	private String tablespaceName;
	private String status;
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTablespaceName() {
		return tablespaceName;
	}
	public void setTablespaceName(String tablespaceName) {
		this.tablespaceName = tablespaceName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UserTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserTable(String tableName, String tablespaceName, String status) {
		super();
		this.tableName = tableName;
		this.tablespaceName = tablespaceName;
		this.status = status;
	}
	@Override
	public String toString() {
		return "UserTable [tableName=" + tableName + ", tablespaceName=" + tablespaceName + ", status=" + status + "]";
	}
	
	
	
}

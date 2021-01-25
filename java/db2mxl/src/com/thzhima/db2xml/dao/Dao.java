package com.thzhima.db2xml.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thzhima.db2xml.bean.UserTable;
import com.thzhima.db2xml.jdbc.JdbcTemplate;
import com.thzhima.db2xml.jdbc.ResultSetExtractor;

public class Dao {

	public static List<UserTable> listUserTables() throws SQLException{
		List<UserTable> list = null;
		
		String sql = "select table_name, tablespace_name, status from user_tables";
		
		ResultSetExtractor extor = new ResultSetExtractor() {
			
			@Override
			public  List<UserTable> extract(ResultSet rst) throws SQLException {
				List<UserTable> list = new ArrayList<>();
				while(rst.next()) {
					String tableName = rst.getString("table_name");
					String tablespaceName = rst.getString("tablespace_name");
					String status = rst.getString("status");
					
					list.add(new UserTable(tableName, tablespaceName, status));
				}
				return list;
			}
		};
		
		
		list = JdbcTemplate.query(sql, extor, null);
		
		return list;
	}
	
	
	public static int count(String tableName) throws SQLException {
		String sql = "select count(*) from "+tableName;
		
		
		return JdbcTemplate.query(sql, new ResultSetExtractor() {
			
			@Override
			public  Integer extract(ResultSet rst) throws SQLException {
			    int count = 0;
			    if(rst.next()) {
			    	count = rst.getInt(1);
			    }
				return count;
			}
		});
	}
	
	
	public static void selectAndWrite(String tableName, File xmlflle, String charset, PipedOutputStream out) throws SQLException, FileNotFoundException, UnsupportedEncodingException {
		
		final FileOutputStream fout = new FileOutputStream(xmlflle);;
		OutputStreamWriter writer = new OutputStreamWriter(fout, charset);
		
		String sql = "select * from "+ tableName;
		
		JdbcTemplate.query(sql, new ResultSetExtractor() {
			
			@Override
			public Integer extract(ResultSet rst) throws SQLException {
				
				int count = 0;
				try {
	
					// œ»–¥xml…Í√˜
					writer.write("<?xml version=\"1.0\" encoding=\""+charset+"\" standalone=\"no\"?>\n");
					writer.write("<"+tableName+"_list>\n");
					
					int colCount = rst.getMetaData().getColumnCount();
					while(rst.next()) {
						Thread.sleep(1000);
						out.write(++count);
						writer.write("<" + tableName + ">\n");
						for(int i=1; i<=colCount ;i++) {
							String name = rst.getMetaData().getColumnName(i);
							Object value = rst.getObject(i);
							
							writer.write("<"+name+">\n");
							   writer.write("<![CDATA["+value+"]]>\n");
							writer.write("</"+name+">\n");
						}
						writer.write("</" + tableName + ">\n");
					}
					
					writer.write("</"+tableName+"_list>");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if(writer != null) {
							writer.close();
						}
						if(fout != null) {
							fout.close();
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
				}
				
				return count;
			}
		});
		
	}
	
//	public static void main(String[] args) throws SQLException, IOException {
//		PipedInputStream in = new PipedInputStream();
//		PipedOutputStream out = new PipedOutputStream(in);
//		 selectAndWrite("users", new File("d://users.xml"), "utf-8", out);
//	}
	
}

package com.thzhima.db2xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import com.thzhima.db2xml.jdbc.ConnectionUtil;

public class PassXML {
	
	private  ContentHandler handler = new DefaultHandler() {
		
		private Connection conn = null;
		private PreparedStatement stm = null;
		String tableName = null;
		boolean newRecord = false;
		boolean newCol = false;
		List<String> colNameList = new ArrayList<>();
		List<Object> colValueList = new ArrayList<>();
		String currentEleType = "";
		Object currValue = null;

		boolean error = false;
		
		@Override
		public void startDocument() throws SAXException {
			try {
				conn = ConnectionUtil.getConnection();
				conn.setAutoCommit(false);
				
			} catch (SQLException e) {
				error = true;
				e.printStackTrace();
			}
		}

		@Override
		public void endDocument() throws SAXException {
			try {
				if(stm != null) {
					stm.close();
				}
				if(conn != null) {
					conn.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			if(localName.endsWith("_list")) {
				this.tableName = localName.substring(0, localName.lastIndexOf("_list"));
			}
			else if("record".equals(localName)) {
				newRecord = true;
			}
			else {
				this.newCol = true;
				colNameList.add(localName);
				this.currentEleType = attributes.getValue("type");
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if(localName.equals("record")) {
				
				if(this.stm == null) {
					if(!error) {
						StringBuffer colList = new StringBuffer();
						StringBuffer colvalues = new StringBuffer();
						for(String s : this.colNameList) {
							colList.append(s).append(",");
							colvalues.append("?,");
						}
						
						colList.deleteCharAt(colList.length()-1);
						colvalues.deleteCharAt(colvalues.length()-1);
						
						
						String sql = "insert into "+this.tableName+"("+colList+") values ("+colvalues+")";
						System.out.println(sql);
						try {
							stm = conn.prepareStatement(sql);
						} catch (SQLException e) {
							error = true;
							e.printStackTrace();
						}
					}
					
				}
				// 为 stm 赋值，并执行
				if(!error) {
					try {
						System.out.println(this.colValueList.size());
						for(int i=0;i<this.colValueList.size();i++) {
//							System.out.println(this.colValueList.get(i));
							stm.setObject(i+1, this.colValueList.get(i));
						
					    }
						stm.executeUpdate();
					} catch (Exception e) {
						try {
							conn.rollback();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						error= true;
						e.printStackTrace();
					}
				}
				
				
				
				this.colNameList.clear();
				this.colValueList.clear();
			}
			else if (localName.endsWith("_list")) {
				
			}
			else {
				this.colValueList.add(this.currValue);
				this.newCol = false;
				this.currValue = null;
			}
			
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			String str = new String(ch, start, length);
//			System.out.println("str:" + "\n".equals(str));
			str = str.replaceAll("\n","");
			
			if("NUMBER".equals(this.currentEleType)) {
				
				if(!"".equals(str)) {
					
					this.currValue = Integer.parseInt(str);
				}
				
				
			}else if(this.currentEleType.contains("CHAR")) {
//				System.out.println(str+":"+(str.length()));
				if(this.newCol) {
					if(this.currValue==null) {
						this.currValue = str;
					}
					else {
						this.currValue += str;
					}
					
				}
			}
			
			
			
		}
		
	};
	
	
	public  void pass(File xmlFile, String charset) {

		
		FileInputStream fin  = null;
		InputStreamReader reader = null;
		
		try {
			fin = new FileInputStream(xmlFile);
			reader = new InputStreamReader(fin);
			XMLReader xmlReader = XMLReaderFactory.createXMLReader();
			xmlReader.setContentHandler(handler);
			
			xmlReader.parse(new InputSource(reader));
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	public static void main(String[] args) {
		PassXML px = new PassXML();
		px.pass(new File("C:\\Users\\wangrui\\Desktop\\admin.xml"), "utf-8");
	}
	

}

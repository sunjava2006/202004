package com.thzhima.advance.xml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class XmlPass {

	
	
	
	
	
	public static void main(String[] args) throws SAXException, IOException {
		
		
		ContentHandler handler = new DefaultHandler() {

			@Override
			public void startDocument() throws SAXException {
				System.out.println("文档开始");
				
			}

			@Override
			public void endDocument() throws SAXException {
				System.out.println("文档结束");
			}

			@Override
			public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
				System.out.println("<"+localName+">");
			}

			@Override
			public void endElement(String uri, String localName, String qName) throws SAXException {
				System.out.println("</"+localName+">");
			}

			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
				System.out.println(new String(ch, start, length));
			}

			
			
		};
		
		
	    FileInputStream fin = null;
	    InputStreamReader reader = null;
		try {
			fin  = new FileInputStream("D:\\abc.xml");
			reader = new InputStreamReader(fin, "utf-8");
			XMLReader xmlreader = XMLReaderFactory.createXMLReader();
			xmlreader.setContentHandler(handler);
			xmlreader.parse(new InputSource(reader));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			reader.close();
			fin.close();
		}

	}

}

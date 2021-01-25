package com.thzhima.advance.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlUtil {

	
	/**
	 * 将List中的Map数据写入到指定文件中。
	 * @param file
	 * @param list
	 * @param charset
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerException
	 * @throws ParserConfigurationException
	 */
	public static void write(File file, List<Map<String, Object>> list, String charset) throws TransformerFactoryConfigurationError, TransformerException, ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();
		Element rootEle = doc.createElement("admin_list");
		doc.appendChild(rootEle);
		
		for(Map<String, Object> i : list) {
			Element itemEle = doc.createElement("admin");
			rootEle.appendChild(itemEle);
			
			for(Entry<String, Object> en: i.entrySet()) {
				String key = en.getKey();
				Object v = en.getValue();
				
				Element keyEle = doc.createElement(key);
				itemEle.appendChild(keyEle);
				
				CDATASection content = doc.createCDATASection(v.toString());
				keyEle.appendChild(content);
			}
		}
		
		// 设置转换器的输出字符编码、缩进
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.ENCODING, charset);
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		
		Source xmlSource = new DOMSource(doc);
		Result outputTarget = new StreamResult(file);
		
		tf.transform(xmlSource, outputTarget);
	}
	
	
	/**
	 * 读取指定XML文件，返回DOM。
	 * @param xmlfile
	 * @return
	 * @throws TransformerFactoryConfigurationError 
	 * @throws TransformerException 
	 */
	public static Document read(File xmlfile) throws TransformerFactoryConfigurationError, TransformerException {
		Document doc = null;
		
		Transformer tf  = TransformerFactory.newInstance().newTransformer();
		Source source = new StreamSource(xmlfile);
		DOMResult target = new DOMResult();
		
		tf.transform(source, target);
		
		doc = (Document) target.getNode();
		
		return doc;
	}
	
	public static List<Map<String, Object>> pass(Document doc) {
		NodeList nlist = doc.getElementsByTagName("admin");
		List<Map<String, Object>> list = new ArrayList<>();
		
		for(int i=0;i<nlist.getLength();i++) {
			Element e = (Element) nlist.item(i);
			NodeList children = e.getChildNodes();
			Map<String, Object> m = new HashMap<>();
			for(int j=0; j<children.getLength(); j++) {
				Node ce = children.item(j);
				if(ce instanceof Element) {
					String key = ce.getNodeName();
					String val = ce.getTextContent();
					
					m.put(key,val);
				}
				
			}
			list.add(m);
			
		}
		
		return list;
		
	}
	
	
	public static void main(String[] args) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		Document doc = read(new File("d://abc.xml"));
		
		
		System.out.println(pass(doc));
	}
	
}

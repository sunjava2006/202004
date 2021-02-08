package com.thzhima.blog.controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StartupListener implements ServletContextListener {
	public static final String UPLOAD_PATH = "uploadPath";
	public static final String ACCESS_COUNT = "accessCount";
	public static final String PEOPLE_COUNT = "peopleCount";
	public static final String CURRENT_COUNT = "currentCount";
	public static final String CURRENT_LOGIN = "currentLogin";

	// 设置全局初始化参数。
	public void contextInitialized(ServletContextEvent evt) {
		ServletContext application = evt.getServletContext();
		String value = application.getInitParameter("uploadPath");
		if ("local".equals(value)) {

			String path = application.getRealPath("/upload");
			File dir = new File(path);
			dir.mkdirs();
			application.setAttribute(UPLOAD_PATH, path);
		} else {
			application.setAttribute(UPLOAD_PATH, value);
		}

		String path = application.getRealPath("/");
		System.out.println(path);
		FileReader reader = null;

		try {
			reader = new FileReader(path+"/count.properties");
			Properties p = new Properties();
			
			p.load(reader);
			long count = Long.parseLong(p.getProperty("accessCount"));
			long peopleCount = Long.parseLong(p.getProperty("peopleCount"));
			application.setAttribute(ACCESS_COUNT, count);
			application.setAttribute(PEOPLE_COUNT, peopleCount);
			application.setAttribute(CURRENT_COUNT, 0L);
			application.setAttribute(CURRENT_LOGIN, 0L);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
            try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void contextDestroyed(ServletContextEvent evt) {
		ServletContext app = evt.getServletContext();
		String path = app.getRealPath("/");
		
		FileWriter w = null;
		try {
			w = new FileWriter(path+"/count.properties");
			String count = app.getAttribute(ACCESS_COUNT)+"";
			String peopleCount = app.getAttribute(PEOPLE_COUNT)+"";
			Properties p = new Properties();		
			
			p.setProperty("accessCount", count);
			p.setProperty("peopleCount", peopleCount);
			p.store(w, "");
			
		} catch (Exception e) {
			
		} finally {
			try {
				w.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

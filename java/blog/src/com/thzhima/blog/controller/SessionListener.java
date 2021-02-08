package com.thzhima.blog.controller;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

   
    public void sessionCreated(HttpSessionEvent se)  { 
         ServletContext app = se.getSession().getServletContext();
         Long pcount = (Long) app.getAttribute(StartupListener.PEOPLE_COUNT);
         Long curr = (Long) app.getAttribute(StartupListener.CURRENT_COUNT);
         pcount += 1;
         curr += 1;
         
         app.setAttribute(StartupListener.PEOPLE_COUNT, pcount);
         app.setAttribute(StartupListener.CURRENT_COUNT, curr);
         
         
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	 ServletContext app = se.getSession().getServletContext();
       
         Long curr = (Long) app.getAttribute(StartupListener.CURRENT_COUNT);
        
         curr -= 1;
         
        
         app.setAttribute(StartupListener.CURRENT_COUNT, curr);
         
         Enumeration<String> names = se.getSession().getAttributeNames();
         while(names.hasMoreElements()) {
        	 String s = names.nextElement();
        	 
        	 System.out.println("attrName: " + s);
         }
         
    }


	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		String attrName = se.getName();
		if("userInfo".equals(attrName)) {
			ServletContext app = se.getSession().getServletContext();
			Long currLogin = (Long) app.getAttribute(StartupListener.CURRENT_LOGIN);
			currLogin += 1;
			app.setAttribute(StartupListener.CURRENT_LOGIN, currLogin);
		}
	}


	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		String attrName = se.getName();
		if("userInfo".equals(attrName)) {
			ServletContext app = se.getSession().getServletContext();
			Long currLogin = (Long) app.getAttribute(StartupListener.CURRENT_LOGIN);
			currLogin -= 1;
			app.setAttribute(StartupListener.CURRENT_LOGIN, currLogin);
		}
	}
    
    
    
    
	
}

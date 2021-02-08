package com.thzhima.blog.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;



public class RequestListener implements ServletRequestListener {

	
	public void requestInitialized(ServletRequestEvent evt)  { 
        ServletContext app = evt.getServletContext();
        
        Long count = (Long) app.getAttribute(StartupListener.ACCESS_COUNT);
        count += 1;
        app.setAttribute(StartupListener.ACCESS_COUNT, count);
    }
	
    public void requestDestroyed(ServletRequestEvent evt)  { 
        
    }

	
    
	
}

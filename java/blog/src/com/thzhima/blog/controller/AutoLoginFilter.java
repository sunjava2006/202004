package com.thzhima.blog.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.thzhima.blog.bean.User;
import com.thzhima.blog.service.UserService;


@WebFilter("/*")
public class AutoLoginFilter implements Filter {

 
  
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		request.setCharacterEncoding("utf-8");
		Cookie[] cks = req.getCookies();
		String userName = null;
		String pwd  = null;
		if(cks!=null) {
			for(Cookie i : cks) {
				String name = i.getName();
				String value = i.getValue();
				
				if("userName".equals(name)) {
					userName = value;
				}else if("pwd".equals(name)) {
					pwd = value;
				}
			}
			if(userName != null && pwd != null) {
				User u = UserService.login(userName, pwd);
				req.getSession(true).setAttribute("userInfo", u);
			}
		}
		
		
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

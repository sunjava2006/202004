package com.thzhima.blog.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.removeAttribute("userInfo"); // ��Session��ɾ��ָ�����ԡ�
		session.invalidate(); // ֱ���ûỰʧЧ��
		
		Cookie c = new Cookie("userName", null);
    	Cookie c2 = new Cookie("pwd", null);
    	c.setMaxAge(0);
    	c2.setMaxAge(0);
    	
    	// Ϊ��Ӧ����cookie
    	response.addCookie(c);
    	response.addCookie(c2);
		response.sendRedirect("/");
	}

}

package com.thzhima.blog.controller.blog;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thzhima.blog.bean.Article;
import com.thzhima.blog.bean.Blog;
import com.thzhima.blog.bean.User;
import com.thzhima.blog.service.ArticleService;


@WebServlet("/publish")
public class PublishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(true);
		Object o = session.getAttribute("userInfo");
		if(null != o) {
			User u = (User) o;
			Blog b = u.getBlog();
			if(null !=  b) {
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				
				ArticleService.publish(new Article(null, b.getBlogID(), title, content, null));// ��������
				response.sendRedirect("/showBlog?blogID="+b.getBlogID());
			}
		}else {
			response.sendRedirect("/Login.jsp");
		}
		
		
		
	}

}

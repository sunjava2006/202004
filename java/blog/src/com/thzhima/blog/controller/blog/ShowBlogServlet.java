package com.thzhima.blog.controller.blog;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thzhima.blog.bean.Blog;
import com.thzhima.blog.service.BlogService;


@WebServlet("/showBlog")
public class ShowBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("blogID");
		int id = Integer.parseInt(sid);
		
        Blog b = BlogService.selectByID(id);
        
        request.setAttribute("blogInfo", b);
        
        request.getRequestDispatcher("/Blog.jsp").forward(request, response);
        
        
	}

}

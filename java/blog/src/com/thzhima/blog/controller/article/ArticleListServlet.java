package com.thzhima.blog.controller.article;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thzhima.blog.bean.Article;
import com.thzhima.blog.service.ArticleService;


@WebServlet("/articleList")
public class ArticleListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page = Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("size"));
		int blogID = Integer.parseInt(request.getParameter("blogID"));
		
		List<Article> list = ArticleService.listByPage(page, size, blogID);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/ArticleList.jsp").forward(request, response);
		
	}

}

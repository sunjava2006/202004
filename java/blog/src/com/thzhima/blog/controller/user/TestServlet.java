package com.thzhima.blog.controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * request.setAttribute("key", "value");//在一次请求中，不同的服务单元之间传递共享数据。
		 * request.setCharacterEncoding("utf-8"); // 为请求设置一个字符集。
		 * 
		 * // request对象是表示用户发送的http请求的对象。
		 * 
		 * // 获取与用户有关的信息 System.out.println(request.getRemoteAddr()); // 远程（客户端）地址
		 * System.out.println(request.getRemoteHost()); // 远程（客户端）主机名
		 * System.out.println(request.getRemotePort()); // 客户端端口
		 * System.err.println("================================="); // 请求中与服务器有关信息
		 * System.err.println(request.getServerName()); // 服务器名
		 * System.out.println(request.getServerPort());
		 * System.out.println(request.getServletPath());
		 * System.out.println(request.getContextPath()); // web应用路径 // 请求url相关
		 * System.out.println("-----------------------------------------------");
		 * System.out.println(request.getQueryString()); // url中?后面的参数。
		 * System.out.println(request.getRequestURL()); // url
		 * System.out.println(request.getRequestURI());
		 * 
		 * // 请求协议有关 System.out.println("************************************");
		 * System.out.println(request.getProtocol()); // 请求协议
		 * System.out.println(request.getMethod()); // 方法
		 * 
		 * System.out.println(request.getHeader("User-Agent"));
		 * 
		 * Enumeration<String> headers = request.getHeaderNames();
		 * while(headers.hasMoreElements()) { String h = headers.nextElement();
		 * 
		 * System.out.println(h + "=" + request.getHeader(h)); }
		 * 
		 */

		
		HttpSession session = request.getSession(true);
		System.out.println(session.isNew());
		
		long timelong = session.getLastAccessedTime();
		System.out.println(new Date(timelong));
		
		// 设置响应头
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Content-Type", "application/json;charset=UTF-8");

		// 设置响应的字符集编码
		System.out.println(response.getCharacterEncoding());
		response.setCharacterEncoding("utf-8");

		// 响应内容
        String json = "{\"name\": \"王瑞\"}";
        
		// 获取输出流，直接输出
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		// 重定向
//		response.sendRedirect("http://www.qq.com");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

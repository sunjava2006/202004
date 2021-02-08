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
		 * request.setAttribute("key", "value");//��һ�������У���ͬ�ķ���Ԫ֮�䴫�ݹ������ݡ�
		 * request.setCharacterEncoding("utf-8"); // Ϊ��������һ���ַ�����
		 * 
		 * // request�����Ǳ�ʾ�û����͵�http����Ķ���
		 * 
		 * // ��ȡ���û��йص���Ϣ System.out.println(request.getRemoteAddr()); // Զ�̣��ͻ��ˣ���ַ
		 * System.out.println(request.getRemoteHost()); // Զ�̣��ͻ��ˣ�������
		 * System.out.println(request.getRemotePort()); // �ͻ��˶˿�
		 * System.err.println("================================="); // ��������������й���Ϣ
		 * System.err.println(request.getServerName()); // ��������
		 * System.out.println(request.getServerPort());
		 * System.out.println(request.getServletPath());
		 * System.out.println(request.getContextPath()); // webӦ��·�� // ����url���
		 * System.out.println("-----------------------------------------------");
		 * System.out.println(request.getQueryString()); // url��?����Ĳ�����
		 * System.out.println(request.getRequestURL()); // url
		 * System.out.println(request.getRequestURI());
		 * 
		 * // ����Э���й� System.out.println("************************************");
		 * System.out.println(request.getProtocol()); // ����Э��
		 * System.out.println(request.getMethod()); // ����
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
		
		// ������Ӧͷ
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Content-Type", "application/json;charset=UTF-8");

		// ������Ӧ���ַ�������
		System.out.println(response.getCharacterEncoding());
		response.setCharacterEncoding("utf-8");

		// ��Ӧ����
        String json = "{\"name\": \"����\"}";
        
		// ��ȡ�������ֱ�����
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		// �ض���
//		response.sendRedirect("http://www.qq.com");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.thzhima.blog.controller.user;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thzhima.blog.bean.User;
import com.thzhima.blog.service.UserService;

@WebServlet(value="/login", initParams = {@WebInitParam(name = "charset", value = "utf-8")} )
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String charset;

	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(this.charset);

		HttpSession session = req.getSession(true);
		Object o = session.getAttribute("code");
		if (o != null) {
			String sessionCode = (String) o;
			String code = req.getParameter("code");
			if (sessionCode.equalsIgnoreCase(code)) { // ��֤����ȡ�
				
				String userName = req.getParameter("userName");
				String pwd = req.getParameter("pwd");
				
				User u = null;
				try {
					u = UserService.login(userName, pwd);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(u != null) { // ��¼�ɹ��� ���û���Ϣ����Session�С�
				    session.setAttribute("userInfo", u);
				    
				    // �Ƿ�Ҫ���¼
				    String auto = req.getParameter("autoLogin"); 
				    if("on".equals(auto)) {
				    	Cookie c = new Cookie("userName", userName);
				    	Cookie c2 = new Cookie("pwd", pwd);
				    	c.setMaxAge(10*24*3600);
				    	c2.setMaxAge(10*24*3600);
				    	
				    	// Ϊ��Ӧ����cookie
				    	resp.addCookie(c);
				    	resp.addCookie(c2);
				    	
				    }
				    
				    resp.sendRedirect("/");
				}else { // ��¼ʧ��
					req.setAttribute("msg", "�û��������벻��ȷ");
					req.getRequestDispatcher("/Login.jsp").forward(req, resp);
				}
						
				

			} else {
				req.setAttribute("msg", "��֤�벻��ȷ");
				req.getRequestDispatcher("/Login.jsp").forward(req, resp);
			}
		} else {
			resp.sendRedirect("/Login.jsp");
		}

	}

}

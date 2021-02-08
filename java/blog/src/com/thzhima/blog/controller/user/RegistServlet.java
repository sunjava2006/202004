package com.thzhima.blog.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thzhima.blog.service.UserService;

@WebServlet(urlPatterns = "/regist", 
            loadOnStartup = 1, 
            initParams = {@WebInitParam(name = "charset", value = "utf-8")})
public class RegistServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(true); // ��ȡsession,û�н�һ������ֹ������һ��nullPointException.
		Object o = session.getAttribute("code");  // ȡ��Reg.jsp����Session�е���֤�롣
		
		if(o != null) {
			String sessionCode = (String)o;
			String code = request.getParameter("code");
			if(sessionCode.equalsIgnoreCase(code)) {
				// ��֤��ͨ��
				String userName = request.getParameter("userName");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");
				String question = request.getParameter("question");
				String answer = request.getParameter("answer");
				
				
				boolean ok = UserService.regist(userName, pwd, email, question, answer);
				
				if(ok) { // ע��ɹ�
					request.getRequestDispatcher("/RegOk.jsp").forward(request, response);
				}else {
					// ע��ʧ�ܣ�����ת����¼ҳ�棬����ʾ��������ʾ��Ϣ��
					request.setAttribute("msg", "ע��ʧ�ܣ������ԡ�");
					request.getRequestDispatcher("/Reg.jsp").forward(request, response);
				}
				
				
			}else {
				// ��֤�벻ͨ��������ת����¼ҳ�棬����ʾ��������ʾ��Ϣ��
				request.setAttribute("msg", "��֤�벻��ȷ");
				request.getRequestDispatcher("/Reg.jsp").forward(request, response);
			}
			
		}else {
			response.sendRedirect("/Reg.jsp");
		}
		
	}
	
	
	

	


}

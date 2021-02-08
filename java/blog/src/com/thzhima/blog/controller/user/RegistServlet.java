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
		HttpSession session = request.getSession(true); // 获取session,没有建一个。防止下面这一步nullPointException.
		Object o = session.getAttribute("code");  // 取出Reg.jsp放入Session中的验证码。
		
		if(o != null) {
			String sessionCode = (String)o;
			String code = request.getParameter("code");
			if(sessionCode.equalsIgnoreCase(code)) {
				// 验证码通过
				String userName = request.getParameter("userName");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");
				String question = request.getParameter("question");
				String answer = request.getParameter("answer");
				
				
				boolean ok = UserService.regist(userName, pwd, email, question, answer);
				
				if(ok) { // 注册成功
					request.getRequestDispatcher("/RegOk.jsp").forward(request, response);
				}else {
					// 注册失败，重新转到登录页面，并显示给出的提示信息。
					request.setAttribute("msg", "注册失败，请重试。");
					request.getRequestDispatcher("/Reg.jsp").forward(request, response);
				}
				
				
			}else {
				// 验证码不通过，重新转到登录页面，并显示给出的提示信息。
				request.setAttribute("msg", "验证码不正确");
				request.getRequestDispatcher("/Reg.jsp").forward(request, response);
			}
			
		}else {
			response.sendRedirect("/Reg.jsp");
		}
		
	}
	
	
	

	


}

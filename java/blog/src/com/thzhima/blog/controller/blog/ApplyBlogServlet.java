package com.thzhima.blog.controller.blog;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.thzhima.blog.bean.Blog;
import com.thzhima.blog.bean.User;
import com.thzhima.blog.controller.StartupListener;
import com.thzhima.blog.service.BlogService;

@MultipartConfig()
@WebServlet("/apply")
public class ApplyBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
        HttpSession session = request.getSession(true);
        Object o = session.getAttribute("userInfo");
		if(o != null) {
			User u = (User) o;
		
			
			String blogName = request.getParameter("blogName");
//			blogName = new String(blogName.getBytes("iso-8859-1"), "utf-8");
			
			String nickName = request.getParameter("nickName");
//			nickName = new String(nickName.getBytes("iso-8859-1"), "utf-8");
			
			String description = request.getParameter("description");
//			description = new String(description.getBytes("iso-8859-1"), "utf-8");
			
			System.out.println(blogName+nickName+description);
			
			Part p = request.getPart("photo");
			String fileName = p.getSubmittedFileName();
//			fileName = new String(fileName.getBytes("gbk"), "utf-8");
			int at = fileName.lastIndexOf(".");
			
			// Ϊ�ļ�ȡһ���µ�����
			String newName = null;
			long pre = System.currentTimeMillis();
			if(-1 != at) {
				String sux = fileName.substring(at);
				newName = pre + sux;
			}else {
				newName = String.valueOf(pre);
			}

			System.out.println(fileName);
		
			ServletContext application = this.getServletContext(); // application����
//			String path = application.getRealPath("/upload");  // ��ȡ����·����
			String path = (String) application.getAttribute(StartupListener.UPLOAD_PATH);
			System.out.println(path);
			
			// ����
			p.write(path+"/"+newName);
			
			// д�����ݿ���
			Blog b  = BlogService.apply(new Blog(null, blogName, nickName,newName, description, u.getUserID()));
			
			u.setBlog(b); // �����û��ĵ�¼��Ϣ�У����������blog��
			
			
			// ת���ҵĲ���ҳ�档ת����
			response.sendRedirect("/showBlog?blogID="+b.getBlogID());
			
			
		}else {// �Ự���Ѿ�û���û���Ϣ
			response.sendRedirect("/Login.jsp");
		}
		
		
		
				
		
	}

}

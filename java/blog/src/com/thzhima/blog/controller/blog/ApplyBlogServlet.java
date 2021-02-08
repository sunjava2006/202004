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
			
			// 为文件取一个新的名字
			String newName = null;
			long pre = System.currentTimeMillis();
			if(-1 != at) {
				String sux = fileName.substring(at);
				newName = pre + sux;
			}else {
				newName = String.valueOf(pre);
			}

			System.out.println(fileName);
		
			ServletContext application = this.getServletContext(); // application对象
//			String path = application.getRealPath("/upload");  // 获取物理路径。
			String path = (String) application.getAttribute(StartupListener.UPLOAD_PATH);
			System.out.println(path);
			
			// 保存
			p.write(path+"/"+newName);
			
			// 写入数据库中
			Blog b  = BlogService.apply(new Blog(null, blogName, nickName,newName, description, u.getUserID()));
			
			u.setBlog(b); // 设置用户的登录信息中，包含申请的blog。
			
			
			// 转向我的博客页面。转发到
			response.sendRedirect("/showBlog?blogID="+b.getBlogID());
			
			
		}else {// 会话中已经没有用户信息
			response.sendRedirect("/Login.jsp");
		}
		
		
		
				
		
	}

}

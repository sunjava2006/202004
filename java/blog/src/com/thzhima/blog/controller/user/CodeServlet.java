package com.thzhima.blog.controller.user;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CodeServlet
 */
@WebServlet("/Code")
public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedImage img = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 100, 30);
		
		
		
		String code  =  String.valueOf((int)(Math.random()*10000));
		
		HttpSession session = request.getSession(true);
		session.setAttribute("code", code); // 将验证加入到用户的Session中。
		
		
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 96, 28);
		g.drawString(code, 10, 20);
		g.setColor(Color.RED);
		g.drawLine(0, 0, 98, 28);
		
		ImageIO.write(img, "jpg", response.getOutputStream());
	}

}

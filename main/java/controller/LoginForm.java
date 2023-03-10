package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login-form")
public class LoginForm extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("trang3.html").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("por");req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		PrintWriter pr = resp.getWriter();
		
		if(username.equals("root") && password.equals("root")) {
			String msg = "success";
			Cookie c = new Cookie("msg", msg);
			c.setMaxAge(10);
			resp.addCookie(c);
		}else {
			String msg = "failed";
			Cookie c = new Cookie("msg", msg);
			c.setMaxAge(10);
			resp.addCookie(c);
		}
		resp.sendRedirect("login-form");
	}

}

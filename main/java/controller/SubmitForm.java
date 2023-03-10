package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/submit-form")
public class SubmitForm extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		
		PrintWriter pr = resp.getWriter();
		
		int iage = Integer.parseInt(age);
		if(iage < 15) {
			String msg = "bạn " +  name + " đang dưới độ tuổi lao động";
			pr.println(msg);
		}else if(iage < 64) {
			String msg = "bạn " +  name + " đang trong độ tuổi lao động";
			pr.println(msg);
		}else {
			String msg = "bạn " +  name + " đang ngoài độ tuổi lao động";
			pr.println(msg);
		}
	}
}

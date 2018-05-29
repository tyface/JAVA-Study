package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}
	
	private String mainId = "가나";
	private String mainPw = "123";
	
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		HttpSession session = req.getSession();
		String url = "";
		// PrintWriter pw1 = resp.getWriter();
		// pw1.write("<script> alert('123');</script>");

		if (!mainId.equals(userId)) {
			url = "04loginForm.jsp";
		} else if (!mainPw.equals(userPw)) {
			url = "04loginForm.jsp";
		} else {
			session.setAttribute("userId", userId);
			url = "main";
		}
		
		resp.sendRedirect(url);
	}

}

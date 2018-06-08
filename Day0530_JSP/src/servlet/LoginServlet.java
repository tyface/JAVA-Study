package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		Cookie cookie;
		String url = "";
		// PrintWriter pw1 = resp.getWriter();
		// pw1.write("<script> alert('123');</script>");

		if (!mainId.equals(userId)) {
			url = "02loginForm.jsp";
		} else if (!mainPw.equals(userPw)) {
			url = "02loginForm.jsp";
		} else {
			cookie = new Cookie("userId",userId);
			resp.addCookie(cookie);
			url = "main";
		}
		resp.sendRedirect(url);
	}

}

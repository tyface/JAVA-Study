package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Board;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {

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
	
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		String content = req.getParameter("content");
		
		Board board = new Board(title, name, email, pass, content);
		
		
		RequestDispatcher dispatcher
		= req.getRequestDispatcher("07boardInfo.jsp");
		req.setAttribute("board", board);
		dispatcher.forward(req, resp);
	}
}

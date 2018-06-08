package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardViewAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDao dao = BoardDaoImp.getInstance();
		String num = req.getParameter("num");
		
		dao.updateReadCount(num);
		Board result = dao.selectOne(num);
		
		req.setAttribute("board", result);
		req.getRequestDispatcher("jsp/boardView.jsp").forward(req, resp);
		
	}

}

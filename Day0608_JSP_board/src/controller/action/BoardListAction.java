package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardListAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">Board List");
		
		BoardDao dao = BoardDaoImp.getInstance();
		List<Board> boardList = dao.selectAll();
		
		req.setAttribute("boardList", boardList);
		req.getRequestDispatcher("jsp/boardList.jsp").forward(req, resp);
	}

}

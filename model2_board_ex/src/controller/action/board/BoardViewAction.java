package controller.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String boardIdx = req.getParameter("board_idx");
		BoardDao boardDao = BoardDaoImp.getInstance();
		Board board = boardDao.selectOne(boardIdx);
		boardDao.updateReadCount(boardIdx);
		req.setAttribute("board", board);
		req.getRequestDispatcher("jsp/board_view.jsp").forward(req, resp);

	}

}

package controller.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import dao.BoardDao;
import dao.BoardDaoImp;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String boardIdx = req.getParameter("board_idx");

		BoardDao boardDao = BoardDaoImp.getInstance();

		String msg, url, comm;

		if (boardDao.deleteBoard(boardIdx) > 0) {
			msg = "삭제 완료 되었습니다.";
			url = "board";
			comm = "list";
		} else {
			msg = "삭제 실패 되었습니다.";
			url = "board";
			comm = "view";
		}

		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		req.setAttribute("comm", comm);
		req.getRequestDispatcher("jsp/result.jsp").forward(req, resp);

	}

}

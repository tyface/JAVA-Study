package controller.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String boardIdx = req.getParameter("board_idx");
		String title = req.getParameter("title");
		String boardPw = req.getParameter("board_pw");
		String content = req.getParameter("content");

		BoardDao boardDao = BoardDaoImp.getInstance();

		Board board = new Board();
		

		board.setBoardIdx(Integer.parseInt(boardIdx));
		board.setTitle(title);
		board.setBoardPw(boardPw);
		board.setContent(content);
		
		String msg, url, comm;

		if (boardDao.updateBoard(board) > 0) {
			msg = "수정이 완료 되었습니다.";
			url = "board";
			comm = "view";
			comm = comm + "&board_idx=" + boardIdx;
		} else {
			msg = "수정이 실패 되었습니다.";
			url = "board";
			comm = "updte";
		}

		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		req.setAttribute("comm", comm);
		req.getRequestDispatcher("jsp/result.jsp").forward(req, resp);

	}

}

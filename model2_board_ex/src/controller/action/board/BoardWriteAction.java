package controller.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;
import model.Member;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		BoardDao boardDao = BoardDaoImp.getInstance();

		Board board = new Board();
		Member member = (Member) req.getSession().getAttribute("member");

		board.setTitle(title);
		board.setContent(content);
		board.setUserId(member.getUserId());
		board.setUserIdx(member.getUserIdx());
		
		String msg, url, comm;

		if (boardDao.insertBoard(board) > 0) {
			msg = "글쓰기가 완료 되었습니다.";
			url = "board";
			comm = "list";
		} else {
			msg = "글쓰기가 실패 되었습니다.";
			url = "board";
			comm = "write-form";
		}

		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		req.setAttribute("comm", comm);
		req.getRequestDispatcher("jsp/result.jsp").forward(req, resp);

	}

}

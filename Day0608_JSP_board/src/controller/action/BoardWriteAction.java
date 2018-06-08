package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDao dao = BoardDaoImp.getInstance();
		Board board = new Board();

		board.setTitle(req.getParameter("title"));
		board.setName(req.getParameter("name"));
		board.setPass(req.getParameter("password"));
		board.setEmail(req.getParameter("email"));
		board.setContent(req.getParameter("content"));

		int result = dao.insertBoard(board);

		String msg = "";
		String url = "";

		if (result > 0) {
			msg = "게시글 등록 완료.";
			url = "board_list";
		} else {
			msg = "게시글 등록 실패.";
			url = "board_write_form";
		}

		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		req.getRequestDispatcher("jsp/result.jsp").forward(req, resp);

	}

}

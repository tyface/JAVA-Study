package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDao dao = BoardDaoImp.getInstance();
		Board board = new Board();
		
		board.setNum(Integer.parseInt(req.getParameter("num")));
		board.setTitle(req.getParameter("title"));
		board.setName(req.getParameter("name"));
		board.setPass(req.getParameter("password"));
		board.setEmail(req.getParameter("email"));
		board.setContent(req.getParameter("content"));

		int result = dao.updateBoard(board);

		String msg = "";
		String url = "";

		if (result > 0) {
			msg = "게시글 수정 완료.";
			url = "board_list";
		} else {
			msg = "게시글 수정 실패.";
			url = "board_update_form";
		}

		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		req.getRequestDispatcher("jsp/result.jsp").forward(req, resp);
	}

}

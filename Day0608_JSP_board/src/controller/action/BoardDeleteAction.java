package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BoardDao dao = BoardDaoImp.getInstance();

		String num = req.getParameter("num");
		int result = dao.deleteBoard(num);

		String msg;
		if (result > 0) {
			msg = "게시글 삭제 완료.";
		} else {
			msg = "게시글 삭제 실패.";
		}

		req.setAttribute("msg", msg);
		req.setAttribute("url", "board_list");
		req.getRequestDispatcher("jsp/result.jsp").forward(req, resp);

	}

}

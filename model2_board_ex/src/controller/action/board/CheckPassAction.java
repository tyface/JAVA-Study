//package controller.action.board;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import controller.action.Action;
//import dao.BoardDao;
//import dao.BoardDaoImp;
//import model.Board;
//
//public class CheckPassAction implements Action {
//
//	@Override
//	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String pass = req.getParameter("password");
//		String boardIdx = req.getParameter("board_idx");
//		String url = "";
//		
//		BoardDao boardDao = BoardDaoImp.getInstance();
//		Board board = boardDao.selectOne(boardIdx);
//
//		if(board.getBoardPw().equals(pass)) {
//			req.setAttribute("board", board);
//			url = "jsp/check_success.jsp";
//		}else {
//			req.setAttribute("msg", "비밀번호가 일치하지 않습니다.");
////			url = "board?command=check-pass-form&board_idx=";
//			url = "jsp/board_check_pass.jsp";
//		}
//		
//		req.getRequestDispatcher(url).forward(req, resp);
//
//	}
//
//}

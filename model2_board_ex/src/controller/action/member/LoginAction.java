package controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.action.Action;
import dao.MemberDao;
import dao.MemberDaoImp;
import model.Member;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userId = req.getParameter("user_id");
		String userPw = req.getParameter("user_pw");
		String msg = "";
		String comm = "main";
		String url = "main";

		MemberDao memberDao = MemberDaoImp.getInstance();
		Member member = memberDao.selectId(userId);

		HttpSession session = req.getSession();

		if (member != null) {
			if (member.getUserPw().equals(userPw)) {
				member.setUserPw(""); // 비밀번호 유출을 막기위해 비밀번호는 세션에 담지않는다.
				session.setAttribute("member", member);
			} else {
				msg = "비밀번호가 일치하지 않습니다.";
			}
		} else {
			msg = "아이디가 존재하지 않습니다.";
		}
		
		req.setAttribute("msg", msg);
		req.setAttribute("comm", comm);
		req.setAttribute("url", url);
		req.getRequestDispatcher("jsp/result.jsp").forward(req, resp);

	}

}

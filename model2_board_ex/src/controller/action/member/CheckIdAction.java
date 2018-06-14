package controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import dao.MemberDao;
import dao.MemberDaoImp;
import model.Member;

public class CheckIdAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("user_id");
		MemberDao memberDao = MemberDaoImp.getInstance();
		Member member = memberDao.selectId(userId);

		if (member == null) {
			resp.getWriter().print(true);
		} else {
			resp.getWriter().print(false);
		}
	}
}

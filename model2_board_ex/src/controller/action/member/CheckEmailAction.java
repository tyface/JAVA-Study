package controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import dao.MemberDao;
import dao.MemberDaoImp;

public class CheckEmailAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");

		MemberDao memberDao = MemberDaoImp.getInstance();
		boolean emailDup = memberDao.selectEmail(email);

		resp.getWriter().print(emailDup);
	}
}

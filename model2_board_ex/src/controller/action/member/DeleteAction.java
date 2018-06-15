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

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String msg, url, comm;
		MemberDao memberDao = MemberDaoImp.getInstance();
		HttpSession session = req.getSession();

		Member member = (Member) session.getAttribute("member");

		if (memberDao.deleteMember(member.getUserIdx()) > 0) {
			msg = "회원삭제 완료";
			url = "main";
			comm = "main";
			session.invalidate();
		} else {
			msg = "회원삭제 실패";
			url = "member";
			comm = "modify-form";
		}
		
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		req.setAttribute("comm", comm);
		req.getRequestDispatcher("jsp/result.jsp").forward(req, resp);

	}

}

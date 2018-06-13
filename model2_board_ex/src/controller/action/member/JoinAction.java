package controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import dao.MemberDao;
import dao.MemberDaoImp;
import model.Member;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("user_id");
		String userPw = req.getParameter("user_pw");
		String userName = req.getParameter("user_name");
		String email = req.getParameter("email");
		
		Member insertMember = new Member();
		insertMember.setUserId(userId);
		insertMember.setUserPw(userPw);
		insertMember.setUserName(userName);
		insertMember.setEmail(email);
		
		String url = "main";
		String comm = "main";

		MemberDao memberDao = MemberDaoImp.getInstance();
		Member tempMember = memberDao.selectId(userId);

		//유효성 검사 로직
		if (tempMember == null) {
			if (memberDao.selectEmail(email)) {
				url = "member";
				comm = "join-form";
				req.setAttribute("msg", "이메일이 중복 되었습니다."); // 회원가입하기전에 검사하기때문에 정상적인 루트로는 접근되지 않음
			} else {
				//아이디와 이메일 확인후 insert
				if(memberDao.insertMember(insertMember) > 0) {
					req.setAttribute("msg", "회원가입 완료.");
				}else {
					req.setAttribute("msg", "회원가입 오류.");
				}
			}
		} else {
			url = "member";
			comm = "join-form";
			req.setAttribute("msg", "아이디가 중복 되었습니다."); // 회원가입하기전에 검사하기때문에 정상적인 루트로는 접근되지 않음
		}//end 유효성검사
		
		req.setAttribute("url", url);
		req.setAttribute("comm", comm);
		req.getRequestDispatcher("jsp/result.jsp").forward(req, resp);

	}

}

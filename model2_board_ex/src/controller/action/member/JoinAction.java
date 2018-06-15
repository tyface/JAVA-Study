package controller.action.member;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import commons.Commons;
import controller.action.Action;
import dao.MemberDao;
import dao.MemberDaoImp;
import model.Member;

@MultipartConfig(maxFileSize = 1024 * 1024 * 2, location = "c:\\test")
public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Member모델 셋팅
		String userId = req.getParameter("user_id");
		String userPw = req.getParameter("user_pw");
		String userName = req.getParameter("user_name");
		String email = req.getParameter("email");
		String profile = saveFilename(req, resp);
		Member member = new Member();
		member.setUserId(userId);
		member.setUserPw(userPw);
		member.setUserName(userName);
		member.setEmail(email);
		member.setProfile(profile);
		
		String url = "main";
		String comm = "main";

		MemberDao memberDao = MemberDaoImp.getInstance();
		Member tempMember = memberDao.selectId(userId);
		
		// 유효성 검사 로직
		if (tempMember == null) {
			if (memberDao.selectEmail(email)) {
				url = "member";
				comm = "join-form";
				req.setAttribute("msg", "이메일이 중복 되었습니다."); // 회원가입하기전에 검사하기때문에 정상적인 루트로는 접근되지 않음
			} else {
				// 아이디와 이메일 확인후 insert
				if (memberDao.insertMember(member) > 0) {
					req.setAttribute("msg", "회원가입 완료.");
				} else {
					req.setAttribute("msg", "회원가입 오류.");
				}
			}
		} else {
			url = "member";
			comm = "join-form";
			req.setAttribute("msg", "아이디가 중복 되었습니다."); // 회원가입하기전에 검사하기때문에 정상적인 루트로는 접근되지 않음
		} // end 유효성검사

		req.setAttribute("url", url);
		req.setAttribute("comm", comm);
		req.getRequestDispatcher("jsp/result.jsp").forward(req, resp);

	}

	//리퀘스트로 받은 파일정보로 파일을 저장시키고 UUID를 삽입한 파일 이름을 반환하는 메서드
	private String saveFilename(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파일들은 파트들로 분리되서 전송이 되기 때문에 파일들을 모두 모아서 파일로 만들어 저장
		Collection<Part> parts = req.getParts();
		String saveName = null;
		
		for (Part part : parts) {
			if (part.getHeader("Content-Disposition").contains("filename=")) {
				String fileName = part.getSubmittedFileName();
				UUID uuid = UUID.randomUUID();

				saveName = uuid.toString() + "_" + fileName;

				if (part.getSize() > 0) {
					part.write(Commons.DEFAULT_FILE_PASS + saveName);
				}
			}
		}

		return saveName;
	}
}

package controller.action.member;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import commons.Commons;
import controller.action.Action;
import dao.MemberDao;
import dao.MemberDaoImp;
import model.Member;

@MultipartConfig(maxFileSize = 1024 * 1024 * 2, location = "c:\\test")
public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Member모델 셋팅
		int userIdx = Integer.parseInt(req.getParameter("user_idx"));
		String userPw = req.getParameter("user_pw");
		String userName = req.getParameter("user_name");
		String email = req.getParameter("email");
		String profile = saveFilename(req, resp);
		Member member = new Member();
		member.setUserIdx(userIdx);
		member.setUserPw(userPw);
		member.setUserName(userName);
		member.setEmail(email);
		member.setProfile(profile);

		if (profile != null) {
			member.setProfile(profile);
		}

		String msg, url, comm;

		MemberDao memberDao = MemberDaoImp.getInstance();
		int rowCount = memberDao.updateMember(member);

		if (rowCount > 0) {
			// 회원정보수정이 정상처리 됬다면 세션도 재설정
			HttpSession seesion = req.getSession();
			member = memberDao.selectOne(req.getParameter("user_idx"));
			seesion.setAttribute("member", member);

			msg = "회원정보 수정 완료.";
			url = "main";
			comm = "main";
		} else {
			msg = "회원정보 수정 실패.";
			url = "member";
			comm = "modify-form";
		}

		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		req.setAttribute("comm", comm);
		req.getRequestDispatcher("jsp/result.jsp").forward(req, resp);

	}

	// 리퀘스트로 받은 파일정보로 파일을 저장시키고 UUID를 삽입한 파일 이름을 반환하는 메서드
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

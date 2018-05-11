package mamber;

import java.util.List;

public class MemberService {
	private MemberDao dao;

	public MemberService(MemberDao dao) {
		this.dao = dao;

	}

	public void setDao(MemberDao dao) {
		this.dao = dao;

	}

	public boolean login(String id, String pw) {
		MemberVo member = dao.selectOne(id);

		if (member != null && member.getPw().equals(pw)) {
			System.out.println("로그인 성공");
			return true;
		}

		System.out.println("로그인 실패");
		return false;
	}

	public boolean join(MemberVo vo) {
		MemberVo member = dao.selectOne(vo.getId());

		if (member != null && checkEmail(vo.getEmail())) {
			int rsCount = dao.insertMember(vo);
			
			if (rsCount == 1) {
				System.out.println("회원가입 성공");
				return true;
			}
		}

		System.out.println("회원가입 실패");
		return false;
	}

	public boolean checkEmail(String email) {
		List<MemberVo> memberList = dao.selectAll();

		for (MemberVo member : memberList) {
			if (member.getEmail().equals(email)) {
				return false;
			}
		}

		return true;
	}

}

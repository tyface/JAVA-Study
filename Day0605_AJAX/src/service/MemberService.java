package service;

import java.util.List;

import dao.MemberDao;
import model.Member;

public class MemberService {
	// Dao 객체를 멤버로 가지면서 사용
	MemberDao dao;

	private static MemberService INSTANCE;

	private MemberService() {
		dao = MemberDao.getInstance();
	}

	public static MemberService getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new MemberService();
		}
		return INSTANCE;
	}
	
	public boolean join(Member member) {
		
		if (dao.selectOne(member.getId()) == null && dao.selectEmail(member.getEmail())==null) {
			dao.insertMember(member);
			return true;
		}
		return false;
	}

	public boolean login(String id, String pw) {
		Member member = dao.selectOne(id);
		
		if (member != null && member.getPw().equals(pw)) {
			return true;
		}
		return false;
	}

	public boolean modify(Member member) {
		
		if(dao.updateMember(member)>0) {
			return true;
		}
		return false;
	}
	
	public Member getMember(String id) {
		return dao.selectOne(id);
	}
	
	public boolean deleteMember(String id) {

		if(dao.deleteMember(id)>0) {
			return true;
		}
		return false;
	}
	public List<Member> getMemberList() {
		return dao.selectAll();
	}

	public boolean checkId(String id) {
		if(dao.selectOne(id)==null) {
			return true;
		}
		return false;
	}
	public boolean checkEmail(String email) {
		if(dao.selectEmail(email)==null) {
			return true;
		}
		return false;
	}
}

package service;

import java.util.List;

import model.Member;

public interface MemberService {

	public List<Member> getAllMember();
	public Member getMemberById(String id);
	public boolean insertMember(Member member);
	public boolean updateMember(Member member);
	public boolean join(Member member);
}

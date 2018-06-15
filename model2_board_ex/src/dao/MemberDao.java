package dao;

import java.util.List;

import model.Member;

public interface MemberDao {

	public int insertMember(Member member);

	public Member selectOne(String userIdx);

	public boolean selectEmail(String email);

	public Member selectId(String userId);

	public List<Member> selectAll();

	public int updateMember(Member member);

	public int deleteMember(int userIdx);

}

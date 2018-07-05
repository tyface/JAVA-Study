package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
	
	public int insertMember(Member member);
	public int updateMember(Member member);
	public Member selectById(String id);
	public List<Member> selectAll();

}

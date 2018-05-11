package mamber;

import java.util.List;

public interface IMemberDao {

	public int insertMember(MemberVo member);

	public int updateMember(MemberVo member);

	public int deleteMember(int num);

	public MemberVo selectOne(int num);
	
	public MemberVo selectOne(String id);

	public List<MemberVo> selectAll();

}

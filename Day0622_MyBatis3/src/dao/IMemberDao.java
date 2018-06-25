package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Member;

public interface IMemberDao {

	@Insert("INSERT INTO member "
			+ "VALUES (member_seq.nextval, #{id}, #{pw}, #{name}, #{email}, sysdate)")
	public int insertMember(Member member);

	@Update("UPDATE member "
			+ "SET id = #{id}, pw = #{pw}, name = #{name}, email = #{email} "
			+ "WHERE num = #{num}")
	public int updateMember(Member member);

	@Delete("DELETE member "
			+ "FROM num = #{num}")
	public int deleteMember(int num);

	@Select("SELECT * "
			+ "FROM  member "
			+ "WHERE num = #{num}")
	public Member selectOne(int num);

	@Select("SELECT * "
			+ "FROM member")
	public List<Member> selectAll();
}

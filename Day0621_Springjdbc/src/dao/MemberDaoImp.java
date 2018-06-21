package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.Member;

public class MemberDaoImp implements MemberDao {
	// 연결생성, 드라이버 로딩, 구문객체 생성, 결과 실행, 예외 처리 : spring - JdbcTemplate
	// sql 작성, 결과 매핑, db 파라미터 작성 : 개발자

	JdbcTemplate jdbcTemplate;

	// 생성자를 통해서 의존성 주입
	public MemberDaoImp(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertMember(Member member) {
		String sql = "insert into member values(member_seq.nextval,?,?,?,?,sysdate)";
		return jdbcTemplate.update(sql, member.getId(), member.getPw(), member.getName(), member.getEmail());
	}

	@Override
	public int updateMember(Member member) {
		String sql = "update member set pw = ?, name = ?, email = ? where id = ?";
		return jdbcTemplate.update(sql, member.getPw(), member.getName(), member.getEmail(), member.getId());
	}

	@Override
	public int deleteMember(String id) {
		String sql = "delete from member where id = ?";
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public Member selectOne(String id) {
		String sql = "select * from member where id = ?";
		return jdbcTemplate.queryForObject(sql, memberMapper, id);
	}

	@Override
	public List<Member> selectAll() {
		String sql = "select * from member";
		return jdbcTemplate.query(sql, memberMapper);
	}

	RowMapper<Member> memberMapper = new RowMapper<Member>() {

		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
			Member member = new Member();
			member.setId(rs.getString("id"));
			member.setPw(rs.getString("pw"));
			member.setName(rs.getString("name"));
			member.setEmail(rs.getString("email"));
			member.setRegDate(rs.getDate("regdate"));
			return member;
		}
	};

}

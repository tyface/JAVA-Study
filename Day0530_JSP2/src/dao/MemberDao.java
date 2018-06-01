package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import commons.Commons;
import model.Member;

public class MemberDao implements IMemberDao {

	Connection conn;

	public int insertMember(Member member) {
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			String sql = "INSERT INTO member VALUES(MEMBER_SEQ.nextval,?,?,?,?,sysdate)";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());

			rowCount = pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCount;
	}

	public int updateMember(Member member) {
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			String sql = "UPDATE member SET pw = ?, name = ?, email = ? where id = ?";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getId());

			rowCount = pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCount;
	}

	public int deleteMember(String id) {
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			String sql = "DELETE FROM member where id = ?";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rowCount = pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCount;
	}
	
	public Member selectOne(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;

		try {
			String sql = "SELECT * FROM member where id = ?";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member();
				member.setId(rs.getString(Commons.Member.ID));
				member.setPw(rs.getString(Commons.Member.PW));
				member.setName(rs.getString(Commons.Member.NAME));
				member.setEmail(rs.getString(Commons.Member.EMAIL));
				member.setRegDate(rs.getTimestamp(Commons.Member.REG_DATE));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
	}

	public List<Member> selectAll() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Member> memberList = new ArrayList<Member>();
		try {
			String sql = "SELECT * FROM member order by num";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Member member = new Member();

				member.setId(rs.getString(Commons.Member.ID));
				member.setPw(rs.getString(Commons.Member.PW));
				member.setName(rs.getString(Commons.Member.NAME));
				member.setEmail(rs.getString(Commons.Member.EMAIL));
				member.setRegDate(rs.getTimestamp(Commons.Member.REG_DATE));

				memberList.add(member);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberList;
	}

	public String selectEmail(String email) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String rsEmail = null;
		
		try {
			String sql = "SELECT email FROM member where email = ?";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, email);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				rsEmail = rs.getString(Commons.Member.EMAIL);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rsEmail;
	}
}

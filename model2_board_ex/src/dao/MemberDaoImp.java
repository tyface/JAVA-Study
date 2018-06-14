package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import commons.Commons;
import model.Member;

public class MemberDaoImp implements MemberDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private static MemberDaoImp instance;

	private MemberDaoImp() {

	}

	public static MemberDaoImp getInstance() {
		if (instance == null) {
			instance = new MemberDaoImp();
		}
		return instance;
	}

	@Override
	public int insertMember(Member member) {
		int rowCount = 0;

		try {
			String sql = "INSERT INTO ex1_member VALUES(EX1_MEMBER_SEQ.nextval,?,?,?,?,SYSDATE,?)";
			conn = ConnectionProvider.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPw());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getProfile());

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

	@Override
	public Member selectOne(String userIdx) {
		ResultSet rSet = null;
		Member member = null;

		try {
			String sql = "SELECT * FROM ex1_member WHERE user_idx = ?";
			conn = ConnectionProvider.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userIdx);

			rSet = pstmt.executeQuery();

			if (rSet.next()) {
				member = new Member();
				member.setUserIdx(rSet.getInt(Commons.Member.USER_IDX));
				member.setUserId(rSet.getString(Commons.Member.USER_ID));
				member.setUserPw(rSet.getString(Commons.Member.USER_PW));
				member.setUserName(rSet.getString(Commons.Member.USER_NAME));
				member.setEmail(rSet.getString(Commons.Member.EMAIL));
				member.setUserRegDate(rSet.getDate(Commons.Member.USER_REGDATE));
				member.setProfile(rSet.getString(Commons.Member.PROFILE));
			}

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
		return member;
	}

	@Override
	public boolean selectEmail(String email) {
		ResultSet rSet = null;

		try {
			String sql = "SELECT count(email) AS count FROM ex1_member WHERE email = ?";
			conn = ConnectionProvider.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);

			rSet = pstmt.executeQuery();

			if (rSet.next()) {
				int emailCount = rSet.getInt("count");

				if (emailCount > 0) {
					return true;
				}
			}

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
		return false;
	}

	@Override
	public Member selectId(String userId) {
		ResultSet rSet = null;
		Member member = null;

		try {
			String sql = "SELECT * FROM ex1_member WHERE user_id = ?";
			conn = ConnectionProvider.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			rSet = pstmt.executeQuery();

			if (rSet.next()) {
				member = new Member();
				member.setUserIdx(rSet.getInt(Commons.Member.USER_IDX));
				member.setUserId(rSet.getString(Commons.Member.USER_ID));
				member.setUserPw(rSet.getString(Commons.Member.USER_PW));
				member.setUserName(rSet.getString(Commons.Member.USER_NAME));
				member.setEmail(rSet.getString(Commons.Member.EMAIL));
				member.setUserRegDate(rSet.getDate(Commons.Member.USER_REGDATE));
				member.setProfile(rSet.getString(Commons.Member.PROFILE));
			}

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
		return member;
	}

	@Override
	public List<Member> selectAll() {
		ResultSet rSet = null;
		Member member = null;
		List<Member> memberList = new ArrayList<Member>();

		try {
			String sql = "SELECT * FROM ex1_member ORDER BY user_idx";
			conn = ConnectionProvider.getConnection();

			pstmt = conn.prepareStatement(sql);

			rSet = pstmt.executeQuery();

			while (rSet.next()) {
				member = new Member();
				member.setUserIdx(rSet.getInt(Commons.Member.USER_IDX));
				member.setUserId(rSet.getString(Commons.Member.USER_ID));
				member.setUserPw(rSet.getString(Commons.Member.USER_PW));
				member.setUserName(rSet.getString(Commons.Member.USER_NAME));
				member.setEmail(rSet.getString(Commons.Member.EMAIL));
				member.setUserRegDate(rSet.getDate(Commons.Member.USER_REGDATE));
				member.setProfile(rSet.getString(Commons.Member.PROFILE));

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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberList;
	}

	@Override
	public int updateMember(Member member) {
		int rowCount = 0;
		String profileStr = "";
		try {
			if (member.getProfile() != null) {
				profileStr = ", profile = ?";
			}
			String sql = "UPDATE ex1_member SET user_pw = ?, user_name = ?, email = ?" + profileStr
					+ " where user_idx = ?";
			conn = ConnectionProvider.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserPw());
			pstmt.setString(2, member.getUserName());
			pstmt.setString(3, member.getEmail());

			if (member.getProfile() != null) {
				pstmt.setString(4, member.getProfile());
				pstmt.setInt(5, member.getUserIdx());
			} else {
				pstmt.setInt(4, member.getUserIdx());
			}
			System.out.println(member);
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

	@Override
	public int deleteMember(String userIdx) {
		int rowCount = 0;

		try {
			String sql = "DELETE FROM ex1_member where user_idx = ?";
			conn = ConnectionProvider.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userIdx);

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

}

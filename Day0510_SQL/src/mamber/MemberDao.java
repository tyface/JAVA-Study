package mamber;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import commons.Commons;

public class MemberDao implements IMemberDao {

	Connection conn;

	public MemberVo selectOne(int num) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo vo = new MemberVo();

		try {
			String sql = "SELECT * FROM member where num = ?";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo.setNum(rs.getInt(Commons.Member.NUM));
				vo.setId(rs.getString(Commons.Member.ID));
				vo.setPw(rs.getString(Commons.Member.PW));
				vo.setName(rs.getString(Commons.Member.NAME));
				vo.setEmail(rs.getString(Commons.Member.EMAIL));
				vo.setRegDate(rs.getTimestamp(Commons.Member.REG_DATE));
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
		return vo;
	}

	public MemberVo selectOne(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo vo = new MemberVo();

		try {
			String sql = "SELECT * FROM member where id = ?";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo.setNum(rs.getInt(Commons.Member.NUM));
				vo.setId(rs.getString(Commons.Member.ID));
				vo.setPw(rs.getString(Commons.Member.PW));
				vo.setName(rs.getString(Commons.Member.NAME));
				vo.setEmail(rs.getString(Commons.Member.EMAIL));
				vo.setRegDate(rs.getTimestamp(Commons.Member.REG_DATE));
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
		return vo;
	}

	public List<MemberVo> selectAll() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<MemberVo> voList = new ArrayList<MemberVo>();
		try {
			String sql = "SELECT * FROM member order by num";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVo vo = new MemberVo();

				vo.setNum(rs.getInt(Commons.Member.NUM));
				vo.setId(rs.getString(Commons.Member.ID));
				vo.setPw(rs.getString(Commons.Member.PW));
				vo.setName(rs.getString(Commons.Member.NAME));
				vo.setEmail(rs.getString(Commons.Member.EMAIL));
				vo.setRegDate(rs.getTimestamp(Commons.Member.REG_DATE));

				voList.add(vo);
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
		return voList;
	}

	public int insertMember(MemberVo vo) {
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			String sql = "INSERT INTO member VALUES(MEMBER_SEQ.nextval,?,?,?,?,sysdate)";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());

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

	public int updateMember(MemberVo vo) {
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			String sql = "UPDATE member SET id = ?, pw = ?, name = ?, email = ?, regDate = ? where num = ?";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setTimestamp(5, vo.getRegDate());
			pstmt.setInt(6, vo.getNum());

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

	public int deleteMember(int num) {
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			String sql = "DELETE FROM member where num = ?";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);

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

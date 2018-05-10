package mamber;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {

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
				vo.setNum(rs.getInt(1));
				vo.setId(rs.getString(2));
				vo.setPw(rs.getString(3));
				vo.setName(rs.getString(4));
				vo.setEmail(rs.getString(5));
				vo.setRegDate(rs.getTimestamp(6));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
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
				
				vo.setNum(rs.getInt(1));
				vo.setId(rs.getString(2));
				vo.setPw(rs.getString(3));
				vo.setName(rs.getString(4));
				vo.setEmail(rs.getString(5));
				vo.setRegDate(rs.getTimestamp(6));
				
				voList.add(vo);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return voList;
	}

	public void insertMember(MemberVo vo) {
		PreparedStatement pstmt = null;

		try {
			String sql = "INSERT INTO member VALUES(MEMBER_SEQ.nextval,?,?,?,?,sysdate)";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateMember(MemberVo vo) {
		PreparedStatement pstmt = null;

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

			pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteMember(int num) {
		PreparedStatement pstmt = null;

		try {
			String sql = "DELETE FROM member where num = ?";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);

			pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}

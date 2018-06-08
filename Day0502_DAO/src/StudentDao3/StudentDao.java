package StudentDao3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	private Connection conn;

	public StudentDao() {

	}

	public int insertStudent(StudentVo student) {
		String sql = "insert into student_ex values (?,?,?)";
		PreparedStatement pstmt = null;
		int rsCount = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, student.getSnum());
			pstmt.setString(2, student.getSname());
			pstmt.setInt(3, student.getSgrade());

			rsCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
		return rsCount;
	}

	public int updateStudent(StudentVo student) {
		String sql = "update student_ex set snum = ?, sname = ?, sgrade = ? where snum = ?";
		PreparedStatement pstmt = null;
		int rsCount = 0;

		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, student.getSnum());
			pstmt.setString(2, student.getSname());
			pstmt.setInt(3, student.getSgrade());
			pstmt.setInt(4, student.getSnum());

			rsCount = pstmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
		return rsCount;
	}

	public int deleteStudent(int snum) {
		String sql = "delete from student_ex where snum = ?";
		PreparedStatement pstmt = null;
		int rsCount = 0;
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, snum);

			rsCount = pstmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
		return rsCount;
	}

	public StudentVo seleteOne(int snum) {
		StudentVo vo = new StudentVo();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from student_ex where snum = ?";

		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, snum);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				vo.setSnum(rs.getInt("SNUM"));
				vo.setSname(rs.getString("SNAME"));
				vo.setSgrade(rs.getInt("SGRADE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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

	public List<StudentVo> seleteAll() {
		List<StudentVo> rsList = new ArrayList<StudentVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from student_ex";

		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				StudentVo vo = new StudentVo();

				vo.setSnum(rs.getInt("SNUM"));
				vo.setSname(rs.getString("SNAME"));
				vo.setSgrade(rs.getInt("SGRADE"));

				rsList.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
		return rsList;
	}
}

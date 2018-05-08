package student2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "root";
	private static final String PASSWORD = "0000";
	private Connection conn;

	public StudentDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 완료");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int insertStudent(StudentVo student) {
		String sql = "insert into student_ex values (?,?,?)";
		PreparedStatement pstmt = null;
		int rsCount = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, student.getSnum());
			pstmt.setString(2, student.getSname());
			pstmt.setInt(3, student.getSgrade());

			rsCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, student.getSnum());
			pstmt.setString(2, student.getSname());
			pstmt.setInt(3, student.getSgrade());
			pstmt.setInt(4, student.getSnum());

			rsCount = pstmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, snum);

			rsCount = pstmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, snum);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				vo.setSnum(rs.getInt("SNUM"));
				vo.setSname(rs.getString("SNAME"));
				vo.setSgrade(rs.getInt("SGRADE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	public List<StudentVo> seleteAll() {
		List<StudentVo> rsList = new ArrayList<StudentVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from student_ex";

		try {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rsList;
	}
}

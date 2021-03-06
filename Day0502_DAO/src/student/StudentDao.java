package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "root";
	private static final String PASSWORD = "0000";
	private Connection conn;
	private Statement stmt;

	public StudentDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
			System.out.println("DB연결 완료");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int insertStudent(StudentVo student) {
		String sql = "insert into student_ex values(" + student.getSnum() + ",'" + student.getSname() + "',"
				+ student.getSgrade() + ")";
		int rsCount = 0;
		try {
			stmt = conn.createStatement();
			rsCount = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rsCount;
	}

	public int updateStudent(StudentVo student) {
		String sql = "update student_ex set  snum = " + student.getSnum() + ", sname = '" + student.getSname()
				+ "', sgrade = " + student.getSgrade() + " where snum = " + student.getSnum();
		int rsCount = 0;
		try {
			stmt = conn.createStatement();
			rsCount = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rsCount;
	}

	public int deleteStudent(int snum) {
		String sql = "delete from student_ex where snum = " + snum;
		int rsCount = 0;
		try {
			stmt = conn.createStatement();
			rsCount = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rsCount;
	}

	public StudentVo seleteOne(int snum) {
		StudentVo vo = new StudentVo();
		ResultSet rs = null;
		String sql = "select * from student_ex where snum = " + snum;

		try {
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				vo.setSnum(rs.getInt("SNUM"));
				vo.setSname(rs.getString("SNAME"));
				vo.setSgrade(rs.getInt("SGRADE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public List<StudentVo> seleteAll() {
		List<StudentVo> rsList = new ArrayList<StudentVo>();
		ResultSet rs = null;
		String sql = "select * from student_ex";

		try {
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				StudentVo vo = new StudentVo();

				vo.setSnum(rs.getInt("SNUM"));
				vo.setSname(rs.getString("SNAME"));
				vo.setSgrade(rs.getInt("SGRADE"));

				rsList.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rsList;
	}
}

package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import student.StudentVo;

public class EmployeeDao {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "root";
	private static final String PASSWORD = "0000";
	private Connection conn;

	public EmployeeDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 완료");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public EmployeeVo selectOne(int eNum) { // 직원 번호를 조건으로 직원의 모든 정보를 조회하여 직원 객체 반환
		Statement stmt = null;
		EmployeeVo vo = new EmployeeVo();
		ResultSet rss = null;
		String sql = "select * from employee_ex where enum = " + eNum;

		try {
			stmt = conn.createStatement();
			rss = stmt.executeQuery(sql);

			while (rss.next()) {
				vo.seteNum(rss.getInt("enum"));
				vo.seteName(rss.getString("ename"));
				vo.setDeptno(rss.getInt("deptno"));
				vo.setSalary(rss.getInt("salary"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return vo;
	}

	public List<EmployeeVo> selectAll() { // 모든 직원의 모든 정보를 조회하여 직원 리스트 반환
		Statement stmt = null;
		List<EmployeeVo> rsList = new ArrayList<EmployeeVo>();
		ResultSet rss = null;
		String sql = "select * from employee_ex";

		try {
			stmt = conn.createStatement();
			rss = stmt.executeQuery(sql);

			while (rss.next()) {
				EmployeeVo vo = new EmployeeVo();
				vo.seteNum(rss.getInt("enum"));
				vo.seteName(rss.getString("ename"));
				vo.setDeptno(rss.getInt("deptno"));
				vo.setSalary(rss.getInt("salary"));
				rsList.add(vo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rsList;
	}

	public int deleteEmployee(int eNum) { // 직원번호를 조건으로 직원 삭제
		Statement stmt = null;
		String sql = "delete from employee_ex where enum = " + eNum;
		int rsCount = 0;
		try {
			stmt = conn.createStatement();
			rsCount = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rsCount;
	}

	public int updateEmployee(EmployeeVo vo) { // 직원 번호를 조건으로 직원의 이름,부서번호,월급을 수정
		Statement stmt = null;
		String sql = "update employee_ex set enum = " + vo.geteNum() + ", ename = '" + vo.geteName() + "', deptno = "
				+ vo.getDeptno() + ", salary = " + vo.getSalary() + " where enum = " + vo.geteNum();
		int rsCount = 0;
		try {
			stmt = conn.createStatement();
			rsCount = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rsCount;
	}

	public int insertEmployee(EmployeeVo vo) { // 직원이 가져야할 모든 정보를 포함하여 직원정보 추가
		Statement stmt = null;
		String sql = "insert into employee_ex values(" + vo.geteNum() + ",'" + vo.geteName() + "'," + vo.getDeptno()
				+ ", " + vo.getSalary() + ")";
		int rsCount = 0;
		try {
			stmt = conn.createStatement();
			rsCount = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rsCount;
	}
}

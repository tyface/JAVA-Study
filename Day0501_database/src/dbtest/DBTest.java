package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {
	public static void main(String[] args) {
		// 데이터베이스 프로그래밍 순서
		// 1. 사용하고자 하는 DBMS에 맞는 드라이버 로딩
		// 2. 연결생성(url,uer,password)
		// 3. 구문객체 생성(Statement) : 자바에서 작성한 sql을 DBMS로 전달하는 역할
		// 4. SQL 작성 및 구문객체를 통한 실행
		// 5. 결과처리(데이터가 있으면 경과를 처리, 결과가 없는 질의일 경우 작업X)
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "root";
		String password = "0000";

		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드리업 로딩 성공");

			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");

			stmt = conn.createStatement();
			
//			String sql = "INSERT INTO student_ex VALUES(7,'홍길동',6)";
//			String sql = "update student_ex set snum = 2 where sname = '길동이'";
			String sql = "select * from student_ex";
//			int rowCount = stmt.executeUpdate(sql);
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			System.out.println(rs.getString(1));
		} catch (ClassNotFoundException e) {
			System.out.println("드리업 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL예외 발생");
			e.printStackTrace();
		}

	}
}

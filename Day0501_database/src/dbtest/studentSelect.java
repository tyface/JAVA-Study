package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class studentSelect {
	public static void main(String[] args) {
		// 1. 드라이버 로딩
		// 2. 연결
		// 3. 구문객체 생성
		// 4. sql실행
		// 5. 결과처리
		Connection conn = null;
		Statement stmt = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "root";
		String pass = "0000";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();

			String sql = "select * " + "from student_ex ";

			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String name = rs.getString(2);
				int grade = rs.getInt(3);
				
				System.out.println(num + name + grade);
			}
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileDao implements IFileDao {

	private Connection conn;

	private static FileDao INSTANCE;
	
	public static FileDao getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new FileDao();
		}
		return INSTANCE;
	}
	
	@Override
	public int insert(String fileName) {
		PreparedStatement pstmt = null;
		int rowCount = 0;	
		
		String sql = "INSERT INTO uploadfile VALUES(?,sysdate)";
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,fileName);
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
	public List<String> selectAll() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<String> fileNameList = new ArrayList<String>();
		try {
			String sql = "SELECT * FROM uploadfile ORDER BY filename";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				fileNameList.add(rs.getString("filename"));
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
		return fileNameList;
	}

}

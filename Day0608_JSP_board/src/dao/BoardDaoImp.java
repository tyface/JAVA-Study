package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Board;

public class BoardDaoImp implements BoardDao{
	private Connection conn;

	private static BoardDaoImp instance;

	private BoardDaoImp() {
		
	}
	
	public static BoardDaoImp getInstance() {
		if(instance == null) {
			instance = new BoardDaoImp();
		}
		return instance;
	}
	
	@Override
	public int insertBoard(Board board) {
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			String sql = "INSERT INTO board_ex VALUES(BOARD_SEQ.nextval,?,?,?,?,?,?,sysdate)";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getName());
			pstmt.setString(3, board.getPass());
			pstmt.setString(4, board.getEmail());
			pstmt.setString(5, board.getContent());
			pstmt.setInt(6, 0);

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
	public int updateBoard(Board board) {
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			String sql = "UPDATE board_ex SET title = ?, name = ?, pass = ?, email = ?, content = ? "
					+ "where num = ?";
			
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getName());
			pstmt.setString(3, board.getPass());
			pstmt.setString(4, board.getEmail());
			pstmt.setString(5, board.getContent());
			pstmt.setInt(6, board.getNum());

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
	public int deleteBoard(String num) {
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			String sql = "DELETE FROM board_ex where num = ?";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, num);

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
	public Board selectOne(String num) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board board = null;

		try {
			String sql = "SELECT * FROM board_ex WHERE num = ?";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				board = new Board();
				board.setNum(rs.getInt("NUM"));
				board.setTitle(rs.getString("TITLE"));
				board.setName(rs.getString("NAME"));
				board.setPass(rs.getString("PASS"));
				board.setEmail(rs.getString("EMAIL"));
				board.setContent(rs.getString("CONTENT"));
				board.setReadCount(rs.getInt("READCOUNT"));
				board.setWriteDate(rs.getDate("WRITEDATE"));
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
		return board;
	}

	@Override
	public List<Board> selectAll() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Board> boardList = new ArrayList<Board>();
		try {
			String sql = "SELECT * FROM board_ex ORDER BY num DESC";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Board board = new Board();
				
				board.setNum(rs.getInt("NUM"));
				board.setTitle(rs.getString("TITLE"));
				board.setName(rs.getString("NAME"));
				board.setPass(rs.getString("PASS"));
				board.setEmail(rs.getString("EMAIL"));
				board.setContent(rs.getString("EMAIL"));
				board.setReadCount(rs.getInt("READCOUNT"));
				board.setWriteDate(rs.getDate("WRITEDATE"));

				boardList.add(board);
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
		return boardList;
	}
	
	public int updateReadCount(String num) {
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			String sql = "UPDATE board_ex SET readcount = readcount + 1 where num = ?";
			
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, num);

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

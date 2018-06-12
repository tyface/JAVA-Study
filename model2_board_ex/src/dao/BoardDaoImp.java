package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import commons.Commons;
import model.Board;
import model.Board;

public class BoardDaoImp implements BoardDao {
	private Connection conn;

	private static BoardDaoImp instance;

	private BoardDaoImp() {

	}

	public static BoardDaoImp getInstance() {
		if (instance == null) {
			instance = new BoardDaoImp();
		}
		return instance;
	}

	@Override
	public int insertBoard(Board board) {
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			String sql = "INSERT INTO ex1_board VALUES(EX1_BOARD_SEQ.nextval,?,?,?,?,SYSDATE,?)";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, board.getContent());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getBoardPw());
			pstmt.setInt(4, 0);
			pstmt.setInt(5, board.getUserIdx());

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
	public Board selectOne(String boardIdx) {
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Board board = null;

		try {
			String sql = "SELECT b.board_idx, b.BOARD_CONTENT, b.BOARD_TITLE, b.BOARD_PW, b.READCOUNT, b.REGDATE, "
					+ "m.USER_IDX, m.USER_ID " + "FROM ex1_board b , ex1_member m "
					+ "WHERE b.user_idx = m.user_idx AND b.board_idx = ?";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, boardIdx);

			rSet = pstmt.executeQuery();

			if (rSet.next()) {

				board = new Board();
				board.setBoardIdx(rSet.getInt(Commons.Board.BOARD_IDX));
				board.setContent(rSet.getString(Commons.Board.BOARD_CONTENT));
				board.setTitle(rSet.getString(Commons.Board.BOARD_TITLE));
				board.setBoardPw(rSet.getString(Commons.Board.BOARD_PW));
				board.setReadCount(rSet.getInt(Commons.Board.READCOUNT));
				board.setRegDate(rSet.getDate(Commons.Board.REGDATE));
				board.setUserIdx(rSet.getInt(Commons.Member.USER_IDX));
				board.setUserId(rSet.getString(Commons.Member.USER_ID));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				if (rSet != null)
					rSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return board;
	}

	@Override
	public List<Board> selectAll() {
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Board board = null;
		List<Board> boardList = new ArrayList<Board>();

		try {
			String sql = "SELECT b.board_idx, b.BOARD_CONTENT, b.BOARD_TITLE, b.BOARD_PW, "
							+ "b.READCOUNT, b.REGDATE, m.USER_IDX, m.USER_ID " 
					   + "FROM ex1_board b , ex1_member m " 
					   + "WHERE b.user_idx = m.user_idx "
					   + "ORDER BY b.board_idx DESC";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			rSet = pstmt.executeQuery();

			while (rSet.next()) {

				board = new Board();
				board.setBoardIdx(rSet.getInt(Commons.Board.BOARD_IDX));
				board.setContent(rSet.getString(Commons.Board.BOARD_CONTENT));
				board.setTitle(rSet.getString(Commons.Board.BOARD_TITLE));
				board.setBoardPw(rSet.getString(Commons.Board.BOARD_PW));
				board.setReadCount(rSet.getInt(Commons.Board.READCOUNT));
				board.setRegDate(rSet.getDate(Commons.Board.REGDATE));
				board.setUserIdx(rSet.getInt(Commons.Member.USER_IDX));
				board.setUserId(rSet.getString(Commons.Member.USER_ID));

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
				if (rSet != null)
					rSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return boardList;
	}

	@Override
	public int updateBoard(Board board) {
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			String sql = "UPDATE ex1_board SET board_content = ?, board_title = ?, board_pw = ? WHERE board_idx = ?";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, board.getContent());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getBoardPw());
			pstmt.setInt(4, board.getBoardIdx());
			System.out.println(board.getBoardIdx());
			System.out.println(sql);
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

	public int updateReadCount(String board_idx) {
		PreparedStatement pstmt = null;
		int rowCount = 0;

		try {
			String sql = "UPDATE ex1_board SET readcount = readcount + 1 where board_idx = ?";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, board_idx);

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
	public int deleteBoard(String board_idx) {
		PreparedStatement pstmt = null;
		int rowCount = 0;

		try {
			String sql = "DELETE FROM ex1_board WHERE board_idx = ?";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, board_idx);

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

	public List<Board> selectBetween(int firstRow, int endRow) {
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Board board = null;

		List<Board> boardList = new ArrayList<Board>();
		try {
			String sql = "SELECT * "
						+ "FROM (SELECT rownum as rnum, board_idx, board_content, board_title, board_pw, readcount, regdate, user_idx, user_id "
							  + "FROM (SELECT  b.board_idx, b.board_content, b.board_title, b.board_pw, b.readcount, b.regdate, m.user_idx, m.user_id "
							  		+ "FROM ex1_board b, ex1_member m " 
							  		+ "WHERE b.user_idx = m.user_idx "
							  		+ "ORDER BY b.board_idx desc))" 
						+ "WHERE rnum BETWEEN ? AND ?";

			conn = ConnectionProvider.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, endRow);
			rSet = pstmt.executeQuery();

			while (rSet.next()) {
				board = new Board();
				board.setBoardIdx(rSet.getInt(Commons.Board.BOARD_IDX));
				board.setContent(rSet.getString(Commons.Board.BOARD_CONTENT));
				board.setTitle(rSet.getString(Commons.Board.BOARD_TITLE));
				board.setBoardPw(rSet.getString(Commons.Board.BOARD_PW));
				board.setReadCount(rSet.getInt(Commons.Board.READCOUNT));
				board.setRegDate(rSet.getDate(Commons.Board.REGDATE));
				board.setUserIdx(rSet.getInt(Commons.Board.USER_IDX));
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
				if (rSet != null)
					rSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return boardList;
	}

	public int selectCount() {
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		int count = 0;
		try {
			String sql = "SELECT count(*) as count FROM ex1_board";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			rSet = pstmt.executeQuery();

			if (rSet.next()) {
				count = rSet.getInt("count");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				if (rSet != null)
					rSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

}

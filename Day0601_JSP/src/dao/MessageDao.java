package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import commons.Commons;
import model.Message;

public class MessageDao implements IMessageDao {

	private Connection conn;
	private static MessageDao INSTANCE;

	private MessageDao() {
		
	}
	
	public static MessageDao getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new MessageDao();
		}
		return INSTANCE;
	}
	
	public int insertMessage(Message message) {
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			System.out.println("userNum:" + message.getUserNum());
			System.out.println(message);
			String sql = "INSERT INTO message VALUES(MESSAGE_SEQ.nextval,?,?,?,?)";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, message.getPw());
			pstmt.setString(2, message.getName());
			pstmt.setString(3, message.getMessage());
			pstmt.setInt(4, message.getUserNum());

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

//	public int updateMessage(Message message) {
//		PreparedStatement pstmt = null;
//		int rowCount = 0;
//		try {
//			String sql = "UPDATE message SET ? = ?, ? = ?, ? = ? where id = ?";
//
//			conn = ConnectionProvider.getConnection();
//			pstmt = conn.prepareStatement(sql);
//
//			pstmt.setString(1, Commons.Message.PW);
//			pstmt.setString(2, message.getPw());
//			pstmt.setString(1, Commons.Message.PW);
//			
//			pstmt.setString(2, message.getName());
//			pstmt.setString(3, message.getEmail());
//			pstmt.setString(4, message.getId());
//
//			rowCount = pstmt.executeUpdate();
//
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (pstmt != null)
//					pstmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return rowCount;
//	}

	public int deleteMessage(int id) {
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			String sql = "DELETE FROM message where ID = ?";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);

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
	
	public Message selectOne(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Message message = null;

		try {
			String sql = "SELECT * FROM message where ID = ?";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				message = new Message();
				message.setId(rs.getInt(Commons.Message.ID));
				message.setPw(rs.getString(Commons.Message.PASSWORD));
				message.setName(rs.getString(Commons.Message.NAME));
				message.setMessage(rs.getString(Commons.Message.MESSAGE));
				message.setUserNum(rs.getInt(Commons.Message.USER_NUM));
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
		return message;
	}

	public List<Message> selectAll() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Message message = null;

		List<Message> messageList = new ArrayList<Message>();
		try {
			String sql = "SELECT mes.ID,mes.PASSWORD,mem.NAME,mes.MESSAGE,mes.USER_NUM "
					   + "FROM message mes, MEMBER mem "
					   + "WHERE mes.USER_NUM = mem.NUM "
					   + "ORDER BY ID DESC";

			conn = ConnectionProvider.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				message = new Message();
				message.setId(rs.getInt(Commons.Message.ID));
				message.setPw(rs.getString(Commons.Message.PASSWORD));
				message.setName(rs.getString(Commons.Message.NAME));
				message.setMessage(rs.getString(Commons.Message.MESSAGE));
				message.setUserNum(rs.getInt(Commons.Message.USER_NUM));
				messageList.add(message);
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
		return messageList;
	}

	public List<Message> selectBetween(int firstRow, int endRow) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Message message = null;

		List<Message> messageList = new ArrayList<Message>();
		try {
			String sql ="SELECT * " 	
					   +"FROM (SELECT rownum as rnum, id, password, name, message, user_num "
					   + 	  "FROM (SELECT mes.ID,mes.PASSWORD,mem.NAME,mes.MESSAGE,mes.USER_NUM "
					   + 	  	    "FROM message mes, member mem "
					   + 	  	    "WHERE mes.USER_NUM = mem.NUM "
					   + 	  	    "ORDER BY mes.ID desc))"
					   + "WHERE rnum BETWEEN ? AND ?";
			
			conn = ConnectionProvider.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				message = new Message();
				message.setId(rs.getInt(Commons.Message.ID));
				message.setPw(rs.getString(Commons.Message.PASSWORD));
				message.setName(rs.getString(Commons.Message.NAME));
				message.setMessage(rs.getString(Commons.Message.MESSAGE));
				message.setUserNum(rs.getInt(Commons.Message.USER_NUM));
				messageList.add(message);
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
		return messageList;
	}
	
	public int selectCount() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			String sql = "SELECT count(*) FROM message";

			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
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
		return count;
	}
}

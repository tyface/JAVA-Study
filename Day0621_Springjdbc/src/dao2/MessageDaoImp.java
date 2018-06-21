package dao2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MessageDaoImp implements MessageDao {

	private JdbcTemplate jt;

	public MessageDaoImp(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int insertMessage(Map<String, Object> param) {
		String sql = "insert into message values(message_seq.nextval,?,?,?,?)";
		return jt.update(sql, param.get("password"), param.get("name"), param.get("message"), param.get("user_num"));
	}

	@Override
	public int updateMessage(Map<String, Object> param) {
		String sql = "update message set password = ?, name = ?, message = ? where id = ?";
		return jt.update(sql, param.get("password"), param.get("name"), param.get("message"), param.get("id"));
	}

	@Override
	public int deleteMessage(int id) {
		String sql = "delete message from where id = ?";
		return jt.update(sql, id);
	}

	@Override
	public Map<String, Object> selectOne(int id) {
		String sql = "select * from message where id = ?";
		return jt.queryForObject(sql, rowMap, id);
	}

	@Override
	public List<Map<String, Object>> selectAll() {
		String sql = "select * from message";
		return jt.query(sql, rowMap);
	}

	RowMapper<Map<String, Object>> rowMap = new RowMapper<Map<String, Object>>(){

		@Override
		public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
			Map<String, Object> rsMap = new HashMap<String, Object>(); 
			rsMap.put("id", rs.getInt("id"));
			rsMap.put("password", rs.getString("password"));
			rsMap.put("name", rs.getString("name"));
			rsMap.put("message", rs.getString("message"));
			rsMap.put("user_num", rs.getInt("user_num"));
			return rsMap;
		}
	};
}

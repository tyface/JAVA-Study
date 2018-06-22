package dao3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import model.Board;

@Component("boardDao")
public class BoardDaoImp implements BoardDao {

	@Autowired
	private NamedParameterJdbcTemplate jt;

	@Override
	public int insertBoard(Board board) {
		String sql = "insert into board_ex values(board_seq.nextval,:title,:name,:pass,:email,:content,0,sysdate)";

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", board.getTitle());
		paramMap.put("name", board.getName());
		paramMap.put("pass", board.getPass());
		paramMap.put("email", board.getEmail());
		paramMap.put("content", board.getContent());

		return jt.update(sql, paramMap);
	}

	@Override
	public int updateBoard(Board board) {
		String sql = "update board_ex set title = :title, name = :name, pass = :pass, email = :email, content = :content where num = :num";

		// Map<String, Object> paramMap = new HashMap<String, Object>();
		// paramMap.put("title", board.getTitle());
		// paramMap.put("name", board.getName());
		// paramMap.put("pass", board.getPass());
		// paramMap.put("email", board.getEmail());
		// paramMap.put("content", board.getContent());
		// paramMap.put("num", board.getNum());

		// 자바 빈의 멤버를 Map으로 변환해주는 클래스
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(board);

		return jt.update(sql, params);
	}

	@Override
	public int deleteBoard(int num) {
		String sql = "delete from board_ex where num = :num";

		// Map<String, Object> paramMap = new HashMap<String, Object>();
		// paramMap.put("num", num);

		// 파라미터가 하나인 경우 사용할 수있는 Map: 자바지원
		return jt.update(sql, Collections.singletonMap("num", num));
	}

	@Override
	public Board selectOne(int num) {
		String sql = "select * from board_ex where num = :num";

		// 파라미터가 하나인 경우 사용할 수있는 Map: 스프링 지원
		MapSqlParameterSource param = new MapSqlParameterSource("num", num);
		return jt.queryForObject(sql, param, rowMap);
	}

	@Override
	public List<Board> selectAll() {
		String sql = "select * from board_ex";

		return jt.query(sql, rowMap);
	}

	RowMapper<Board> rowMap = new RowMapper<Board>() {

		@Override
		public Board mapRow(ResultSet rs, int rowNum) throws SQLException {

			Board board = new Board();
			board.setNum(rs.getInt("num"));
			board.setTitle(rs.getString("title"));
			board.setName(rs.getString("name"));
			board.setPass(rs.getString("pass"));
			board.setEmail(rs.getString("email"));
			board.setContent(rs.getString("content"));
			board.setReadCount(rs.getInt("readcount"));
			board.setWriteDate(rs.getDate("writedate"));

			return board;
		}
	};

}

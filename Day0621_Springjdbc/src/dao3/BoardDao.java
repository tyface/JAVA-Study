package dao3;

import java.util.List;

import model.Board;

public interface BoardDao {
	public int insertBoard(Board board);

	public int updateBoard(Board board);

	public int deleteBoard(int num);

	public Board selectOne(int num);

	public List<Board> selectAll();

}

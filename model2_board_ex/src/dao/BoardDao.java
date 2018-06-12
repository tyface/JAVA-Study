package dao;

import java.util.List;

import model.Board;

public interface BoardDao {

	public int insertBoard(Board board);

	public Board selectOne(String boardIdx);

	public List<Board> selectAll();

	public int updateBoard(Board board);

	public int updateReadCount(String boardIdx);
	
	public int deleteBoard(String boardIdx);

	public int selectCount();

	public List<Board> selectBetween(int firstRow, int endRow);

}

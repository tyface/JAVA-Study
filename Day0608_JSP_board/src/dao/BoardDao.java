package dao;

import java.util.List;

import model.Board;

public interface BoardDao {

	public int insertBoard(Board board);
	
	public int updateBoard(Board board);
	
	public int deleteBoard(String num);
	
	public Board selectOne(String num);
	
	public List<Board> selectAll();
	
	public int updateReadCount(String num);
}

package com.dao;

import java.util.List;
import java.util.Map;

import com.model.Board;

public interface BoardDao {
	
	public int insertBoard(Board board);

	public int updateBoard(Board board);

	public int deleteBoard(int num);

	public Board selectOne(int num);

	public List<Board> selectAll();
	
	public List<Board> searchBoard(Map<String, Object> params);
	
	public int insertAttach(Map<String, Object> params);
}

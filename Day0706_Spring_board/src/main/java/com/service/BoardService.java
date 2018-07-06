package com.service;

import java.util.List;

import com.model.Board;

public interface BoardService {
	
	public boolean createBoard(Board board);

	public boolean modifyBoard(Board board);

	public boolean removeBoard(int num);

	public Board searchBoardByNum(int num);

	public List<Board> searchBoardAll();
	
	public boolean boardPassCheck(int num, String pass);
}

package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BoardDao;
import com.model.Board;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDao boardDao;

	@Override
	public boolean createBoard(Board board) {
		if (boardDao.insertBoard(board) > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean modifyBoard(Board board) {
		if (boardDao.updateBoard(board) > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean removeBoard(int num) {
		if (boardDao.deleteBoard(num) > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Board searchBoardByNum(int num) {
		return boardDao.selectOne(num);
	}

	@Override
	public List<Board> searchBoardAll() {
		return boardDao.selectAll();
	}

	@Override
	public boolean boardPassCheck(int num, String pass) {
		Board board = searchBoardByNum(num);
		boolean result = false;
		
		if (board != null) {
			if (board.getPass().equals(pass)) {
				result = true;
			}
		}
		
		return result;
	}

}

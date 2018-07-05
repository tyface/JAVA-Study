package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BoardDao;
import model.Board;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDao dao;

	@Override
	public boolean insertBoard(Board board) {
		if (dao.insertBoard(board) > 0) {
			return true;
		} else {
			return false;
		}
	}



}

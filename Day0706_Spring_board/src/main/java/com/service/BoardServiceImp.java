package com.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dao.BoardDao;
import com.model.Board;

@Service
public class BoardServiceImp implements BoardService {

	// 파일 저장 경로
	private static final String UPLOAD_PATH = "C:\\test";

	@Autowired
	BoardDao boardDao;

	@Override
	public boolean writeBoard(Board board, MultipartFile file) {
		try {
			boardDao.insertBoard(board);
			
			String fullName = writeFile(file);
			board.setFullName(fullName);
			Map<String, Object> params = new HashMap<String, Object>();
			
			params.put("FULLNAME", fullName);
			params.put("NUM", board.getNum());

			boardDao.insertAttach(params);

			return true;
		} catch (Exception e) {
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
	public Board readBoard(int num) {
		Board board = boardDao.selectOne(num);
		board.setReadCount(board.getReadCount() + 1);
		boardDao.updateBoard(board);
		return board;
	}

	@Override
	public List<Board> searchBoardAll() {
		return boardDao.selectAll();
	}

	@Override
	public boolean boardPassCheck(int num, String pass) {
		Board board = boardDao.selectOne(num);
		boolean result = false;

		if (board != null) {
			if (board.getPass().equals(pass)) {
				result = true;
			}
		}

		return result;
	}

	@Override
	public Board searchBoardByNum(int num) {
		Board board = boardDao.selectOne(num);
		return board;
	}

	@Override
	public File getAttachFile(int num) {
		Board board = boardDao.selectOne(num);
		String fullName = board.getFullName();
		return new File(UPLOAD_PATH, fullName);
	}

	@Override
	public String writeFile(MultipartFile file) {
		// 파일 저장하고 uuid 붙여서 이름 만들어 내고, 이름 반환
		String fullName = null;
		// 파일이름 만들어내고,
		UUID uuid = UUID.randomUUID();
		fullName = uuid.toString() + "_" + file.getOriginalFilename();
		// 파일 생성하고,
		File target = new File(UPLOAD_PATH, fullName);
		try {
			// 원래파일을 만들어낸 파일에 복사
			FileCopyUtils.copy(file.getBytes(), target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 만들어낸 파일이름 반환
		return fullName;
	}

}

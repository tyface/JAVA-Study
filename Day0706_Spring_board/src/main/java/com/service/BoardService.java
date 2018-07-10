package com.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.model.Board;

public interface BoardService {
	
	public boolean writeBoard(Board board, MultipartFile file);

	public boolean modifyBoard(Board board);

	public boolean removeBoard(int num);

	public Board readBoard(int num);
	
	public Board searchBoardByNum(int num);

	public List<Board> searchBoardAll();
	
	public boolean boardPassCheck(int num, String pass);
	
	public File getAttachFile(int num);
	
	public String writeFile(MultipartFile file);
}

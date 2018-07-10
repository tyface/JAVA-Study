package com.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.commons.DownloadView;
import com.model.Board;
import com.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardSvc;

	@RequestMapping("/write")
	public String createBoard(String name, String pass, String email, String title, String content, MultipartFile file,
			RedirectAttributes ra) {

		Board board = new Board();
		board.setName(name);
		board.setPass(pass);
		board.setEmail(email);
		board.setTitle(title);
		board.setContent(content);

		boardSvc.writeBoard(board, file);

		ra.addAttribute("num", board.getNum());

		return "redirect:board-view";
	}
	
	@RequestMapping("/download")
	public View download(int num) {
		File file = boardSvc.getAttachFile(num);
		View view = new DownloadView(file);
		return view;
	}
	
	@RequestMapping("/write-form")
	public String sendBoardWriteForm() {
		return "board-write";
	}

	@RequestMapping("/modify")
	public String modifyBoard(int num, String name, String pass, String email, String title, String content,
			RedirectAttributes ra) {

		Board board = new Board();
		board.setNum(num);
		board.setName(name);
		board.setPass(pass);
		board.setEmail(email);
		board.setTitle(title);
		board.setContent(content);

		boardSvc.modifyBoard(board);

		ra.addAttribute("num", num);

		return "redirect:board-view";
	}

	@RequestMapping("/modify-form")
	public String sendBoardModifyForm(int num, Model model) {

		model.addAttribute("board", boardSvc.searchBoardByNum(num));
		return "board-modify";
	}

	@RequestMapping("/delete")
	public String removeBoard(int num) {
		boardSvc.removeBoard(num);

		return "redirect:list-view";
	}

	@RequestMapping("/list-view")
	public String getAllBoardList(Model model) {
		List<Board> boardList = new ArrayList<Board>();

		boardList.addAll(boardSvc.searchBoardAll());
		model.addAttribute("boardList", boardList);

		return "board-list";
	}

	@RequestMapping("/board-view")
	public String boardView(int num, Model model) {
		model.addAttribute("board", boardSvc.readBoard(num));
		return "board-view";
	}

	@RequestMapping("/board-check-pass")
	public String sendBoardCheckPass(int num, String pass, Model model) {
		if (boardSvc.boardPassCheck(num, pass)) {
			model.addAttribute("num", num);
			return "check-success";
		} else {
			model.addAttribute("num", num);
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
			return "board-checkpass";
		}
	}

	@RequestMapping("/board-check-pass-form")
	public String sendBoardCheckPassForm(int num, Model model) {
		model.addAttribute("num", num);
		return "board-checkpass";
	}

}

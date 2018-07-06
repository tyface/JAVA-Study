package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.Board;
import com.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardSvc;

	@RequestMapping("/write")
	public String createBoard() {
		Board board = new Board();
		boardSvc.createBoard(board);

		return "redirect:board-view";
	}

	@RequestMapping("/write-form")
	public String sendBoardWriteForm() {
		return "board-write";
	}

	@RequestMapping("/modify-form")
	public String sendBoardModifyForm(int num) {
		System.out.println(num);
		return "board-modify";
	}

	@RequestMapping("/list-view")
	public String getAllBoardList(Model model) {
		List<Board> boardList = new ArrayList<Board>();

		boardList.addAll(boardSvc.searchBoardAll());
		model.addAttribute("boardList", boardList);

		return "board-list";
	}

	@RequestMapping("/board-view")
	public String getBoardByNum(int num, Model model) {
		model.addAttribute("board", boardSvc.searchBoardByNum(num));
		return "board-view";
	}

	@RequestMapping("/board-check-pass")
	public String sendBoardCheckPass(int num, String pass, RedirectAttributes ra,Model model) {
		if(boardSvc.boardPassCheck(num, pass)) {
			ra.addAttribute("num", num);
			System.out.println("*1 :: " + num);
			return "redirect:modify-form";
		}else {
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

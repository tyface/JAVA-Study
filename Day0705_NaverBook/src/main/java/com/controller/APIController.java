package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.NaverBookService;

@Controller
public class APIController {
	
	@Autowired
	NaverBookService bookSvc;
	
	@RequestMapping("/book-search")
	public String bookSearch(@RequestParam(required=false,defaultValue = "")String keyword, Model model) throws Exception {
		model.addAttribute("booklist",bookSvc.searchBooks(keyword));
		return "book-list";
	}
}

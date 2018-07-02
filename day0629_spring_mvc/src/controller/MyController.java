package controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/test.do")
	public String test(Model model) {
		System.out.println("test.do 요청입니다.33");
		model.addAttribute("msg", "test요청");

		return "test";
	}
	
	@RequestMapping("/whatTime.do")
	public String whatTime(Model model) {
		Date date = new Date();
		model.addAttribute("msg", date);

		return "test";
	}
	
}

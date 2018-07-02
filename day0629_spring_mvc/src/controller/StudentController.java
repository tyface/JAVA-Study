package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	IStudentService svc;

	@RequestMapping("/student-list")
	public String studentListByGrade(Model model, @RequestParam(value = "grade", defaultValue = "0") int g) {
		
		if(g < 1) {
			model.addAttribute("student_list", svc.getAllStudent());
		}else {
			model.addAttribute("student_list", svc.getStudentByGrade(g));
			model.addAttribute("grade", g);
		}
		return "student-list";
	}
	
	@RequestMapping("/add-student")
	public String studentAdd(String name, int grade) {
		
		if(svc.addStudent(name, grade)) {
			return "redirect:student-list";
		}else {
			return "add-student";
		}
	}
	
	@RequestMapping("/student-add-form")
	public String studentAddForm() {
		return "add-student";
	}
	
}

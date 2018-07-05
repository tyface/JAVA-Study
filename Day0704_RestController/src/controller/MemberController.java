package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.Member;
import service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService svc;

	@RequestMapping("/member-list")
	public String allMemberList(Model model) {

		if (svc.getAllMember() != null) {
			model.addAttribute("member_list", svc.getAllMember());
		} else {

		}
		return "member-list";
	}
	@ResponseBody
	@RequestMapping("/member-list-jackson")
	public  Map<String, Object> jacksonList(Model model) {
		System.out.println("젝슨 요청받음");
		Map<String,Object> testMap = new HashMap<String,Object>();
		testMap.put("test", svc.getAllMember());
		return testMap;
	}
	
	@RequestMapping("/login-form")
	public String sendLoginForm() {
		return "login";
	}

	@RequestMapping("/login")
	public String userLogin(HttpSession session, RedirectAttributes ra, String user_id, String user_pw) {

		Member member = svc.getMemberById(user_id);

		if (member != null) {

			if (member.getPw().equals(user_pw)) {
				member.setPw(null);
				session.setAttribute("member", member);

				return "redirect:main";
			} else {
				ra.addFlashAttribute("msg", "로그인 실패 : 비밀번호가 일치하지 않습니다.");
				return "redirect:login-form";
			}
		} else {
			ra.addFlashAttribute("msg", "로그인 실패 : 아디이가 존재하지 않습니다.");
			return "redirect:login-form";
		}
	}

	@RequestMapping("/join-form")
	public String sendJoinForm() {
		return "join";
	}

	@RequestMapping("/join")
	public String userJoin(HttpSession session, String user_id, String user_pw, String user_nm, String user_email) {

		Member member = svc.getMemberById(user_id);

		if (member == null) {
			member = new Member();
			member.setId(user_id);
			member.setPw(user_pw);
			member.setName(user_nm);
			member.setEmail(user_email);

			if (svc.join(member)) {
				member = svc.getMemberById(user_id);
				
				member.setPw(null);
				session.setAttribute("member", member);
				return "redirect:main";
			} else {
				return "redirect:join-form";
			}
		} else {
			return "redirect:join-form";
		}
	}

	@RequestMapping("/main")
	public String sendMain() {
		return "main";
	}

	@RequestMapping("/update-form")
	public String sendUpdateForm() {
		return "member-update";
	}

	@RequestMapping("/update")
	public String userUpdate(HttpSession session, String user_id, String user_pw, String user_nm, String user_email) {

		Member member = svc.getMemberById(user_id);

		if (member != null) {
			member = new Member();
			member.setId(user_id);
			member.setPw(user_pw);
			member.setName(user_nm);
			member.setEmail(user_email);

			if (svc.updateMember(member)) {
				member = svc.getMemberById(user_id);
				member.setPw(null);
				session.setAttribute("member", member);

				return "redirect:main";
			} else {
				return "redirect:join-form";
			}
		} else {
			return "redirect:join-form";
		}
	}

	@RequestMapping("/logout")
	public String userLogout(HttpSession session) {
		session.setAttribute("member", null);
		return "redirect:main";
	}
}

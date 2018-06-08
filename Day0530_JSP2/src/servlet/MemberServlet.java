package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import service.MemberService;

public class MemberServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MemberService service;
	private Member member;

	public MemberServlet() {
		service = new MemberService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}

	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String uri = req.getRequestURI();
		String conPath = req.getContextPath();
		String pattern = uri.replace(conPath, "");
		HttpSession session = req.getSession();
		RequestDispatcher dispatcher;
		
		////////////// log
		System.out.println("URI: " + req.getRequestURI());
		System.out.println("Context: " + req.getContextPath());
		System.out.println("pattern: " + pattern);

		switch (pattern) {
		case "/":
			dispatcher = req.getRequestDispatcher("loginForm.jsp");
			dispatcher.forward(req, resp);
			break;
		case "/loginForm":
			dispatcher = req.getRequestDispatcher("loginForm.jsp");
			dispatcher.forward(req, resp);
			break;
		case "/login":

			if (service.login(req.getParameter("userId"), req.getParameter("userPw"))) {
				session.setAttribute("userId", req.getParameter("userId"));
				System.out.println("로그인 완료");
				resp.sendRedirect("main");
			} else {
				System.out.println("로그인 실패");
				req.setAttribute("msg", "로그인 실패");
				req.setAttribute("pass", "loginForm");
				dispatcher = req.getRequestDispatcher("result.jsp");
				dispatcher.forward(req, resp);
			}
			break;
		case "/logout":
			session.invalidate();
			resp.sendRedirect("loginForm");
			break;
		case "/main":
				resp.sendRedirect("main.jsp");
//				dispatcher = req.getRequestDispatcher("main.jsp");
//				dispatcher.forward(req, resp);
//				req.setAttribute("msg", "로그인후 이용 해주세요");
//				req.setAttribute("pass", "loginForm.jsp");
//				dispatcher = req.getRequestDispatcher("result.jsp");
//				dispatcher.forward(req, resp);
			break;
		case "/memberList":
			req.setAttribute("memberList", service.getMemberList());
			dispatcher = req.getRequestDispatcher("memberList.jsp");
			dispatcher.forward(req, resp);
			break;
		case "/modifyForm":
			req.setAttribute("member", service.getMember((String)session.getAttribute("userId")));
			dispatcher = req.getRequestDispatcher("modifyForm.jsp");
			dispatcher.forward(req, resp);
			break;
		case "/modify":
			member = new Member();
			member.setId(req.getParameter("userId"));
			member.setPw(req.getParameter("userPw"));
			member.setName(req.getParameter("userName"));
			member.setEmail(req.getParameter("userEmail"));
			
			if (service.modify(member)) {
				System.out.println("회원정보 수정 성공");
				req.setAttribute("msg", "회원정보 수정 완료");
				req.setAttribute("pass", "main");
				dispatcher = req.getRequestDispatcher("result.jsp");
				dispatcher.forward(req, resp);
			} else {
				System.out.println("회원정보 수정 실패");
				req.setAttribute("msg", "회원정보 수정 실패");
				req.setAttribute("pass", "modifyForm");
				dispatcher = req.getRequestDispatcher("result.jsp");
				dispatcher.forward(req, resp);
			}
			break;
		case "/joinForm":
			dispatcher = req.getRequestDispatcher("joinForm.jsp");
			dispatcher.forward(req, resp);
			break;
		case "/join":
			member = new Member();
			member.setId(req.getParameter("userId"));
			member.setName(req.getParameter("userName"));
			member.setPw(req.getParameter("userPw"));
			member.setEmail(req.getParameter("userEmail"));

			if (service.join(member)) {
				System.out.println("회원가입 성공");
				req.setAttribute("msg", "회원가입이 완료되었습니다.");
				req.setAttribute("pass", "loginForm");
				dispatcher = req.getRequestDispatcher("result.jsp");
				dispatcher.forward(req, resp);
			} else {
				System.out.println("회원가입 실패");
				req.setAttribute("msg", "회원가입이 실패하였습니다.");
				req.setAttribute("pass", "joinForm");
				dispatcher = req.getRequestDispatcher("result.jsp");
				dispatcher.forward(req, resp);
			}
			break;
		default:
			System.out.println("예외 패턴");
			resp.sendRedirect("err.jsp");
			break;
		}
		
	}
}

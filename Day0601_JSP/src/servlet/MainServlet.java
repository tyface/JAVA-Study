package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import model.Message;
import service.MemberService;
import service.MessageService;

public class MainServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MemberService memberService;
	private MessageService messageService;
	private Message message;
	
	public MainServlet() {
		memberService = MemberService.getInstance();
		messageService = MessageService.getInstance();
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
		
		int messageId;
		int pageNum = 1;
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
			if (memberService.login(req.getParameter("userId"), req.getParameter("userPw"))) {
				
				session.setAttribute("member", memberService.getMember(req.getParameter("userId")));
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
			
			if(req.getParameter("pageNum")!=null) {
				pageNum = Integer.parseInt(req.getParameter("pageNum"));
			}
			
			Map<String, Object> viewData = messageService.getMessageList(pageNum);
			
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("messageList", viewData.get("messageList"));
			req.setAttribute("lastPage", viewData.get("lastPage"));
			req.setAttribute("startPage", viewData.get("startPage"));
			req.setAttribute("endPage", viewData.get("endPage"));

			dispatcher = req.getRequestDispatcher("main.jsp");
			dispatcher.forward(req, resp);

			break;
		case "/memberList":
			req.setAttribute("memberList", memberService.getMemberList());
			dispatcher = req.getRequestDispatcher("memberList.jsp");
			dispatcher.forward(req, resp);
			break;
		case "/modifyForm":
			Member member = (Member)session.getAttribute("member");
			req.setAttribute("member", memberService.getMember(member.getId()));
			dispatcher = req.getRequestDispatcher("modifyForm.jsp");
			dispatcher.forward(req, resp);
			break;
		case "/modify":
			member = new Member();
			member.setId(req.getParameter("userId"));
			member.setPw(req.getParameter("userPw"));
			member.setName(req.getParameter("userName"));
			member.setEmail(req.getParameter("userEmail"));

			if (memberService.modify(member)) {
				System.out.println("회원정보 수정 성공");
				req.setAttribute("msg", "회원정보 수정 완료");
				req.setAttribute("pass", "main");
			} else {
				System.out.println("회원정보 수정 실패");
				req.setAttribute("msg", "회원정보 수정 실패");
				req.setAttribute("pass", "modifyForm");
			
			}
			dispatcher = req.getRequestDispatcher("result.jsp");
			dispatcher.forward(req, resp);
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

			if (memberService.join(member)) {
				System.out.println("회원가입 성공");
				req.setAttribute("msg", "회원가입이 완료되었습니다.");
				req.setAttribute("pass", "loginForm");
			} else {
				System.out.println("회원가입 실패");
				req.setAttribute("msg", "회원가입이 실패하였습니다.");
				req.setAttribute("pass", "joinForm");
			
			}
			dispatcher = req.getRequestDispatcher("result.jsp");
			dispatcher.forward(req, resp);
			break;
		case "/write":
			message = new Message();
			
			message.setPw(req.getParameter("password"));
			message.setName(req.getParameter("userName"));
			message.setMessage(req.getParameter("message"));
			message.setUserNum(((Member)session.getAttribute("member")).getNum());
			
			
			if(messageService.writeMessage(message)==1) {
				
				req.setAttribute("messageList", messageService.getMessageList(pageNum));
				
				System.out.println("메세지등록 완료");
				req.setAttribute("msg", "메세지등록 완료");
				req.setAttribute("pass", "main");
			}else {
				System.out.println("메세지등록 실패");
				req.setAttribute("msg", "메세지등록 실패");
				req.setAttribute("pass", "main");
				
			}
			dispatcher = req.getRequestDispatcher("result.jsp");
			dispatcher.forward(req, resp);
			
			break;
		case "/conformDeletion":
			messageId = Integer.parseInt(req.getParameter("id"));
			
//			((Member)session.getAttribute("member")).getNum();
			
			dispatcher = req.getRequestDispatcher("conformDeletion.jsp");
			dispatcher.forward(req, resp);
			break;
		case "/pwCheck":
			messageId = Integer.parseInt(req.getParameter("id"));
			String pw = req.getParameter("password");
			
			if(messageService.removeMessage(messageId, pw)) {
				System.out.println("메세지삭제 완료");
				req.setAttribute("msg", "메세지삭제 완료");
				req.setAttribute("pass", "main");
			}else {
				System.out.println("메세지삭제 실패");
				req.setAttribute("msg", "메세지삭제 실패");
				req.setAttribute("pass", "conformDeletion?id="+messageId);
			}
			
			dispatcher = req.getRequestDispatcher("result.jsp");
			dispatcher.forward(req, resp);
			break;
		default:
			System.out.println("예외 패턴");
			resp.sendRedirect("err.jsp");
			break;
		}

	}
}

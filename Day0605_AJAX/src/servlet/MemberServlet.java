package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Member;
import service.MemberService;

@WebServlet("/member")
public class MemberServlet extends HttpServlet{
	String data;
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
		MemberService mSvc = MemberService.getInstance();
		
		RequestDispatcher dispatcher;
		String command = req.getParameter("command");

		
		////////////// log
		System.out.println("URI: " + uri);
		System.out.println("command:" + command);
		
		String id;
		boolean result;
		switch (command) {
		case "checkId":
			id = req.getParameter("userId");
			boolean idDup = MemberService.getInstance().checkId(id);
			
			resp.getWriter().print(idDup);
			break;
		case "checkEmail":
			String email = req.getParameter("email");
			boolean emailDup = MemberService.getInstance().checkEmail(email);
			
			resp.getWriter().print(emailDup);
			break;
		case "joinForm":
			resp.sendRedirect("03joinForm.jsp");
			break;
		case "join":
			Member member = new Member();
			
			member.setId(req.getParameter("userid"));
			member.setName(req.getParameter("name"));
			member.setPw(req.getParameter("password"));
			member.setEmail(req.getParameter("email"));
			
			result = mSvc.join(member);
			
			resp.getWriter().print(result);
			break;
		case "memberList":
			List<Member> memberList = mSvc.getMemberList();
			data = new Gson().toJson(memberList);
			
			resp.getWriter().print(data);
			break;
		case "deleteMember":
			id = req.getParameter("userid");
			result = mSvc.deleteMember(id);
			resp.getWriter().print(result);
			break;
		default:
			System.out.println("예외 패턴");
			resp.sendRedirect("err.jsp");
			break;
		}
		
		
	}
	
	
}







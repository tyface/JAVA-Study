package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	//'login' 요청 받아서 처리, post 방식으로
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String myId = "hong123";
	String myPw = "12345";
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//아이디랑 비밀번호 요청에서 꺼내와서 원래 가지고 있던 아이디랑 비밀번호 비교
		
		String id = request.getParameter("userid"); 
		String pw = request.getParameter("userpw");
			
			if(id !=null && id.equals(myId)){
				//아이디 있음
				if(pw !=null && pw.equals(myPw)){
					
					RequestDispatcher dispatcher
					= request.getRequestDispatcher("03loginSuccess.jsp");
					dispatcher.forward(request, response);
				}else{
					
//	 				out.print("비밀번호가 틀렸습니다.");
					request.setAttribute("msg", "비밀번호가 틀렸습니다.");
					RequestDispatcher dispatcher
					= request.getRequestDispatcher("03loginFail.jsp");
					dispatcher.forward(request, response);
				}			
			}else{
//	 			out.print("아이디가 틀렸습니다.");
				request.setAttribute("msg", "아이디가 틀렸습니다.");
				RequestDispatcher dispatcher
				= request.getRequestDispatcher("03loginFail.jsp");
				dispatcher.forward(request, response);
			}
		
		
		
		
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}







import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/hello")
public class HelloServlet extends HttpServlet{
	//서블릿의 역할은 요청을 받아서 처리하는 것
	//HttpServlet이 요청을 받아서 처리하는 메서드 : doGet,doPost
	
	//doGet메서드 : get방식의 요청을 받아서 처리하겠다.
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//해야 할 일 요청받아서 처리하기 
		//1. 어떤요청을 받아서 처리할 것인가에 대해서 설정 : @WebServlet
//		System.out.println("hello요청을 받았습니다!!!");
		//얘가 하는일은 요청을 받아서 화면을 응답하는 일
		//request : 요청에 대한 정보를 담고있는 객체
		//response : 응답에 대한 정보를 담고 있는 객체 
		
		PrintWriter pw = resp.getWriter();
		resp.setCharacterEncoding("UTF-8");
		pw.print("<h1>Hello!!</h1>");
		pw.print("<br>");
		pw.print("<hr>");
		
	}
}












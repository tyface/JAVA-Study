package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;

@WebServlet("/board")
public class BoardServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{ 
		doProc(req, resp);	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doProc(req, resp);
	}
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		//if-else 방식이 아니라...요청별로 새로운 클래스를 만들어서 실행
		//동적바인딩
		//ActionFactory : 실재 요청을 처리할 클래스의 객체를 만들어 주는 역할
		//실제로 우리가 호출하는 메서드는 Action execute 만 호출
		String command = req.getParameter("command");
		//실제 객체를만들어 주는 기능을 하는 클래스 작성 
				//ActionFactory : action 객체를 만들어 주니까...
		Action action = ActionFactory.getAction(command);
		action.execute(req, resp);
		
		
		
	}
	
	
}

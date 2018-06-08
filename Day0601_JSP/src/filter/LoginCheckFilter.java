package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter{

	RequestDispatcher dispatcher;
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpReq = (HttpServletRequest)req;
		HttpSession session = httpReq.getSession();
		
		if(session.getAttribute("member")==null) {
			httpReq.setAttribute("msg", "로그인후 이용 해주세요");
			httpReq.setAttribute("pass", "loginForm.jsp");
			dispatcher = httpReq.getRequestDispatcher("result.jsp");
			dispatcher.forward(httpReq, resp);
		}else {
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}

}

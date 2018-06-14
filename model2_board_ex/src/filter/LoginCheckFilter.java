package filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {

	RequestDispatcher dispatcher;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		HttpServletRequest httpReq = (HttpServletRequest) req;
		HttpSession session = httpReq.getSession();

		String comm = httpReq.getParameter("command");

		String[] commList = { "check-pass-form", "check-pass", "write-form", "write", "update-form", "update",
				"delete","modify-form","view-profile" };
		Set<String> checkList = new HashSet<String>(Arrays.asList(commList));
		
		if (session.getAttribute("member") == null && checkList.contains(comm)) {
			httpReq.setAttribute("msg", "로그인후 이용 해주세요");
			httpReq.setAttribute("url", "main");
			httpReq.setAttribute("comm", "main");
			httpReq.getRequestDispatcher("jsp/result.jsp").forward(httpReq, resp);
		} else {
			chain.doFilter(req, resp);
		}

	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}

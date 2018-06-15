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

		//로그인 여부를 확인할 요청 리스트
		String[] commList = { "check-pass-form", "check-pass", "write-form", "write", "update-form", "update",
				"delete","modify","modify-form" };
		// 커멘트 리스트를 셋에 입력
		Set<String> checkList = new HashSet<String>(Arrays.asList(commList));
		
		//세션에 로그인 산태인지 확인과 해당커멘트다 리스트에 존재하는지 확인후 분기 처리
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

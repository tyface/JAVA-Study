package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("프리 핸들");
		System.out.println(request.getSession().getAttribute("member"));
		
		if (request.getSession().getAttribute("member") != null) {
			return true;
		} else {
			response.sendRedirect("login-form");
			return false;
		}
	}

}

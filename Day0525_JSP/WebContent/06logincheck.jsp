<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String myId = "hong123";
	String myPw = "12345";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 체크</title>
</head>
<body>
	<%-- 여기서 login.jsp에서 보낸 데이터를 받아봅시다.  --%>
	<%
	String id = request.getParameter("userid");
	String pw = request.getParameter("userpw");

		if(id !=null && id.equals(myId)){
			//아이디 있음
			if(pw !=null && pw.equals(myPw)){
				//out.print("로그인 성공!");
				//로그인 성공하면 화면 이동
				//forward, redirect
				//redirect:
				//페이지 전환이 되는데 응답객체가 브라우저에게 새로운 요청을 만들어내게 하는 방법
				//응답객체 : response
				//브라우저가 요청을 새롭게 만들게 되면 url이 바뀜
// 				response.sendRedirect("loginSuccess.jsp");

				//id,pw 정보를 유지하고 싶다...
				//현재 요청을 유지하면서, 화면만 전환: forward
				//forward: 브라우저랑은 상관없이 서버내부에서 화면 전환
				RequestDispatcher dispatcher
				= request.getRequestDispatcher("06loginSuccess.jsp");

				dispatcher.forward(request, response);




			}else{
				// out.print("비밀번호가 틀렸습니다.");

        RequestDispatcher dispatcher
        = request.getRequestDispatcher("06loginFail.jsp");
        request.setAttribute("msg","비밀번호가 틀렸습니다.");
        dispatcher.forward(request, response);
			}
		}else{
			// out.print("아이디가 틀렸습니다.");
      RequestDispatcher dispatcher
      = request.getRequestDispatcher("06loginFail.jsp");
      request.setAttribute("msg","아이디가 틀렸습니다.");
      dispatcher.forward(request, response);
		}

	%>
<%-- 	아이디 : <%=id %> --%>
<%-- 	비밀번호: <%=pw %> --%>

</body>
</html>

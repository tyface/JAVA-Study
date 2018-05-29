액션태그(Action Tag)
Tag : <이름>모양으로 html 구성요소를  작성하는 역할
JSP 페이지내에서 자바코드를 기술할 때 가독성을 높이기 위한 방법
자바코드로 작성해야 할 내용을 xml 방식의 태그로 작성
ex) 액션태그 예
 <%
 	Student s = new Student();
 %>

 <jsp:useBean id = "s" class = "Student">

 액션태그의 종류
 <jsp:forward> : 포워딩 방식으로 다른 페이지 이동할 때 사용
 <jsp:include> : 페이지의 모듈화를 위해 사용, 페이지내에 모듈 페이지 삽입
 <jsp:param>   : <jsp:forward>,<jsp:include> 등과 함께 사용,
                                     파라미터를 추가하기 위해 사용
 <jsp:useBean> : bean을 생성하고 사용하기 위한 태그
 <jsp:setProperty> : bean의 속성값을 할당하기 위한 태그
 <jsp:getProperty> : bean의 속성값을 가져오기 위한 태그

 세개 요청처리하기
 /login  LoginServlet
 /main    MainServlet
 /logout  LogoutServlet
 요청은 각각 서블릿이 처리
 LoginServlet
 	임의의 아이디 비밀번호 와 입력한 아이디 비밀번호가 일치하면 로그인 처리 하고,
 	메인 요청 만들기( response.sendRedirect("main");)리다이렉트
 	일치하지 않으면, 로그인 화면으로 보내기 리다이렉트(loginForm.jsp)
 MainServlet
	 main 요청이 들어오면 main.jsp로 포워딩 해주기
	 단, 로그인이 되어 있을 때 loginForm.jsp으로 리다이렉트
	 로그인 상태가 아니면
 LogoutServlet
	 로그아웃 처리 하고, loginForm.jsp 로 Redirect

	**로그인/로그아웃 처리:
	로그인 처리 : 로그인을 하고, 브라우져가  꺼지지않으면 계속 로그인 상태라고 간주
	session.setAttribute("userid",입력한 아이디);

 	로그인 상태 확인 : session의 속성에 "userid" 가 있는지 없는지 확인해서
 	            있으면 로그인 상태, 없으면 로그인 상태가 아님

 	로그아웃 처리 : session의 속성에서 "userid" 삭제
 			  session.removeAttribute("userid");

 	**Servlet에서 Session에 접근하기
 	class: javax.servlet.http.HttpSession
 	얻어오는 함수 : request.getSession();
 	Session session = request.getSession();


 화면
 loginForm.jsp
	 아이디, 비밀번호, 로그인버튼
	 submit action : login
 main.jsp
	 아이디님 반갑습니다!
	 로그아웃 버튼
	<button onclick="location.href='logout'">로그아웃</button>







 

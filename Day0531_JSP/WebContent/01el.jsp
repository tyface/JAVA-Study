<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>표현언어</title>
<style type="text/css">
	body{
		height: 3000px;
	}
</style>
</head>
<body>
	<h1>표현언어 소개</h1>
	<p>표현언어(Expression Language)는 JSP에 값을 쉽게 표현하기 위한 언어입니다. </p>
	"HELLO"<br>
	<%="\"HELLO\"" %> <br>
	 ${"\"HELLO\""} <br>

	 <h2>EL 연산자</h2>
	 <%--
	 	+,-,*,/(div),%(mod) 의 산술연산자 사용가능
	    ==(eq), !=(ne) , <(lt)  , >(gt) , <=(le) , >=(ge)
	    &&(and), ||(or) , !(not)

		empty : 변수가 null인지 아닌지 검사하는 연산자

		3항조건 연산자
		조건식? 값1:값2;
	  --%>

	정수형 :  ${10} <br>
	실수형 :  ${10.1} <br>
 	문자열 :  ${"홍길동"} <br>
	논리형 :  ${false} <br>

    <h3>산술연산</h3>
	 \${5+2} : ${5+2} <br>
	 \${5/2} : ${5/2} <br>
<%-- 	 \${5 div 2} : ${5 div 2} <br> --%>
	 \${5 mod 2} : ${5 mod 2} <br>
 	<h3>비교연산</h3>
 	\${5 > 2} : ${5 > 2} <br>
 	\${5 gt 2} : ${5 gt 2} <br>
 	\${5 <= 2} : ${5 <= 2} <br>
 	\${5 le 2} : ${5 le 2} <br>
	 <h3>논리연산</h3>
	 \${(5>2) && (2>10)} : ${(5>2) && (2>10)} <br>
	 \${(5>2) || (2>10)} : ${(5>2) || (2>10)} <br>
	 \${(5>2) and (2>10)} : ${(5>2) and (2>10)} <br>
	 \${not(2>10)} : ${not(2>10)} <br>

	 <h2>기본객체</h2>
	 <h3>JSP에서 기본객체</h3>
	 <p>
	 pageContext<br>
	 request<br>
	 session<br>
	 application<br>
	 </p>
	 <h3>EL에서 기본객체</h3>
	 <p>
	 pageScope : pageContext<br>
	 requestScope : request<br>
	 sessionScope : session <br>
	 applicationScope : application<br>
	 param : request의 파라미터 정보를 포함하는 객체 <br>
	 </p>

	 <%-- JSP 기본객체에 attribute 넣기 --%>

	 <%
// 	 pageContext.setAttribute("name","page Name");
// 	 request.setAttribute("name","request Name");
	 session.setAttribute("name","session Name");
	 application.setAttribute("name","application Name");
	 %>
	 <h3>el로 기본객체 속성 꺼내오기 </h3>
	 page name : ${pageScope.name} <br>
	 request name : ${requestScope.name} <br>
	 session name : ${sessionScope.name} <br>
	 application name : ${applicationScope.name} <br>
	 

	 <%-- 'name'이라는 이름의 속성을 가져와서 화면에 출력
	 	page영역부터 시작해서 'name'이라는 속성을 검색해서 가져오는데
	 	해당영역에 'name'속성이 없으면
	 	page->request->session->application 순서로
	 	속성검색을 한다.
	  --%>

	 \${name} : ${name}  <br>

	 <h3>요청 파라미터 꺼내오기</h3>
	 <% String name = request.getParameter("name"); %>
	 <%=name %> <br>

	 ${param.name} <br>







</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	int num1;
	int num2;
	int result;
	public int multiply(int a,int b){
		return a*b;
	}
%> 
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>곱하기</title>
</head>
<body>
	<%--실제 명령문장 실행 --%>
	<%
		num1 = 5;
		num2 = 3;
		 result = multiply(5, 3);
		 //out 객체: 출력에 관한 기능을 가지고 있는 객체 
		 out.print(num1 + " X " + num2 + " = " + result);
	%> 
	
<%-- 	<%= num1 %> X <%=num2 %> = <%=result %> --%>
	
</body>
</html>







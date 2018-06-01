<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키 보기</title>
</head>
<body>
  <%
    //쿠키를 보기 위해서 요청에서 쿠키를 가져와야 한다.
    //쿠키가 여러개 일 수 있기 때문에 쿠키 배열로 가져와야 함
    Cookie[] cookies = request.getCookies();

    if(cookies != null && cookies.length > 0){
      for (int i = 0; i < cookies.length; i++ ) {
        %>
      		쿠키 이름 : <%=URLDecoder.decode(cookies[i].getName(),"UTF-8") %> <br>
        	쿠키 값 : <%=URLDecoder.decode(cookies[i].getValue(),"UTF-8")%> <hr>
        <%
      }
    }else{
    	%> 쿠키가 존재하지 않음<%
    }
  %>
</body>
</html>

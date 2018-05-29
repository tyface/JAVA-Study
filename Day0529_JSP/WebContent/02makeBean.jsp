<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Member" %>
<%--
	빈(bean)객체 하나 만들어서 포워드.
 --%>
<jsp:useBean id="member" class="model.Member" scope="request"></jsp:useBean>
<jsp:setProperty property="address" name="member" value ="서초구"/>
<%
	member.setId("bitcamp");
	member.setName("홍길동");
%>
<jsp:forward page="02useBean.jsp"/>

<%--
	<jsp:useBean id="s1"  class ="Student"  scope="request">
	javaBean: javaBean 규약에 맞춰서  클래스로 생성한 객체
	id = "s1" :  bean 인스턴스 이름, Student s1 = new Student();
	class : bean 객체의 참조 클래스
	scope : bean 라이프 사이클 관리
	       (default = page, request,session,application)


    <jsp:setProperty> : 빈의 속성을 설정하는 액션 태그
        name   : 속성지정하고자 하는 bean의 식별자(id)
        property : 설정하고자 하는 bean의 속성이름(setter의 이름)
        value   : 설정하고자 하는 값
    <jsp:getProperty>	빈객체의 속성을 가져오는 액션 태그

 --%>

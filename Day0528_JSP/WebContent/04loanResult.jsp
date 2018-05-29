<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Loan"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Loan Result</title>
<style type="text/css">
table, td, th {
	border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
}

table {
	margin: 0px auto;
}
</style>
</head>
<body>
	<%-- 요청에 포함된 파라미터를 받아와서, 데이터 기준으로 표만들기
	 --%>
	<table>
		<tr>
			<th>회차</th>
			<th>상환액</th>
			<th>상환원금</th>
			<th>이자</th>
			<th>상환총액</th>
			<th>대출잔액</th>
		</tr>

		<%-- tr 생성 부분을 for 문으로 작성 --%>
		<%
		ArrayList<Loan> loanList =  (ArrayList<Loan>)request.getAttribute("loanList");
			for (int i = 0; i < loanList.size(); i++) {
		%>
		<tr>
			<td><%=i+1%></td>
			<td><%=loanList.get(i).getRepayTotal() %></td>
			<td><%=loanList.get(i).getRepayOrigin() %></td>
			<td><%=loanList.get(i).getInterest() %></td>
			<td><%=loanList.get(i).getRepaySum() %></td>
			<td><%=loanList.get(i).getRepayRemain() %></td>
		</tr>
		<%
			}
		%>


	</table>
</body>
</html>

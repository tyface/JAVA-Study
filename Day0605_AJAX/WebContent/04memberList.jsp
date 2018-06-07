<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script type="text/javascript">
	/*
	   비동기 방식으로 요청/처리 하기
	  1.아이디 확인
	  2.회원가입 후 회원 목록가져오기
	 */
	$(function() {
		$("#userid").blur(function() {
			var id = $(this).val();
			$.ajax({
				url : "member",
				type : "post",
				data : {
					"command" : "checkId",
					"userid" : id
				},
				dataType : "text",
				success : function(idDup) {
					if (idDup == true) {
						$("#idDup").text(idDup);
					} else {
						$("#idDup").text(idDup);
					}
				},
				error : function(request, status, error) {
					alert("request: " + request);
					alert("status: " + status);
					alert("error: " + error);
				}

			});
		});

		$("#email").blur(function() {
			var email = $(this).val();
			$.ajax({
				url : "member",
				type : "post",
				data : {
					"command" : "checkEmail",
					"email" : email
				},
				dataType : "text",
				success : function(emailDup) {
					if (idDup == true) {
						$("#emailDup").text(emailDup);
					} else {
						$("#emailDup").text(emailDup);
					}
				},
				error : function(request, status, error) {
					alert("request: " + request);
					alert("status: " + status);
					alert("error: " + error);
				}

			});
		});

		$("#joinForm").on("submit", function() {
			var d = $(this).serialize();
			$.ajax({
				url : "member",
				type : "post",
				data : d,
				dataType : "text",
				success : function(result) {
					createList();
					if (result) {
						alert("회원가입성공");
					} else {
						alert("회원가입실패");
					}
				}
			});
			return false;
		});

		createList();

	});// end onLoad

	function createList() {
		//listTable 테이블에 회원목록을 조회해서 출력하는 함수
		var table = $("#listTable");

		$("#listTable tr:gt(0)").remove();

		$.ajax({
			url : "member?command=memberList",
			type : "get",
			dataType : "json",
			success : function(data) {

				for ( var i in data) {
					var tr = $("<tr>");
					var btn = $("<input type=\"button\" class=\"btn\"  value=\"삭제\">");
					
					$("<td>").text(data[i].id).appendTo(tr);
					$("<td>").text(data[i].email).appendTo(tr);
					$("<td>").text(data[i].name).appendTo(tr);
					$("<td>").append(btn).appendTo(tr)
					
					btn.on("click", function() {
						var id = $(this).parent().prev().prev().prev().text();
						$.ajax({
							url : "member?command=deleteMember",
							type : "post",
							data : {"userid" : id},
							dataType : "text",
							success : function(result) {
								if (result == "true") {
									alert("회원삭제 성공");
								} else {
									alert("회원삭제 실패");
								}
								createList();
							}
						});
					});
					tr.appendTo(table);
				}

			}
		});

		return false;
	}
</script>
</head>
<body>

	<form name="joinForm" method="post" id=joinForm>
		<input type="hidden" name="command" value="join">
		<table border="1">
			<tr bgcolor="gray">
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
			</tr>
			<tr>
				<td><input type="text" name="userid" id="userid"><span
					id="idDup">아이디중복여부</span></td>
				<td><input type="password" name="password" id="password"></td>
				<td><input type="text" name="name" id="name"></td>
				<td><input type="text" name="email" id="email"><span
					id="emailDup">이메일중복여부</span></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="가입하기" id="joinBtn"></td>
			</tr>
		</table>
	</form>
	<h2>회원 목록</h2>
	<table id="listTable" border="1">
		<colgroup>
			<col width="150px">
			<col width="250px">
			<col width="100px">
		</colgroup>
		<tr bgcolor="gray">
			<th>아이디</th>
			<th>이메일</th>
			<th>이름</th>
			<th>삭제</th>
		</tr>
	</table>

</body>
</html>

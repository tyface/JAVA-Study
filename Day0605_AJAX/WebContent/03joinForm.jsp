<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script type="text/javascript">
	$(function() {
		// $("#memberForm").on("submit", function() {
		// 	//폼요소에 있는 데이터를 서버로 전송, ajax를 이용해서
		// 	var d = $(this).serialize();
		// 	alert("d:" + d);
		// 	$.ajax({
		// 		url : "member",
		// 		type : "get",
		// 		data : {
		// 			"d" : d
		// 		},
		// 		dataType : "json",
		// 		sucsses : function(data) {
		// 		}
		//
		// 	});
		// 	return false;
		// });

		$("#userId").blur(function() {
			var id  = $(this).val();
			$.ajax({
				url : "checkId",
				type : "post",
				data : {
					"userId" : id
				},
				dataType : "text",
				success : function(result) {
					if(result == true){
						$("#idResult").text(result);
					}else{
						$("#idResult").text(result);
					}
				},
				error : function(request,status,error,result){
					  alert("request: " + request);
					  alert("status: " + status);
					  alert("error: " + error);
					  alert("erresultror: " + result);
				}

			});
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="join" name="memberForm" id="memberForm" method="post">
		<fieldset>
			<legend>회원가입</legend>

			<p>
				아이디: <input type="text" name="userId" id="userId" value=""><span id="idResult">11</span>
			</p>
			<p>
				이름: <input type="text" name="name" value="">
			</p>
			<p>
				이메일: <input type="text" name="email" value="">
			</p>
		</fieldset>
		<input type="submit" name="" value="전송">
	</form>

</body>
</html>

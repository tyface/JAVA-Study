<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
<script type="text/javascript">
  function doAjax(){
    var d = "Hello Server";
    $.ajax({
      url : "hello",
      type : "post",
      data : {"d" : d},
      dataType: "json",
      success : function(data){
       	alert("data.msg: " + data.msg);
        $("#txt1").text(data.msg);
      },
	  error : function(request,status,error){
		  alert("request: " + request);
		  alert("status: " + status);
		  alert("error: " + error);
	  }
    });
  }

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 비동기 방식을 이용해서 document.txt 에 있는 내용을
		가져와서 d1요소에 넣기
	 -->
	<h1 id ="txt1"></h1>
	<button onclick="doAjax();">요청</button>
</body>
</html>

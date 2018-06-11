<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	//비밀번호가 맞았을 때, 팝업화면에서 계속 요청진행이 아니라
	//큰화면에서 요청을 진행 하도록 하는 기능
	var url;
	if(window.name == "update"){
		url = "board?command=board_update_form&num=${param.num}";
	} else if (window.name == "delete"){
		url = "board?command=board_delete&num=${param.num}";
	}
	window.opener.parent.location.href = url;
	window.close();	
</script>
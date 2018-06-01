<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	var msg = "<%=request.getAttribute("msg")%>";
	
	if (msg != null) {
		alert(msg);
	}
	location.href="<%=request.getAttribute("pass")%>";
</script>

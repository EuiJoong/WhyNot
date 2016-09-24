<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 구매후 세션 리셋을 위한 페이지 -->
<html>
<head>
<script type="text/javascript">
	function loginGo() {
		alert("구매 성공!!");
		document.f.submit();
	}
</script>
</head>
<body onload="loginGo()">
	<form action="login.payment" name="f" method="post">
		<input type="hidden" name="mnum" value="${mnum }"> 
		<input type="hidden" name="ocnum" value="${ocnum }">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script type="text/javascript">
	function loginGo() {
		alert("getLogin.jsp.....");
		document.f.submit();
	}
</script>
</head>
<body onload="loginGo">
	<form action="login.payment" name="f" method="post">
		<input type="hidden" name="ocnum" value="${ocnum }">
	</form>
</body>
</html>
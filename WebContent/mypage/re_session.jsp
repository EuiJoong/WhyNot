<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 사진변경후 세션 리셋을 위한 페이지 -->
<html>
<head>
<script type="text/javascript">
	function loginGo() {
		alert("사진 변경 성공!!");
		document.f.submit();
	}
</script>
</head>
<body onload="loginGo()">
	<form action="session.mypage" name="f" method="post">
		<input type="hidden" name="mnum" value="${mnum }"> 
	</form>
</body>
</html>
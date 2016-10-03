<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 구매후 세션 리셋을 위한 페이지 -->
<html>
<head>
<script type="text/javascript">
	function loginGo() {
		alert("등록되지 않은 아이디이거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다.");
		location.href="index.jsp";
	}
</script>
</head>
<body onload="loginGo()">
</body>
</html>
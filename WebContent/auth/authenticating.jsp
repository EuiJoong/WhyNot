<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="id" value="${id }" />
<c:set var="auth" value="${auth }" />
<c:if test="${id != null}">
	<script type="text/javascript">
		alert("재인증이 필요합니다!")
	</script>
</c:if>
<c:if test="${auth != null}">
	<script type="text/javascript">
		alert("계정이 비활성화 상태입니다!")
	</script>
</c:if>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div><h1>인증확인 메일을 가입하신 이메일 주소로 발송하였습니다.</h1></div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="id" value="${id }" />
<c:set var="auth" value="${auth }" />
<c:if test="${id != null}">
	<script type="text/javascript">
		alert("�������� �ʿ��մϴ�!")
	</script>
</c:if>
<c:if test="${auth != null}">
	<script type="text/javascript">
		alert("������ ��Ȱ��ȭ �����Դϴ�!")
	</script>
</c:if>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div><h1>����Ȯ�� ������ �����Ͻ� �̸��� �ּҷ� �߼��Ͽ����ϴ�.</h1></div>
</body>
</html>
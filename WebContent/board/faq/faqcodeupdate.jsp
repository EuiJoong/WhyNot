<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../admin/admintop.jsp"%>
<html>
<head>
<title>Code 수정</title>
<script type="text/javascript">
	function chk_update() {
		if(f.name.value==""){
			alert("코드이름 을 입력해주세요");
			return false;
		}
		
		return true;
	}


</script>
</head>
<body>
<form name="f" action="faqcodeUpdate_pro.faq" method="post" onsubmit="return chk_update()">
<table border="1"  align="center" >
	<tr>
	<th>Code</th>
	<td><input type="text" name="code" value="${code}" readonly="readonly"></td>
	</tr>
	<tr>
	<th>Code이름</th>    
	<td><input type="text" name="name" ></td>
	</tr>
	<tr>
	<td colspan="2">
	<input type="submit" value="전송">
	</td>
	</tr>
</table>
</form>
</body>
</html>
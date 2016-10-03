<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	function chk() {

		
		var exptextId = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
		
		if (exptextId.test(document.f.id.value) == false) {
			//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우
			alert("아이디 양식이 올바르지 않습니다.");
			document.f.id.focus();
			return;
		}

		document.f.submit();
	}
</script>


<div align="center" >


<c:choose>
<c:when test="${msg eq '중복'}">
<script type="text/javascript">
    alert('${msg}');
</script>
</c:when>
</c:choose>


	<form name="f" action="idChkpro.member" method="post">
	<table border="1" width="300" >
		<caption>아이디 확인</caption>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="확인" onclick= "chk()">
				<input type="button" value="종료" onclick="self.close()">
			</td>
		</tr>
	</table>
	</form>
</div>
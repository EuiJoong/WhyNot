<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admintop.jsp"%>

<div align="center" style="width: 80%; float: right;">


<c:if test="${msg eq '중복!'}">
<script type="text/javascript">
    alert('${msg}');
</script>
</c:if>
 
	<form name="f" action="chk.cate" method="post">
	<table border="1" width="300" >
		<caption>카테고리 등록</caption>
		<tr>
			<th>카테고리 이름</th>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="등록">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
	</form>
</div>
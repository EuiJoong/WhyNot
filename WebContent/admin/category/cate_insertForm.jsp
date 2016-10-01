<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admintop.jsp"%>

<div align="center" style="width: 80%; float: right;">


<c:choose>
<c:when test="${msg eq '중복!'}">
<script type="text/javascript">
    alert('${msg}');
</script>
</c:when>
<c:when test="${msg eq '값을 입력하세요!' }">
<script type="text/javascript">
    alert('${msg}');
</script>
</c:when>
<c:otherwise></c:otherwise>
</c:choose>


<c:if test="">

</c:if>
 
	<form name="f" action="chk.cate" method="post">
	<table border="1" style=" width=300; margin-top: 5em;" >
		<tr><td colspan="2" style="text-align: center;">카테고리 등록</td></tr>
		<tr>
			<th>카테고리 이름</th>
			<td><input type="text" name="name" class="form-control"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" class="btn btn-default" value="등록">
				<input type="reset" class="btn btn-default" value="취소">
			</td>
		</tr>
	</table>
	</form>
</div>
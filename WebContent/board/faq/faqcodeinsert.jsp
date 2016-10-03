<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../admin/admintop.jsp"%>
<script type="text/javascript">
	function checkCode() {
		if(f.code.value==""){
			alert("코드를 입력해주세요");
			f.code.focus();
			return false;
		}else if(f.name.value==""){
			alert("코드 이름을  입력해주세요");
			f.name.focus();
			return false;
		}
			return true;
	}
</script>


<c:choose>
<c:when test="${msg eq null}">
</c:when>
<c:otherwise>
<script type="text/javascript">
  	alert('${msg}');
</script>
</c:otherwise>
</c:choose>


<div style="width: 80%; float: right;">
	<div align="center">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">FAQ코드 생성</div>
	<form name="f" action="faqcodeinsert_pro.faq" method="post" onsubmit="return checkCode()" >
			<!-- Table -->
			<table class="table">
		<tr>
		<th>코드번호 :</th>
		<td>
		<input  class="form-control" type="text" name="code" >
		</td>
		</tr>
	
	
	
	
	<tr>
	<th>이름 : </th>
	<td>
	<input type="text" name="name" class="form-control">
	</td>
	</tr>
	<tr>
	<td colspan="2"  align="right">
			<input type="submit" class="btn btn-default" value="전송">
		<input type="reset" class="btn btn-default"  value ="다시">
	</td>
	</tr>
</table>
</form>
	</div>
	</div>
</div>


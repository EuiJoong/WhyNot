<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../admin/admintop.jsp"%>
<title>FAQ 게시판 생성</title>
<script type="text/javascript">
	function chk_board() {
		
		if(f.title.value==""){
			alert("제목을 입력하세요");
			f.title.focus;
			return false;
		}else if(f.content.value==""){
			alert("내용을 입력하세요");
			f.content.focus;
			return false;
		}
	}



</script>
<div style="width: 80%; float: right;">
	<div align="center">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">FAQ게시판 수정</div>
<form  name="f" action="faqboardUpdate_pro.faq" method="post"  onsubmit="return chk_board()" >
<input type="hidden" name ="qnum" value="${qnum}">
<table class="table">
<tr>
<th>카테고리 선택</th>
<td>
<select name="faq_code">
<c:forEach var="codedto" items="${list}">
<option value="${codedto.code}">${codedto.code} : ${codedto.name}</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<th>제목</th>
<td><input type="text"  name="title" class="form-control" value="${boardDto.title}"></td>
</tr>
<tr>
<th>내용</th>
<td>
<textarea  name = "content" rows='10' cols='93' class="form-control">${content}</textarea>
</td>
</tr>
<tr>
	<td colspan="2"  align="right">
	<input type="submit" value="전송" class="btn btn-default" >
	<input type="reset" value="다시 입력" class="btn btn-default"s>
</td>
</tr>
</table>
</form>
</div>
</div>
</div>
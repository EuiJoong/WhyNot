<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../admin/admintop.jsp"%>
	<title>spring-board</title>
<c:choose>
<c:when test="${msg eq null}">
</c:when>
<c:otherwise>
<script type="text/javascript">
	alert("${msg}");
</script>
</c:otherwise>
</c:choose>


<div style="width: 80%; float: right;">
	<div align="center">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">FAQ게시판 목록</div>

			<!-- Table -->
			<table class="table">
		<tr align="center">
		<td><a href="faqcodeinsert.faq">FAQ코드 생성</a> </td>
	</tr>
	<tr align="center">
	<td><a href="faqcodelist.faq">FAQ코드 목록</a></td>
	</tr>
	
	<tr align="center">
	<td><a href="faqboardinsert.faq">FAQ게시판  글 작성</a></td>
	</tr>
	
	<tr align="center">
	<td><a href="Faqboardlist.faq">FAQ게시판</a></td>
	</tr>
			</table>
		</div>
	</div>
</div>

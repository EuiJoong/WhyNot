<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../admin/admintop.jsp"%>
	
	
	<div style="width: 80%; float: right;">
	<div align="center">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">FAQ게시판 글작성</div>
	<table class="table">
		<tr>
			<th>Code번호</th>
			<th>Code이름</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	<c:choose>
	<c:when test="${list.size()==0}">
		Code 가 존재 하지 않습니다.
	</c:when>
	<c:otherwise>
		<c:forEach var="dto" items="${list}">
				<tr>
			<td>${dto.code}</td>	
			<td>${dto.name}</td>
			<td><a href="faqcodeUpdate.faq?code=${dto.code}">수정</a></td>
			<td><a href="faqcodeDelete.faq?code=${dto.code}">삭제</a></td>
			</tr>	
		</c:forEach>
		</c:otherwise>
	</c:choose>
	</table>
</div>
</div>
</div>
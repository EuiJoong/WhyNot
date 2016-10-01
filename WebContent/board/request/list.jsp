<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../../top.jsp"%>
<c:set var="memberDTO" value="${sessionScope.memberDTO}" />
<c:set var="count" value="${count}" />
<div align="center" style="margin-top: 5em;">
	<b>글 목 록</b>
	<p>
</div>
<div align="center">
	<table style="width: 80%">
		<tr>
			<td><b style="float: left;">총 [${count}]개의 글이 있습니다.</b> <a
				href="insertFrom.requestboard?id=${memberDTO.id}&mnum=${memberDTO.mnum}"
				style="float: right;">글쓰기</a>
		</tr>
	</table>
</div>
<div align="center">
	<table border="1" style="width: 80%">
		<tr bgcolor="green">
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회</th>
			<th>추천</th>
		</tr>
		<c:forEach var="dto" items="${pushboardList}">

			<tr>
				<td>${dto.bnum}</td>
				<td><a
					href="content.requestboard?bnum=${dto.bnum}&mnum=${memberDTO.mnum}">
						${dto.subject}</a></td>
				<td>${dto.id}</td>
				<td>${dto.reg_date}</td>
				<td>${dto.readcount}</td>
				<td>${dto.push}</td>
			</tr>
		</c:forEach>
	</table>
</div>
<div align="center">
	<c:set var="pageCount" value="${pageCount}" />
	<c:set var="pageBlock" value="${pageBlock}" />
	<c:set var="startPage" value="${startPage }" />
	<c:set var="endPage" value="${endPage}" />

	<c:if test="${count > 0}">
		<c:if test="${endPage > pageCount}">
			<c:set var="endPage" value="${pageCount}" />
		</c:if>
		<c:if test="${startPage > pageBlock}">
         [<a href="list.requestboard?pageNum=${startPage-pageBlock}">이전</a>]
      </c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
         [<a href="list.requestboard?pageNum=${i}">${i}</a>]
      </c:forEach>
		<c:if test="${endPage < pageCount}">
         [<a href="list.requestboard?pageNum=${startPage+pageBlock}">다음</a>]
      </c:if>
	</c:if>
</div>
<%@include file="../../bottom.jsp"%>
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
<div style="width: 80%;">
	<table>
	<tr><td>
	<b style="float: left;">총 [${count}]개의 글이 있습니다.</b>
	<a href="insertFrom.freeboard?name=${memberDTO.name}&mnum=${memberDTO.mnum}" style="float: right;">글쓰기</a>
	</td></tr></table>
</div>
<div align="center" style="width:80%">
	<table border="1" >
		<tr bgcolor="green">
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회</th>
		</tr>
		<c:forEach var="dto" items="${freeboardList}">

			<tr>
				<td>${dto.bnum}</td>
				<td><a
					href="content.freeboard?bnum=${dto.bnum}&mnum=${memberDTO.mnum}&name=${memberDTO.name}">
						${dto.subject}</a></td>
				<td>${dto.name}</td>
				<td>${dto.reg_date}</td>
				<td>${dto.readcount}</td>
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
         [<a href="list.freeboard?pageNum=${startPage-pageBlock}">이전</a>]
      </c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
         [<a href="list.freeboard?pageNum=${i}">${i}</a>]
      </c:forEach>
		<c:if test="${endPage < pageCount}">
         [<a href="list.freeboard?pageNum=${startPage+pageBlock}">다음</a>]
      </c:if>
	</c:if>
</div>
<%@include file="../../bottom.jsp"%>
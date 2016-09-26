<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../admin/admintop.jsp"%>
<div style="width: 80%; float: right;">
	<div align="center">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">이벤트 목록</div>

			<!-- Table -->
			<table class="table">
				<tr>
				<th>이벤트 번호</th>
				<th>이벤트 제목</th>
				<th>마감일</th>
				<th>비고</th>
			</tr>
			<c:choose>
				<c:when test="${eventList.size() == 0 }">
					<tr>
						<td align="center" colspan="4">등록된 이벤트가 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="eventDto" items="${eventList }">
						<tr>
							<td><c:out value="${eventDto.eventNum }" /></td>
							<td><c:out value="${eventDto.eventTitle }" /></td>
							<td><c:out value="${eventDto.deadLine }" /></td>
							<td><a
								href="update.event?eventNum=${eventDto.eventNum}">수정</a> | <a href="delete.event?eventNum=${eventDto.eventNum}">삭제</a></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			</table>
		</div>
		<a href="insert.event">이벤트 등록</a>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../admin/admintop.jsp"%>
<div style="width: 80%; float: right;">
	<div align="center">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">강연 후보자 목록</div>

			<!-- Table -->
			<table class="table">
				<tr>
				<th>이벤트 번호</th>
				<th>후보 번호</th>
				<th>후보 이름</th>
				<th>득표수</th>
			</tr>
			<c:choose>
				<c:when test="${cateList.size() == 0 }">
					<tr>
						<td colspan="3">등록된 카테고리가 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="cateDto" items="${cateList }">
						<tr>
							<td><c:out value="${cateDto.ctnum }" /></td>
							<td><c:out value="${cateDto.name }" /></td>
							<td><a
								href="update.cate?ctnum=${cateDto.ctnum}">수정</a> | <a href="delete.cate?ctnum=${cateDto.ctnum}">삭제</a></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			</table>
		</div>
		<a href="insert.poll">후보자 등록</a>
	</div>
</div>
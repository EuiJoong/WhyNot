<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../admintop.jsp"%>
<div style="width: 80%; float: right;">
	<div align="center">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">카테고리 목록</div>

			<!-- Table -->
			<table class="table">
				<tr>
				<th>번호</th>
				<th>카테고리 명</th>
				<th>비고</th>
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
	</div>
</div>

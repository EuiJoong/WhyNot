<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../admin/admintop.jsp"%>

<div style="width: 80%; float: right;">
	<div align="center">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">후보자 목록</div>

			<!-- Table -->
			<table class="table">
				<tr>
				<th>후보자 번호</th>
				<th>후보자 이름</th>
				<th>득표수</th>
				<th>이벤트 번호</th>
				<th>비고</th>
			</tr>
			<c:choose>
				<c:when test="${nomineeList.size() == 0 }">
					<tr>
						<td align="center" colspan="5">등록된 후보자가 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="nomineeDto" items="${nomineeList }">
						<tr>
							<td><c:out value="${nomineeDto.nomiNum }" /></td>
							<td><c:out value="${nomineeDto.nomiName }" /></td>
							<td><c:out value="${nomineeDto.score }" /></td>
							<!-- 이벤트번호 어떻게 참조할것인지 -->
							<td><c:out value="${nomineeDto.eventNum }" /></td>
							<td><a
								href="update.nominee?nomiNum=${nomineeDto.nomiNum}">수정</a> | <a href="delete.nominee?nomiNum=${nomineeDto.nomiNum}">삭제</a></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			</table>
		</div>
		<a href="insert.nominee">후보자 등록</a>
	</div>
</div>
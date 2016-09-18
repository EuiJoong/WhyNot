<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../admintop.jsp"%>
<div style="width: 80%; float: right;">
	<div align="center">
	 	<table width="500" style="text-align: center;" align="center">
			<tr>
				<td width="25%"></td>
				<td width="50%">회원 목록</td>
				<td align="right" width="25%"><a href="#">추가</a></td>
			</tr>
		</table>
		<table border="1" width="500" style="text-align: center;">
			<tr>
				<th>번호</th>
				<th>카테고리 명</th>
				<th>비고</th>
			</tr>
			<c:choose>
				<c:when test="${memberList.size() == 0 }">
					<tr>
						<td colspan="3">등록된 회원이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="memberDTO" items="${memberList }">
						<tr>
							<td><c:out value="${memberDTO.ctnum }" /></td>
							<td><c:out value="${memberDTO.name }" /></td>
							<td><a href="delete.member?ctnum=${memberDTO.mnum}">삭제</a><a href="update.member?ctnum=${memberDTO.mnum}">수정</a></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
</div>

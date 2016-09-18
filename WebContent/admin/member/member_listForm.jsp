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
					<th>회원번호</th>
					<th>아이디</th>
					<th>이름</th>
					<th>성별</th>
					<th>생년월일</th>
					<th>취미</th>
					<th>마일리지</th>
					<th>등급</th>
					<th>가입일</th>
					<th>계정상태</th>
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
								<td><c:out value="${memberDTO.mnum }" /></td>
								<td><c:out value="${memberDTO.id }" /></td>
								<td><c:out value="${memberDTO.name }" /></td>
								<td><c:out value="${memberDTO.gender }" /></td>
								<td><c:out value="${memberDTO.birth }" /></td>
								<td><c:out value="${memberDTO.interest }" /></td>
								<td><c:out value="${memberDTO.mileage }" /></td>
								<!-- memberDTO.grade : 1 관리자 3 일반 -->
								<c:choose>
									<c:when test="${memberDTO.grade == 3 }">
										<td><c:out value="일반" /></td>
									</c:when>
									<c:otherwise>
										<td><c:out value="관리자" /></td>
									</c:otherwise>
								</c:choose>
								<td><c:out value="${memberDTO.joindate }" /></td>
								<td><c:out value="${memberDTO.acstagte }" /></td>
								<td><a href="grade.member?ctnum=${memberDTO.mnum}">등급</a>
									| <a href="acstagte.member?ctnum=${memberDTO.mnum}">제재</a> |<a
									href="delete.member?ctnum=${memberDTO.mnum}">삭제</a></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</div>
</div>

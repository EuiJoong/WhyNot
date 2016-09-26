<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../admin/admintop.jsp"%>

<div align="center" style="width: 80%; float: right;">
	
	<form name="f" action="insertPro.nominee" method="post">
		<br>
		<table border="1" width="400" >
		<caption>후보자 등록</caption>
		<tr>
			<th>후보자 이름</th>
			<td><input type="text" name="nomiName"></td>
		</tr>
		<tr>
			<th>참여 이벤트 회차</th>
			<c:choose>
				<c:when test="${eventNumList.size() == 0 }">
					<td align="center" colspan="2">등록된 이벤트가 없습니다.</td>
				</c:when>
				<c:otherwise>
					<td colspan="2">
					<select name="eventNum">
						<c:forEach var="nomi" items="${eventNumList }">
							<option value="${nomi.eventNum }">${nomi.eventNum }</option>
						</c:forEach>
					</select>
					</td>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="등록">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
	</form>
	<a href="list.nominee">뒤로가기</a>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../admin/admintop.jsp"%>

<div align="center" style="width: 80%; float: right;">
	<form name="f" action="updatePro.event" method="post">
	<input type="hidden" name="eventNum" value="${eventDTO.eventNum }">
		<br>
		<table border="1" width="400" >
		<caption>이벤트 수정</caption>
		<tr>
			<th>이벤트 제목</th>
			<td><input type="text" name="eventTitle" value="${eventDTO.eventTitle }"></td>
		</tr>
		<tr>
			<td align="center" colspan="2">기존 마감일은 '${eventDTO.deadLine }' 입니다</td>
		</tr>
		<tr>
			<th>마감일</th>
			<td>
				<select name="dateYY">
					<c:forEach var="yyyy" begin="2016" end="2020">
						<option value="${yyyy }">${yyyy }</option>
					</c:forEach>
				</select>
				<select name="dateMM">
					<c:forEach var="mm" begin="1" end="12">
						<option value="${mm }">${mm }</option>
					</c:forEach>
				</select>
				<select name="dateDD">
					<c:forEach var="dd" begin="1" end="31">
						<option value="${dd }">${dd }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="등록">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
	</form>
	<a href="list.event">뒤로가기</a>
</div>
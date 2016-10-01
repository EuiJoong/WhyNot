<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../../top.jsp"%>
<div align="center">
	<b>글 내 용 보 기</b>
	<table border="1" width="80%">
		<tr>
			<th bgcolor="Aqua">글번호</th>
			<td align="center">${boardDTO.bnum}</td>
			<th bgcolor="Aqua">조회수</th>
			<td align="center">${boardDTO.readcount}</td>
			<th bgcolor="Aqua">추천</th>
			<td align="center">${boardDTO.push}</td>
		</tr>
		<tr>
			<th bgcolor="Aqua">작성자</th>
			<td align="center">${boardDTO.id}</td>
			<th bgcolor="Aqua">작성일</th>
			<td align="center" colspan="3">${boardDTO.reg_date}</td>
		</tr>
		<tr>
			<th bgcolor="Aqua">글제목</th>
			<td align="center" colspan="5">${boardDTO.subject}</td>
		</tr>
		<tr>
			<th bgcolor="Aqua" COLSPAN="6" align="center">글내용</th>
		</tr>
		<tr>
			<td VALIGN="top" colspan="6" height="400" width="100%">${boardDTO.content}</td>
		</tr>
		<tr>
			<td bgcolor="Aqua" align="right" colspan="6"><c:choose>
					<c:when test="${cchk==true}">
						<input type="button" value="글수정"
							onClick="window.location='updateform.requestboard?bnum=${boardDTO.bnum}&mnum=${boardDTO.mnum}'">
						<input type="button" value="글삭제"
							onClick="window.location='delete.requestboard?bnum=${boardDTO.bnum}'">
						<input type="button" value="글목록"
							onClick="window.location='list.requestboard'">
					</c:when>
					<c:otherwise>
						<input type="button" value="추천"
							onClick="window.location='push.requestboard?bnum=${boardDTO.bnum}'">
						<input type="button" value="글목록"
							onClick="window.location='list.requestboard'">
					</c:otherwise>
				</c:choose></td>
		</tr>
	</table>

</div>
<%@include file="../../bottom.jsp"%>















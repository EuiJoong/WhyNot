<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../../top.jsp"%>
<div align="center" style="margin-top: 5em;">
	<b>글 내 용 보 기</b>
	<table border="1" width="80%">
		<tr>
			<th bgcolor="yellow">글번호</th>
			<td align="center">${boardDTO.bnum}</td>
			<th bgcolor="yellow">조회수</th>
			<td align="center">${boardDTO.readcount}</td>
		</tr>
		<tr>
			<th bgcolor="yellow">작성자</th>
			<td align="center">${boardDTO.name}</td>
			<th bgcolor="yellow">작성일</th>
			<td align="center">${boardDTO.reg_date}</td>
		</tr>
		<tr>
			<th bgcolor="yellow">글제목</th>
			<td align="center" colspan="3">${boardDTO.subject}</td>
		</tr>
		<tr>
			<th bgcolor="yellow" COLSPAN="4" align="center">글내용</th>
		</tr>
		<tr>
			<td VALIGN="top" colspan="4" height="400" width="100%">${boardDTO.content}</td>
		</tr>
		<tr>
			<td bgcolor="yellow" align="right" colspan="4"><c:choose>
					<c:when test="${cchk==true}">
						<input class="btn btn-default" type="button" value="글수정"
							onClick="window.location='updateform.freeboard?bnum=${boardDTO.bnum}&mnum=${boardDTO.mnum}&re_step=${boardDTO.re_step}&re_level=${boardDTO.re_level}'">
						<input class="btn btn-default" type="button" value="글삭제"
							onClick="window.location='delete.freeboard?bnum=${boardDTO.bnum}'">
						<input class="btn btn-default" type="button" value="글목록"
							onClick="window.location='list.freeboard'">
					</c:when>
					<c:otherwise>
						<input type="button" class="btn btn-default" value="글목록"
							onClick="window.location='list.freeboard'">
					</c:otherwise>
				</c:choose></td>
		</tr>
	</table>

	<table border="1" width="80%">
		<c:choose>
			<c:when test="${commentlist != null}">
				<c:forEach var="com" items="${commentlist}">
					<tr>
						<td width="15%">${com.name}</td>
						<td width="80%">${com.content}</td>
						<td><c:choose>
								<c:when test="${com.mnum==mnum}">
									<a
										href="delete.comment?cbnum=${com.cbnum}&bnum=${bnum}&mnum=${mnum}">삭제</a>

									<!-- <input type="button" style="float: Right;" value="삭제" onClick="window.location='delete.comment?cbnum=${com.cbnum}&bnum=${bnum}&mnum=${mnum}'">
		 -->
								</c:when>
								<c:otherwise>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<form action="insert.comment" method="post">
		<input type="hidden" name="bnum" value="${bnum}" /> <input
			type="hidden" name="name" value="${name}" /> <input type="hidden"
			name="mnum" value="${mnum}" />
		<table style="width: 80%" border="1">
			<tr>
				<td><textarea cols=130 rows=2 style="float: left;"
						name="content"></textarea> <input class="btn btn-default"
					type="submit" style=" width:17%; height: 130%;" value="댓글달기"></td>
			</tr>
		</table>
	</form>
</div>
<%@include file="../../bottom.jsp"%>















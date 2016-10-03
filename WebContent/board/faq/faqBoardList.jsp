<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${memberDTO.grade==1}">
		<%@ include file="../../admin/admintop.jsp"%>
	</c:when>
	<c:otherwise>
		<%@ include file="../../top.jsp"%>
	</c:otherwise>
</c:choose>
<style>
body {
	font-family: Arial, Helvetica, Sans-Serif;
	font-size: 1.2em;
}

#report {
	border-collapse: collapse;
	width: 700px
}

#report h4 {
	margin: 0px;
	padding: 0px;
}

#report th {
	background: #7CB8E2 url(header_bkg.png) repeat-x scroll center left;
	color: #fff;
	padding: 15px 15px;
	text-align: left;
}

#report td {
	background: #C7DDEE none repeat-x scroll center left;
	color: #000;
	padding: 7px 15px;
}

#report tr.odd td {
	background: #fff url(row_bkg.png) repeat-x scroll center left;
	cursor: pointer;
}

#report div.arrow {
	background: transparent url(arrows.png) no-repeat scroll 0px -16px;
	width: 16px;
	height: 16px;
	display: block;
}

#report div.up {
	background-position: 0px 0px;
}

a:link {
	color: red;
	text-decoration: none;
}

a:visited {
	color: black;
	text-decoration: none;
}

a:hover {
	color: blue;
	text-decoration: underline;
}
</style>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<!-- 아코디언 -->
<script>
	$(document).ready(function() {

		$("#report tr:odd").addClass("odd");
		$("#report tr:not(.odd)").hide();
		$("#report tr:first-child").show(); //열머리글 보여주기

		$("#report tr.odd").click(function() {
			$(this).next("tr").toggle();
			$(this).find(".arrow").toggleClass("up");

		});

	});
</script>
<!--  FAQ 게시판 리스트     -->
<c:choose>
	<c:when test="${memberDTO.grade == 1 }">
		<div align="center" style="width: 80%; float: right;">
	</c:when>
	<c:otherwise>
		<div align="center">
	</c:otherwise>
</c:choose>
<table id="report" border="1" rules=groups style="width: 80em; margin-top: 5em;">
	<tr>
		<c:choose>
			<c:when test="${codelist.size() ==0 }">
				<h1>등록된글이 없습니다.</h1>
			</c:when>
			<c:otherwise>
				<th><a href="Faqboardlist.faq">전체</a></th>
				<c:forEach var="dto" items="${list}">
					<th><a href="faqboard.faq?code=${dto.code}">${dto.name}</a></th>
				</c:forEach>
				<c:choose>
					<c:when test="${memberDTO.grade == 1 }">
						<th></th>
						<th></th>
					</c:when>
				</c:choose>
			</c:otherwise>
		</c:choose>

	</tr>

	<!--  전체 리스트 -->
	<c:forEach var="wholeboardDto" items="${wholeboardlist}">
		<tr>
			<c:choose>
				<c:when test="${memberDTO.grade == 1 }">
					<td colspan="${count+1}">Q : ${wholeboardDto.title}</td>
					<td><a href="FaqBoardUpdate.faq?qnum=${wholeboardDto.qnum}">수정</a></td>
					<td><a href="FaqBoardDelete.faq?qnum=${wholeboardDto.qnum}">삭제</a></td>
				</c:when>
				<c:otherwise>
					<td colspan="${count+3}">Q : ${wholeboardDto.title}</td>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<td colspan="${count+3}" style="">A : ${wholeboardDto.content}</td>
		</tr>
	</c:forEach>



	<!--  세부  리스트 -->
	<c:choose>
		<c:when test="${boardlist.size()==0}">
			<tr>
				<td colspan="${count+3}">준비중입니다..</td>
			</tr>
		</c:when>
		<c:when test="${wholeboardlist.size()!=0}">
			<c:forEach var="faqboardDto" items="${boardlist}">
				<tr>
					<c:choose>

						<c:when test="${memberDTO.grade == 1 }">
							<td colspan="${count+1}">Q : ${faqboardDto.title}</td>
							<td><a href="FaqBoardUpdate.faq?qnum=${faqboardDto.qnum}">수정</a></td>
							<td><a href="FaqBoardDelete.faq?qnum=${faqboardDto.qnum}">삭제</a></td>
						</c:when>
						<c:otherwise>
							<td colspan="${count+3}">Q : ${faqboardDto.title}</td>
						</c:otherwise>
					</c:choose>
				</tr>
				<tr>
					<td colspan="${count+3}" style="">A : ${faqboardDto.content}</td>
				</tr>
			</c:forEach>
		</c:when>
	</c:choose>
</table>
<c:choose>
	<c:when test="${memberDTO.grade == 1 }">
		</div>
	</c:when>
	<c:otherwise>
		</div>
	</c:otherwise>
</c:choose>
</body>
<c:if test="${memberDTO.grade!=1}">
	<%@ include file="../../bottom.jsp"%>
</c:if>
</html>
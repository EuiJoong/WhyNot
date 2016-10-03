<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="ko">

<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- adminmain.min.css Core CSS -->
<link href="css/adminmain.min.css" rel="stylesheet">
<title>공지사항 목록</title>
</head>
<body>
	<c:set var="listNoticeNormal" value="${listNoticeNormal }" />
	<ul class="list-group"
		style="float: left; width: 20%; position: fixed;">
		<li class="list-group-item"><a href="listNoticeEvent.notice">이벤트
				공지사항</a></li>
		<li class="list-group-item"><a href="listNoticeNormal.notice">일반
				공지사항</a></li>
		<%-- <li class="list-group-item">관리자:<c:out value="${memberDTO.name }님" /></li> --%>
	</ul>
	<div style="width: 80%; float: right;">
		<div align="center">
			<div class="panel panel-default">
				<!-- Default panel contents -->
				<div class="panel-heading">공지사항 목록</div>
				<!-- Table -->
				<!-- <form name="f" action="insertPro.event" method="post"> -->
				<table class="table">
					<tr>
						<th>공지 번호</th>
						<th>공지 제목</th>
						<th>공지 날짜</th>
					</tr>
					<c:if test="${size>0 }">
							<c:forEach var="noticeData" items="${listNoticeNormal }">
							<tr>
								<td>${noticeData.ntnum }</td>
								<td> <a href="detail.notice?ntnum=${noticeData.ntnum }&isEvent=0">${noticeData.title }</a></td>
								<td> ${noticeData.reg_date }</td>
							</tr>
							</c:forEach>
					</c:if>
					<c:if test="${size==0}">
						<tr>
							<td align="center" colspan="4">일반 공지사항이 없습니다..</td>
						</tr>
					</c:if>
				</table>
				<!-- </form> -->
			</div>
		</div>
	</div>
</body>
</html>

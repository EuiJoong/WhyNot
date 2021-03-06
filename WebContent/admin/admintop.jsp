<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<script type="text/javascript">
	function goToVote() {
		window.open("list.poll", "new", "width=800, height=500");
	}
</script>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- adminmain.min.css Core CSS -->
<link href="css/adminmain.min.css" rel="stylesheet">
<title>WhyNot 관리자 페이지</title>
</head>
<body>
	<c:set var="memberDTO" value="${sessionScope.memberDTO }" />
	<ul class="list-group"
		style="float: left; width: 20%; position: fixed;">
		<li class="list-group-item"><a href="adminMain.app">Home</a></li>
		<li class="list-group-item">관리자:<c:out
				value="${memberDTO.name }님" /></li>
		<li class="list-group-item"><a href="list.notice">공지관리</a></li>
		<li class="list-group-item"><a href="list.cate">카테고리관리</a></li>
		<li class="list-group-item"><a href="list.member">회원관리</a></li>
		<li class="list-group-item"><a href="list.event">이벤트관리</a></li>
		<li class="list-group-item"><a href="list.nominee">후보자관리</a></li>
		<li class="list-group-item"><a onClick="javascript:goToVote()">회원투표현황</a></li>
		<li class="list-group-item"><a href="list.faq">FAQ 관리</a></li>
		<li class="list-group-item">목록7</li>
		<li class="list-group-item">목록8</li>
		<li class="list-group-item">목록9</li>
	</ul>
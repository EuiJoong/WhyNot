<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp"%>
<!-- css 는 밑에 링크 파일에!! -->
<link href="css/usercont_insert.min.css" rel="stylesheet">
<!-- 래한이 파트 (인강 등록)-->
<!-- 상단 메뉴바가 css로 인해서 윗부분이 겹쳐서 div로  style="padding: px" 줌 -->
<div style="padding:50px">
인강 등록페이지
<form name="f" action="insertVideo.content" method="post" enctype="multipart/form-data" onsubmit="return writeChk()">
	<input type="file" name="filename" size="15"/>
	<input type="submit" name="submit" value="제출"/>
</form>
</div>
<%@ include file="../../bottom.jsp"%>
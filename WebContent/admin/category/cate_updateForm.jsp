<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../admintop.jsp"%>
<div align="center" style="width: 80%; float: right;">
	<form name="f" action="updatePro.cate" method="post">
	<c:out value ="${param.ctnum}"/>
	<table border="1" width="300">
		<caption>카테고리 수정</caption>
		<tr>
			<th>카테고리 이름</th>
			<td><input type="text" name="name">
				<input type="hidden" name="ctnum" value="${param.ctnum}"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="등록">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
	</form>
</div>
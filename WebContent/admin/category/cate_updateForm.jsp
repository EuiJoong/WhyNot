<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../admintop.jsp"%>

<div align="center" style="width: 80%; float: right;">
	<form name="f" action="updatePro.cate" method="post">
	<table border="1" style="width=300; margin-top: 5em;">
		<tr><td colspan="2" style="text-align: center">카테고리 수정</td></tr>
		<tr>
			<th>카테고리 이름</th>
			<td><input type="text" name="name" class="form-control">
				<input type="hidden" name="ctnum" class="form-control" value="${param.ctnum}"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" class="btn btn-default" value="등록">
				<input type="reset" class="btn btn-default" value="취소">
			</td>
		</tr>
	</table>
	</form>
</div>
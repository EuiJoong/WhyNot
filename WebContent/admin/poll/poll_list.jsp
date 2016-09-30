<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../admin/admintop.jsp"%>

<script type="text/javascript">
	function selectEvent(selectObj) {
		alert(selectObj.value + "가 선택 되었습니다.");
		location.href="list.poll?eventNum="+selectObj.value;
		
		alert("새로고침?!");
	}
</script>

<div style="width: 80%; float: right;">
	<div align="center">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">회원 투표 현황</div>
			<!-- Table -->
			<!-- <form name="f" action="insertPro.event" method="post"> -->
			<table class="table">
				<tr>
					<td colspan="4" align="right">
						이벤트 번호 : 
						<select name="eventNum" onChange="javascript:selectEvent(this)">
								<option value="0" selected>전체</option>
							<c:forEach var="num" items="${eventList }">
								<option value="${num.eventNum }">${num.eventNum }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
				<th>이벤트 번호</th>
				<th>참여 회원 아이디</th>
				<th>후보 번호</th>
				<th>후보 이름</th>
				</tr>
			<c:choose>
				<c:when test="${pollList.size() == 0 }">
					<tr>
						<td align="center" colspan="4">진행된 투표가 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="pollDto" items="${pollList }">
						<tr>
							<td><c:out value="${pollDto.eventNum }" /></td>
							<td><c:out value="${pollDto.memberEmail }" /></td>
							<td><c:out value="${pollDto.nomiNum }" /></td>
							<td><c:out value="${pollDto.nomiName }" /></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			</table>
			<!-- </form> -->
		</div>
	</div>
</div>
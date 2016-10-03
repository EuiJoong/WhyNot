<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../admintop.jsp"%>
<script type="text/javascript">
	function goInsertNotice(){
		location.href="insert.notice";
	}
</script>
<div style="width: 80%; float: right;">
	
	<c:set var="listNotice" value="${listNotice }" />
	
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
							<c:forEach var="noticeData" items="${listNotice }">
							<tr>
								<td>${noticeData.ntnum }</td>
								<td> <a href="detailForAdmin.notice?ntnum=${noticeData.ntnum }&isEvent=1&eventnum=${noticeData.eventnum}">${noticeData.title }</a></td>
								<td> ${noticeData.reg_date }</td>
							</tr>
							</c:forEach>
					</c:if>
					
					<c:if test="${size==0}">
						<tr>
							<td align="center" colspan="4">공지사항 없음</td>
						</tr>
					</c:if>
					
				</table>
				<!-- </form> -->
			</div>
		</div>

	
	<a class="btn btn-primary" onclick="javascript:goInsertNotice()">공지사항 등록</a>
</div>

<!-- jQuery -->
<script src="js/jquery.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
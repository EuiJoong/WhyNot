<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp"%>
<c:set var="isPurchase" value="${isPurchase}" />
<!-- 구매확인 -->
<c:set var="videoDTO" value="${videoDTO }" />
<!-- 상세정보의 비디오 정보들 -->
<c:set var="contList" value="${contList }" />
<!-- 상세정보(wn_member, wn_photo, wn_online -->
<!-- css 는 밑에 링크 파일에!! -->
<link href="css/usercont_detail.min.css" rel="stylesheet">
<!-- 상단 메뉴바가 css로 인해서 윗부분이 겹쳐서 div로  style="padding: px" 줌 -->
<!-- player skin -->
<link rel="stylesheet" type="text/css" href="dist/minimalist.css?f">
<!-- site specific styling -->
<style>
body {
	font: 12px "Myriad Pro", "Lucida Grande", sans-serif;
	text-align: center;
	padding-top: 1%;
}

.flowplayer {
	width: 40%;
}
</style>

<!-- flowplayer depends on jQuery 1.7.1+ (for now) -->
<script src="dist/jquery.js"></script>
<!-- include flowplayer -->
<script src="dist/flowplayer.js?i"></script>

<script type="text/javascript">
	function chkMileage(price,mileage) {
		if(mileage < price){
			alert("마일리지가 부족합니다.");
			return;
		}
		
		document.purchase.submit();
	}
</script>
<!-- ----------------------------------------------------여기까지 잠깐  -->
<body style="overflow: auto;" class="makescroll">
	<c:forEach var="contData" items="${contList }">
		<div>
			<div class="panel panel-default"
				style="float: left; height: 59em; width: 80%;">
				<div class="panel-heading">커리큘럼 명 수정2</div>
				<!-- 강사소개 영역 -->
				<div class="thumbnailC" align="left">
					<c:if test="${contData.FILENAME == null }">
						<img
							src="${pageContext.request.contextPath}/images/defaultpro.png"
							alt="" width="400" height="250">
					</c:if>
					<c:if test="${contData.FILENAME != null }">
						<img
							src="${pageContext.request.contextPath}/images/${contData.FILENAME}.${contData.FILEEXT }"
							alt="" width="400" height="250">
					</c:if>

					강사 : ${contData.ID }<br /> 강의 내용 : ${contData.CONTENT } 가격 :
					${contData.PRICE }
					<c:out value="보유 마일리지 ${memberDTO.mileage }" />
					<div align="right">
						<c:choose>
							<c:when test="${memberDTO != null }">
								<c:choose>
									<c:when test="${memberDTO.id==contData.ID}">
										<a href="cont_update.oncont" class="btn btn-primary">강의 수정</a>
										<a href="curri_insert.curr" class="btn btn-primary">커리큘럼
											등록</a>
									</c:when>
									<c:when test="${memberDTO.id!=contData.ID && !isPurchase}">
										<form action="purchaseOnline.payment" method="post" name="purchase">
											<a type="button" class="btn btn-primary"
												onclick="chkMileage(${contData.PRICE},${memberDTO.mileage })">강의
												구매</a>
											<input type="hidden" name="amount" value="${contData.PRICE }">
											<input type="hidden" name="mnum" value="${memberDTO.mnum }">
											<input type="hidden" name="ocnum" value="${contData.OCNUM }">
											<input type="hidden" name="seller" value="${contData.MNUM }">
										</form>
									</c:when>
									<c:when test="${memberDTO.id!=contData.ID && isPurchase}">
										<a href="curri_detail.curr" class="btn btn-default" target="_blank">강의실 이동</a>
									</c:when>
								</c:choose>
							</c:when>
							<c:otherwise>
								<script type="text/javascript">
									alert("로그인 하셔야 구매 가능합니다.");
								</script>
							</c:otherwise>
						</c:choose>
					</div>
				</div>

				<!-- Q&A게시판 영역 -->
				<div class="panel-heading">
					<font class="qnafont" style="float: left;">오리엔테이션 및 강의 목록</font>
				</div>
				<div class="qnaform" align="left">
					<form class="navbar-form" role="search">
						<div class="panel-body">
							<div style="height: 30em;">
								<div id="h-div" class="flowplayer play-button"
									data-engine="flash" data-swf="../../dist/flowplayer.swf"
									data-rtmp="rtmp://s3b78u0kbtx79q.cloudfront.net/cfx/st"
									data-ratio=".4167">

									<video autoplay preload="none">
										<!-- <source type="video/mp4" src="movie/test.mp4"> -->
										<source type="video/mp4"
											src="${pageContext.request.contextPath}/video/${videoDTO.filename }">
									</video> 

								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- 강의 평가 -->
			<div class="panel-heading">
				<font class="qnafont" style="float: left;">강의 평가</font>
				<div class="qnaform">
					<p>평가 내용</p>
					<div align="left">

						<c:set var="sum" value="0" />
						<c:choose>
							<c:when test="${assessmentList.size()==0}">
								평가 가 없습니다.
								</c:when>
							<c:otherwise>
								<c:forEach var="dto" items="${assessmentList}">
									<tr>
										<td>${dto.content}</td>
										<td>${dto.reg_date}</td>
										<td>${dto.grademark}점</td>
									</tr>
									<br />
								</c:forEach>
									평균 : ${avg }
								</c:otherwise>
						</c:choose>

						<form action="insertAssessment.content?mnum=${memberDTO.mnum }"
							method="post" name="cmtform">
							<textarea name="assessmentContent" rows="3" cols="70"></textarea>
							<c:choose>
								<c:when test="${memberDTO != null }">


									<input type="hidden" name="writer" value="${memberDTO.name }">
									<input type="hidden" name="ocnum" value="${contData.OCNUM }">
										${contData.OCNUM }
									</c:when>
							</c:choose>

							<p>
								<select name="grademark">
									<option value="1" selected>1점</option>
									<option value="2">2점</option>
									<option value="3">3점</option>
									<option value="4">4점</option>
									<option value="5">5점</option>
								</select>
							</p>

							<button type="submit" class="btn btn-default">평가하기</button>
						</form>

					</div>
				</div>
				<!-- <a href="#" class="btn btn-primary">평가하기</a> -->
			</div>
		</div>
	</c:forEach>
</body>

<%@ include file="../../bottom.jsp"%>
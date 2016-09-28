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
<link
	href="${pageContext.request.contextPath}/css/usercont_detail.min.css"
	rel="stylesheet">
<!-- 상단 메뉴바가 css로 인해서 윗부분이 겹쳐서 div로  style="padding: px" 줌 -->

<!-- player skin -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">

<!-- player skin -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/dist/minimalist.css?f">
<!-- site specific styling -->

<style>
body {
	font: 12px "Myriad Pro", "Lucida Grande", sans-serif;
}
</style>

<html lang="en">
<!-- flowplayer depends on jQuery 1.7.1+ (for now) -->
<script src="${pageContext.request.contextPath}/dist/jquery.js"></script>
<!-- include flowplayer -->
<script src="${pageContext.request.contextPath}/dist/flowplayer.js?i"></script>

<script type="text/javascript">
	function chkMileage(price,mileage) {
		if(mileage < price){
			alert("마일리지가 부족합니다.");
			return;
		}
		
		document.purchase.submit();
	}
</script>
<body style="padding-top: 16px;">
	<!-- Page Content -->

	<div class="container">
		<div class="row">
			<c:forEach var="contData" items="${contList }">
				<!-- left division -->
				<!-- Post Content Column -->
				<div class="col-lg-8" style="margin-top: 32px">

					<!-- Blog Post -->
					<!-- Title -->
					<h1>${contData.TITLE }</h1>
					<!-- Author -->
					<hr>
					<!-- Date/Time -->
					<p>
						by <a href="#" style="font-size: large; color: black;">${contData.NAME }</a><!--  <span
							class="glyphicon glyphicon-time">날짜</span> -->
					</p>

					<hr>

					<!-- 여기부터 소개 할게욥~ -->

					<div class="row">

						<div class="col-md-4">
							<c:if test="${contData.FILENAME == null }">
								<img
									src="${pageContext.request.contextPath}/images/defaultpro.png"
									alt="" width="200" height="150">
							</c:if>
							<c:if test="${contData.FILENAME != null }">
								<img
									src="${pageContext.request.contextPath}/images/${contData.FILENAME}.${contData.FILEEXT }"
									alt="" width="200" height="150">
							</c:if>
						</div>
						<!-- 강사 소개 부분  -->
						<div class="col-md-8">
							<h3>강사 프로필</h3>
							<p>후에 추가</p>
						</div>

					</div>
					<hr>
					<p class="lead">Intro</p>
					<hr>
					<!-- 영상 부분 -->
					<div id="h-div" class="flowplayer play-button" data-engine="flash"
						data-swf="${pageContext.request.contextPath}/dist/flowplayer.swf"
						data-rtmp="rtmp://s3b78u0kbtx79q.cloudfront.net/cfx/st"
						data-ratio=".4167">
						<video autoplay preload="none">
							<source type="video/mp4"
								src="${pageContext.request.contextPath}/WhyNot/video/${videoDTO.filename }">
						</video>
					</div>
					<hr>

					<!-- Post Content -->
					<p class="lead">강의 소개</p>
					${contData.CONTENT }

					<hr>

					<!-- Blog Comments -->

					<c:set var="sum" value="0" />
					
					<!-- Comments Form -->
					<form role="form" action="insertAssessment.oncont" method="post"
						name="cmtform">
						<input type="hidden" name="mnum" value="${memberDTO.mnum}">
						<div class="well">
							<h4>
								강의 평가:<select name="grademark">
									<option value="1" selected>1점</option>
									<option value="2">2점</option>
									<option value="3">3점</option>
									<option value="4">4점</option>
									<option value="5">5점</option>
								</select>
							</h4>
							<div class="form-group">

								<textarea class="form-control" rows="3" name="assessmentContent"></textarea>
								<c:choose>
									<c:when test="${memberDTO != null }">

										<input type="hidden" name="writer" value="${memberDTO.name }">
										<input type="hidden" name="ocnum" value="${contData.OCNUM }">
									</c:when>
								</c:choose>
							</div>
							<button type="submit" class="btn btn-primary">평가하기</button>
						</div>
					</form>
					<hr>
					<c:choose>
						<c:when test="${assessmentList.size()==0}">
                        평가 가 없습니다.
                        </c:when>
						<c:otherwise>
							<c:forEach var="dto" items="${assessmentList}">
								<div class="media" style="margin-top: 20px;">
									<a class="pull-left" href="#"> <img class="media-object"
										src="http://placehold.it/64x64" alt="">
									</a>
									<div class="media-body">
										<h4 class="media-heading">
											${qnaDTO.mnum } <small>${dto.reg_date }</small>
										</h4>
										${dto.content} <br>
									</div>
									<%-- <tr>
									<td>${dto.content}</td>
									<td>${dto.reg_date}</td>
									<td>${dto.grademark}점</td>
								</tr> --%>
									<br />
								</div>
							</c:forEach>
                           평균 : ${avg }
                        </c:otherwise>
					</c:choose>
					<!-- Posted Comments -->
		
					<div class="panel-heading">
						<!-- <a href="#" class="btn btn-primary">평가하기</a> -->
					</div>
					<!-- 건들지마요 이거 -->
				</div>
				<!-- /left division -->
				<!-- right division -->
				<!-- Blog Sidebar Widgets Column -->
				<div class="col-md-4" style="margin-top: 50px;">

					<!-- Blog Search Well -->
					<c:if test="${memberDTO != null }">
						<div class="well">
							<c:choose>
								<c:when test="${memberDTO != null }">
									<c:choose>
										<c:when test="${memberDTO.id==contData.ID}">
											<div>
												<form
													action="cont_update.oncont?mnum=${contData.MNUM }&ocnum=${contData.OCNUM}"
													method="post" name="fupdate">
													<a class="btn btn-primary"
														onclick="javascript: document.fupdate.submit()">강의 수정</a>
												</form>
												<form action="curri_insert.curr" method="post"
													name="finsert">
													<input type="hidden" name="lsnum" value="${lsnum }">
													<input type="hidden" name="ocnum"
														value="${contData.OCNUM }"> <a
														class="btn btn-primary"
														onclick="javascript: document.finsert.submit()">커리큘럼
														등록</a>
												</form>
											</div>
										</c:when>
										<c:when test="${memberDTO.id!=contData.ID && !isPurchase}">
											<form action="purchaseOnline.payment" method="post"
												name="purchase">
												<h3>가격: ${contData.PRICE }</h3>
												<a type="button" class="btn btn-primary"
													onclick="chkMileage(${contData.PRICE},${memberDTO.mileage })">강의
													구매</a> <input type="hidden" name="amount"
													value="${contData.PRICE }"> <input type="hidden"
													name="mnum" value="${memberDTO.mnum }"> <input
													type="hidden" name="ocnum" value="${contData.OCNUM }">
												<input type="hidden" name="seller" value="${contData.MNUM }">
											</form>
										</c:when>
										<%-- <c:when test="${memberDTO.id!=contData.ID && isPurchase}">
										<form action="curri_detail.curr" method="post" name="ffmove">
											<input type="hidden" name="lsnum" value="${lsnum }">
											<a class="btn btn-default" target="_blank"
												onclick="javascript: document.ffmove.submit() ">강의실 이동</a>
										</form>
									</c:when> --%>
									</c:choose>
								</c:when>
								<c:otherwise>
									<script type="text/javascript">
									alert("로그인 하셔야 구매 가능합니다.");
								</script>
								</c:otherwise>
							</c:choose>
							<!-- /.input-group -->
						</div>
					</c:if>

					<!-- Blog Categories Well -->
					<div class="well">
						<!-- 상위 메뉴 -->
						<c:choose>
							<c:when test="${currList.size() == 0 || currList == null }">
								<div class="panel-group" id="accordion" role="tablist"
									aria-multiselectable="true">
									<div class="panel panel-default">
										<div id="collapseOne" class="panel-collapse collapse in"
											role="tabpanel" aria-labelledby="headingOne">
											<div class="panel-body">
												<!-- 하위메뉴 출력부 -->
												<div class="list-group">
													<!-- 일단 귀찮아서 하위메뉴 갯수 생각 X ㅠㅠ -->
													<h5 class="list-group-item">준비중</h5>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<!-- 리스트 숫자 -->
								<c:set var="listNum" value="${currList.size() }" />
								<!-- 총 리스트는 12개 -->
								<!-- 반복문을 위한??  -->
								<c:set var="listSeq" value="${1 }" />
								<!-- 임의 하위 메뉴 갯수 -->
								<c:set var="rowNum" value="${5 }" />
								<!-- 테이블 만들어지면 없어도 됨 -->
								<c:forEach var="reHigh" begin="${1 }" end="${1 }">
									<!-- 상위 메뉴 3개라고 가정... -->
									<div class="panel-group" id="accordion" role="tablist"
										aria-multiselectable="true">
										<div class="panel panel-default">
											<div class="panel-heading" role="tab" id="headingOne">
												<h4 class="panel-title">
													<a data-toggle="collapse" data-parent="#accordion"
														href="#collapseOne" aria-expanded="true"
														aria-controls="collapseOne">목록</a>
												</h4>
											</div>
											<div id="collapseOne" class="panel-collapse collapse in"
												role="tabpanel" aria-labelledby="headingOne">
												<div class="panel-body">
													<!-- 하위메뉴 출력부 -->
													<div class="list-group">
														<!-- 일단 귀찮아서 하위메뉴 갯수 생각 X ㅠㅠ -->
														<c:forEach var="currData" items="${currList }">
															<c:choose>
																<c:when
																	test="${memberDTO.id!=contData.ID && isPurchase}">
																	<form action="curri_detail.curr" method="post"
																		target="_blank" id="gara">
																		<input type="hidden" name="lsnum"
																			value="${currData.LSNUM }"> <input
																			type="hidden" name="clnum" value="${currData.CLNUM }">
																		<input type="hidden" name="ttnum"
																			value="${currData.TTNUM }"> <input
																			type="hidden" name="writer" value="${contData.ID }">
																		<a href="#"
																			onclick="document.getElementById('gara').submit();"
																			class="list-group-item">${currData.TITLE } <span
																			class="badge">이동</span>
																		</a>
																	</form>
																</c:when>
																<c:when test="${memberDTO.id==contData.ID}">
																	<form action="curri_detail.curr" method="post" id="plz"
																		target="_blank">
																		<input type="hidden" name="lsnum"
																			value="${currData.LSNUM }"><input
																			type="hidden" name="clnum" value="${currData.CLNUM }">
																		<input type="hidden" name="ttnum"
																			value="${currData.TTNUM }"> <input
																			type="hidden" name="writer" value="${contData.ID }">
																		<a href="#"
																			onclick="document.getElementById('plz').submit();"
																			class="list-group-item"> ${currData.TITLE } <span
																			class="badge">이동</span>
																		</a>
																	</form>
																</c:when>
																<c:otherwise>
																	<a class="list-group-item"> ${currData.TITLE } </a>
																</c:otherwise>
															</c:choose>

														</c:forEach>
													</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
						<!-- /.row -->
					</div>
				</div>
			</c:forEach>
		</div>
		<!-- /.row -->
		<hr>
		<!-- preBotton  -->
		<!-- <footer>
			<div class="row">
				<div class="col-lg-12">
					<p>여기엔 &copy; 강사에 관련된 또는 강의와 관련된 하단을 넣어도 됩니다 지워도 되구요~ bottom
						복붙해서 위치만 잡았어요</p>
				</div>
			</div> 
		</footer>-->

	</div>
</body>

</html>

<%@ include file="../../bottom.jsp"%>
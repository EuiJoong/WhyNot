<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp"%>
<c:set var="isPurchase" value="${isPurchase}" />
<!-- 잠깐만! -->
<!-- css 는 밑에 링크 파일에!! -->
<link href="css/usercont_detail.min.css" rel="stylesheet">
<!-- 경숙이 파트 (인강 상세보기) -->
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
	width: 100%;
}
</style>

<!-- flowplayer depends on jQuery 1.7.1+ (for now) -->
<script src="dist/jquery.js"></script>

<!-- include flowplayer -->
<script src="dist/flowplayer.js?i"></script>

<!-- ----------------------------------------------------여기까지 잠깐  -->
<div>
<div style="padding: 50px">
	<div class="right text-center">
		<div class="col-md-3 col-sm-6 hero-feature">
			<div class="thumbnail">	
				<img src="http://placehold.it/800x500" alt="">
				<ul>
					<div class="captionC">
						<h3>강의설명 ${isPurchase }</h3>
						<p>여기는 강의설명 부분입니다.</p>
						<p>
						<c:choose>
							<c:when test="${isPurchase }">
								<a href="#" class="btn btn-primary">강의실 이동</a>
							</c:when>
							<c:otherwise>
								<a href="#" class="btn btn-default">강의 구매</a>
							</c:otherwise>
						</c:choose>
						</p>
					</div>
				</ul>
			</div>
		</div>
	</div>
	
	
	<div class="row text-center">

		<div class="col-md-3 col-sm-6 hero-feature">
			<div id="h-div" class="flowplayer play-button" data-engine="flash"
				data-swf="dist/flowplayer.swf"
				data-rtmp="rtmp://s3b78u0kbtx79q.cloudfront.net/cfx/st"
				data-ratio=".4167">


				<video autoplay preload="none">
					<source type="video/mp4" src="movie/test.mp4">
				</video>

			</div>
			<div>
				<div class="captionC right">
					<h3>Orientation</h3>
					<p>강의 11</p>
					<p>강의 2</p>
					<p>강의 3</p>
					<p>강의 4</p>
					<p>강의 5</p>
					<p>
					
						<c:if test="${isPurchase }">
							<a href="#" class="btn btn-default">평가하기</a>
						</c:if>
	
					</p>
				</div>
			</div>
		</div>
	</div>
	
	
</div>
</div>
<%-- <div style="padding: 50px">

	<div class="right text-center">
		<div class="col-md-3 col-sm-6 hero-feature">
			<div class="thumbnail">	
				<img src="http://placehold.it/800x500" alt="">

				<div class="captionC">
					<h3>강의설명 ${isPurchase }</h3>
					<p>여기는 강의설명 부분입니다.</p>
					<p>
					<c:choose>
						<c:when test="${isPurchase }">
							<a href="#" class="btn btn-primary">강의실 이동</a>
						</c:when>
						<c:otherwise>
							<a href="#" class="btn btn-default">강의 구매</a>
						</c:otherwise>
					</c:choose>
					</p>
				</div>
			
			</div>
		</div>
	</div>

	<div class="row text-center">

		<div class="col-md-3 col-sm-6 hero-feature">
			<div id="h-div" class="flowplayer play-button" data-engine="flash"
				data-swf="dist/flowplayer.swf"
				data-rtmp="rtmp://s3b78u0kbtx79q.cloudfront.net/cfx/st"
				data-ratio=".4167">


				<video autoplay preload="none">
					<source type="video/mp4" src="movie/test.mp4">
				</video>

			</div>
			<div class="captionC right">
				<h3>Orientation</h3>
				<p>강의 11</p>
				<p>강의 2</p>
				<p>강의 3</p>
				<p>강의 4</p>
				<p>강의 5</p>
				<p>
				
					<c:if test="${isPurchase }">
						<a href="#" class="btn btn-default">평가하기</a>
					</c:if>

				</p>
			</div>
		</div>
	</div>

</div>
 --%>







<%@ include file="../../bottom.jsp"%>

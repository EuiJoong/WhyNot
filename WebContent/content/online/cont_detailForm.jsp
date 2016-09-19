<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp"%>
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
	width: 70%;
}
</style>

<!-- flowplayer depends on jQuery 1.7.1+ (for now) -->
<script src="dist/jquery.js"></script>

<!-- include flowplayer -->
<script src="dist/flowplayer.js?i"></script>

<!-- 여기까지 잠깐  -->
	<div style=padding:50px>
		인강 상세페이지.먼저 여기서 해보자! cont_detail.content, 수정15
		<div class="col-md-3 col-sm-6 hero-feature">
			<div class="thumbnail">
				<img src="http://placehold.it/800x500" alt="">
			</div>
		</div>

		<div id="h-div" class="flowplayer play-button"
		data-engine="flash"
		data-swf="dist/flowplayer.swf"
		data-rtmp="rtmp://s3b78u0kbtx79q.cloudfront.net/cfx/st"
		data-ratio=".4167">

	
		<video autoplay preload="none" width="800" height="500">
			<source type="video/mp4" src="movie/${fileName }" >
		</video>
			

		</div>
	</div>

<%@ include file="../../bottom.jsp"%>

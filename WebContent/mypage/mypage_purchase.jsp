<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../top.jsp"%>
<%@ include file="mypage_top.jsp"%>
<div class="container" style="padding-top: 2rem">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/barstyle.css">


	<div class="row">

		<!-- Blog Entries Column -->
		<div class="col-md-9">



			<!-- 강의 반복 -->

			
			<c:forEach var="listNum" begin="1" end="5">

				<hr style="border: solid 1px blue;">
				<h3 class="page-header">
					강의?? <small>구매 목록</small>
				</h3>

				<!-- First Blog Post -->
				<h4>
					<a href="#">제목(누르면 바로 상세가게)</a>
				</h4>
				<p>
					by <a href="">작성자한테 가는데 일단 홈으로</a>
				</p>
				<p>
					<span class="glyphicon glyphicon-time}"></span> Posted on 9th of Oct,
					1990 at 06:00 AM
				</p>
				<hr>


				<div class="row" >
					<div class="col-md-6">
						<a href="#"> <img class="img-responsive"
							src="http://placehold.it/700x300" alt="">
						</a>
					</div >
					<div class="col-mid-6"style="text-align: center;">
					<div class="circle-chart small kks pull-right" data-percent="${58 }" data-color="black">
<!-- 						<h4>강의 소제목</h4>
						<p>간략 내용 or 상세내용</p>
						<a class="btn btn-primary" href="#">상세보기 <span
							class="glyphicon glyphicon-chevron-right"></span></a> -->
					</div></div>
					
				</div>
				
				
				


				<hr>
				<p>상세 내용 or 목록 or 질문답변?</p>
				<a class="btn btn-primary" href="#">위에 상태에 따라서 버튼은 하나만 사용 <span
					class="glyphicon glyphicon-chevron-right"></span></a>
					
				


			</c:forEach>
			
			
			
			
			
			
			
			<hr style="border: solid 1px blue;">



			



			<!-- Pager -->
			<ul class="pager">
				<li class="previous"><a href="#">← Older</a></li>
				<li class="next"><a href="#">Newer →</a></li>
			</ul>

		</div>

		<!-- Blog Sidebar Widgets Column -->
		<div class="col-md-3">

			<!-- Blog Search Well -->
			<div class="well">
				<h4>강의 검색</h4>
				<div class="input-group">
					<input type="text" class="form-control"> <span
						class="input-group-btn">
						<button class="btn btn-default" type="button">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
				<!-- /.input-group -->
			</div>

			<!-- Blog Categories Well -->
			<div class="well">
				<h4>뭐하지</h4>
				<div class="row">
					<div class="col-lg-12">
						<ul class="list-unstyled">
							<li><a href="#">1111</a></li>
							<li><a href="#">2222</a></li>
							<li><a href="#">3333</a></li>
							<li><a href="#">4444</a></li>
							<li><a href="#">5555</a></li>
							<li><a href="#">6666</a></li>
						</ul>
					</div>
					<!-- /.col-lg-6 -->
				</div>
				<!-- /.row -->
			</div>

			<!-- Side Widget Well -->
			<div class="well">
				<h4>스케쥴이나 곧 종료인 강의</h4>
				<p>이제 나도 내가 뭐 하고있는지 모르겠다.</p>
			</div>

		</div>

	</div>
	<!-- /.row -->
	
	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	
	<script src="${pageContext.request.contextPath}/js/barchart.js"></script>
	

</div>
<%@ include file="../bottom.jsp"%>
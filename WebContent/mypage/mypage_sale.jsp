<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../top.jsp"%>
<%@ include file="mypage_top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/barstyle.css">
<div class="container" style="padding-top: 2rem">
	<div class="row">
		<!-- Blog Entries Column -->
		<div class="col-md-9">
			<!-- 강의 반복 -->
			<c:choose>
				<c:when test="${onContList.size() == 0 }">
					<c:out value="구매한 강의가 없습니다." />
				</c:when>
				<c:otherwise>
					<c:forEach var="onContDTO" items="${onContList}">
						<hr style="border: solid 1px blue;">
						<h3 class="page-header">
							<c:out value="${onContDTO.TITLE}" />
						</h3>
						<!-- First Blog Post -->
						<!-- <h4>
							<a href="#">제목(누르면 바로 상세가게)</a>
						</h4> -->
						<p>
							by <a href=""><c:out value="${onContDTO.NAME}" />
							</a>
						</p>
					<!-- 	<p>
							<span class="glyphicon glyphicon-time}"></span> Posted on 9th of
							Oct, 1990 at 06:00 AM
						</p> -->
						<hr>


						<div class="row">
							<div class="col-md-6"> 
								<a href="cont_detail.oncont?mnum=${memberDTO.mnum }&ocnum=${onContDTO.OCNUM }"> <img class="img-responsive"
									src="${pageContext.request.contextPath}/images/${onContDTO.FILENAME}.${onContDTO.FILEEXT}"
									alt="">
								</a>
							</div>
							<%-- <div class="col-mid-6" style="text-align: center;">
								<div class="circle-chart small kks pull-right"
									data-percent="${58 }" data-color="black">
								</div>
							</div> --%>

						</div>
						<hr>
						<a class="btn btn-primary" href="cont_detail.oncont?mnum=${memberDTO.mnum }&ocnum=${onContDTO.OCNUM }">이동<span
							class="glyphicon glyphicon-chevron-right"></span></a>

					</c:forEach>
				</c:otherwise>
			</c:choose>

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
			<!-- <div class="well">
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
					/.col-lg-6
				</div>
				/.row
			</div>

			Side Widget Well
			<div class="well">
				<h4>스케쥴이나 곧 종료인 강의</h4>
				<p>이제 나도 내가 뭐 하고있는지 모르겠다.</p>
			</div> -->

		</div>

	</div>
	<!-- /.row -->

	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

	<script src="${pageContext.request.contextPath}/js/barchart.js"></script>


</div>
<%@ include file="../bottom.jsp"%>
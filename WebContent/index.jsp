<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="readUrl" value="${pageContext.request.requestURL}" />
<c:if test="${fn:contains(readUrl,'jsp')}">
	<c:if test="${cateList == null }">
		<c:redirect url="main.app"></c:redirect>
	</c:if>
</c:if>
<!-- 상단 슬라이드 -->
<!-- Header Carousel -->
<header id="myCarousel	" class="carousel slide">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>
	<!-- Wrapper for slides -->
	<div class="carousel-inner">
		<div class="item active">
			<div class="fill"
				style="background-image: url('http://placehold.it/1900x1080&amp;text=하하하하(1900x1080)');"></div>
		</div>
		<div class="item">
			<div class="fill"
				style="background-image: url('http://placehold.it/1900x1080&amp;text=공지 사항(1900x1080)');"></div>
		</div>
		<div class="item">
			<div class="fill"
				style="background-image: url('http://placehold.it/1900x1080&amp;text=이벤트 강연(1900x1080)');"></div>
		</div>
	</div>
	<!-- Controls -->
	<a class="left carousel-control" href="#myCarousel" data-slide="prev">
		<span class="icon-prev"></span>
	</a> <a class="right carousel-control" href="#myCarousel" data-slide="next">
		<span class="icon-next"></span>
	</a>
</header>
<!-- 카테고리 메뉴 -->
<nav>
	<div class="col-lg-12">
		<h2 class="page-header">카테고리</h2>
	</div>
	<ul class="nav nav-justified">
		<c:forEach var="cateDTO" items="${cateList }">
			<li><a href="list.oncont?ctnum=${cateDTO.ctnum }"><c:out
						value="${cateDTO.name }"></c:out></a></li>
		</c:forEach>
	</ul>
</nav>
<!-- Page Content -->
<div class="container">
	<!-- Best 강좌 -->
	<!-- Title -->
	<!-- /.row -->
	<!-- Page Features -->
	<c:choose>
		<c:when test="${bestList.size() == 0 || bestList == null }">
			<p>
				<c:out value="Best강좌가 없습니다." />
			</p>
		</c:when>
		<c:otherwise>
			<!-- img/defaultpro.png -->
			<div class="row">
				<div class="col-lg-12">
					<h3>Best 강좌</h3>
				</div>
			</div>
			<c:forEach var="bestData" items="${bestList }">
				<div class="col-md-3 col-sm-6 hero-feature">
					<div class="thumbnail" align="center">
						<img
							src="${pageContext.request.contextPath}/images/${bestData.FILENAME}.${bestData.FILEEXT}"
							style="width: 15em; height: 10em;" alt="이미지 출력이 ㅠㅠ" />
						<div class="caption">
							<h3>
								<c:out value="${bestData.TITLE }" />
							</h3>
							<p>
								<c:out value="${bestData.NAME }" />
							</p>
							<p>
								<c:choose>
									<c:when test="${memberDTO == null }">
										<a href="cont_detail.oncont?ocnum=${bestData.OCNUM }"
											class="btn btn-default">More Info</a>
									</c:when>
									<c:otherwise>
										<a
											href="cont_detail.oncont?mnum=${memberDTO.mnum }&ocnum=${bestData.OCNUM }"
											class="btn btn-default">More Info</a>
									</c:otherwise>
								</c:choose>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	<!-- Best 강좌 끝 -->

	<!-- 추천 강좌 -->
	<!-- Page Features -->
	<c:choose>
		<c:when test="${recommandList.size() == 0 || recommandList == null }">
			<%-- <p>
				<c:out value="해당된 카테고리 내에서 등록된 컨텐츠가 없습니다." />
			</p> --%>
		</c:when>
		<c:otherwise>
			<!-- img/defaultpro.png -->
			<div class="row">
				<div class="col-lg-12">
					<h3>추천 강좌</h3>
				</div>
			</div>
			<c:forEach var="recommandData" items="${recommandList }">
				<div class="col-md-3 col-sm-6 hero-feature">
					<div class="thumbnail" align="center">
						<img
							src="${pageContext.request.contextPath}/images/${recommandData.FILENAME}.${recommandData.FILEEXT}"
							style="width: 15em; height: 10em;" alt="이미지 출력이 ㅠㅠ" />
						<div class="caption">
							<h3>
								<c:out value="${recommandData.TITLE }" />
							</h3>
							<p>
								<c:out value="${recommandData.NAME }" />
							</p>
							<p>
							<c:choose>
									<c:when test="${memberDTO == null }">
										<a href="cont_detail.oncont?ocnum=${recommandData.OCNUM }"
											class="btn btn-default">More Info</a>
									</c:when>
									<c:otherwise>
										<a
											href="cont_detail.oncont?mnum=${memberDTO.mnum }&ocnum=${recommandData.OCNUM }"
											class="btn btn-default">More Info</a>
									</c:otherwise>
								</c:choose>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	<!--추천 강좌 끝 -->

	<!-- Features Section -->
	<div class="row">
		<div class="col-lg-12">
			<h2 class="page-header"></h2>
		</div>
		<div class="col-md-6">
			<!-- <p>::ㄱㄱ::</p> -->
			<ul>
				<strong>WhyNot</strong>
				<br>
				<br>
				<li>서비스 소개</li>
				<br>
				<li><a href="agreement.footer">이용약관</a></li>
				<br>
				<li>개인정보취급방침</li>
				<br>
				<li><a href="listNoticeEvent.notice">이벤트 게시판</a></li>
				<br>
				<li>자주하는 질문</li>
			</ul>
		</div>
		<div class="col-md-6">
			<img class="img-responsive" src="http://placehold.it/700x450" alt="">
		</div>
	</div>
	<!-- /.row -->
	<hr>
	<!-- Call to Action Section -->
	<div class="well">
		<div class="row">
			<div class="col-md-8">
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
					Molestias, expedita, saepe, vero rerum deleniti beatae veniam harum
					neque nemo praesentium cum alias asperiores commodi.</p>
			</div>
			<div class="col-md-4">
				<a class="btn btn-lg btn-default btn-block" href="#">맨 위로</a>
			</div>
		</div>
	</div>
	<hr>
	<%@include file="bottom.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../top.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="css/usercont_list.min.css" rel="stylesheet">
<script src="js/contentList.js"></script>
<c:set var="memberDTO" value="${memberDTO }" />
<br>
<br>
<nav>
	<div class="col-lg-12">
		<h2 class="page-header">카테고리</h2>
	</div>
	<ul class="nav nav-justified">
		<c:choose>
			<c:when test="${cateDTO.size() == 0 }">
				<c:out value="등록된 카테고리가 없습니다." />
			</c:when>
			<c:otherwise>
				<c:forEach var="cateDTO" items="${cateList }">
					<li><a href="list.oncont?ctnum=${cateDTO.ctnum }"><c:out
								value="${cateDTO.name }"></c:out></a></li>
				</c:forEach>
			</c:otherwise>
		</c:choose>

	</ul>
</nav>

<br>
<br>

<!-- 인강 -->
<div class="row">
	<div class="col-lg-12">
		<h3>
			강좌
			<c:choose>
				<c:when test="${memberDTO == null}">
					<button type="button" onclick="chkInsertCont()"
						style="float: right;">강의 등록</button>
				</c:when>
				<c:otherwise>
					<button type="button" onclick="location.href='cont_insert.oncont'"
						style="float: right;">강의 등록</button>
				</c:otherwise>
			</c:choose>
		</h3>
	</div>
	<div></div>
</div>
<!-- /.row -->
<div class="row text-center">
	<c:choose>
		<c:when test="${searchList != null }">
			<c:choose>
				<c:when test="${searchList.size() == 0 }">
					<p>
						<c:out value="없는 정보 입니다." />
					</p>
				</c:when>
				<c:otherwise>
					<!-- img/defaultpro.png -->
					<c:forEach var="searchData" items="${searchList }">
						<%-- <c:out value="${contData.FILEDIR}${contData.FILENAME }.${contData.FILEEXT }"></c:out> --%>
						<div class="col-md-3 col-sm-6 hero-feature">
							<div class="thumbnail">
								<img
									src="${pageContext.request.contextPath}/images/${searchData.FILENAME}.${searchData.FILEEXT}"
									style="width: 15em; height: 10em;" alt="이미지 출력이 ㅠㅠ" />
								<div class="caption">
									<h3>
										<c:out value="${searchData.TITLE }" />
									</h3>
									<p>
										<c:out value="${searchData.NAME }" />
									</p>
									<p>
										<c:choose>
											<c:when test="${memberDTO == null }">
												<a href="cont_detail.oncont?ocnum=${searchData.OCNUM }"
													class="btn btn-default">More Info</a>
											</c:when>
											<c:otherwise>
												<a href="#" class="btn btn-primary">Buy Now!</a>
												<a
													href="cont_detail.oncont?mnum=${memberDTO.mnum }&ocnum=${searchData.OCNUM }"
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
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${contList.size() == 0 }">
					<p>
						<c:out value="해당된 카테고리 내에서 등록된 컨텐츠가 없습니다." />
					</p>
				</c:when>
				<c:otherwise>
					<!-- img/defaultpro.png -->
					<c:forEach var="contData" items="${contList }">
						<%-- <c:out value="${contData.FILEDIR}${contData.FILENAME }.${contData.FILEEXT }"></c:out> --%>
						<div class="col-md-3 col-sm-6 hero-feature">
							<div class="thumbnail">
								<img
									src="${pageContext.request.contextPath}/images/${contData.FILENAME}.${contData.FILEEXT}"
									style="width: 15em; height: 10em;" alt="이미지 출력이 ㅠㅠ" />
								<div class="caption">
									<h3>
										<c:out value="${contData.TITLE }" />
									</h3>
									<p>
										<c:out value="${contData.NAME }" />
									</p>
									<p>
										<c:choose>
											<c:when test="${memberDTO == null }"> 
												<a href="cont_detail.oncont?ocnum=${contData.OCNUM }"
													class="btn btn-default">More Info</a>
											</c:when>
											<c:otherwise>
												<a href="#" class="btn btn-primary">Buy Now!</a>
												<a
													href="cont_detail.oncont?mnum=${memberDTO.mnum }&ocnum=${contData.OCNUM }"
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
		</c:otherwise>
	</c:choose>


</div>
<!-- ------------------------------------------------------------------------- -->

<!-- 실강 -->
<div class="row">
	<div class="col-lg-12">
		<h3>후원</h3>
	</div>
</div>
<!-- /.row -->

<!-- Page Features -->
<div class="row text-center">

	<div class="col-md-3 col-sm-6 hero-feature">
		<div class="thumbnail">
			<img src="http://placehold.it/800x500" alt="">
			<div class="caption">
				<h3>Feature Label</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
				<p>
					<a href="#" class="btn btn-primary">Buy Now!</a> <a href="#"
						class="btn btn-default">More Info</a>
				</p>
			</div>
		</div>
	</div>

	<div class="col-md-3 col-sm-6 hero-feature">
		<div class="thumbnail">
			<img src="http://placehold.it/800x500" alt="">
			<div class="caption">
				<h3>Feature Label</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
				<p>
					<a href="#" class="btn btn-primary">Buy Now!</a> <a href="#"
						class="btn btn-default">More Info</a>
				</p>
			</div>
		</div>
	</div>
</div>
<%@ include file="../bottom.jsp"%>
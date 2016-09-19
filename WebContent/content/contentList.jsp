<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../top.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="../css/usercont_list.min.css" rel="stylesheet">
<script src="js/contentList.js"></script>
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
					<li><a href="list.content?ctnum=${cateDTO.ctnum }"><c:out
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
					<button type="button" onclick="location.href='cont_insert.content'"
						style="float: right;">강의 등록</button>
				</c:otherwise>
			</c:choose>
		</h3>
	</div>
	<div></div>
</div>
<!-- /.row -->
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../top.jsp"%>
<%@ include file="mypage_top.jsp"%>
<div class="container">





	<script type="text/javascript"
		src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-filestyle.min.js">
		
	</script>








	<!-- Portfolio Item Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">
				사용자 프로필 <small>등급?????????</small>
			</h1>
		</div>
	</div>
	<!-- /.row -->

	<!-- Portfolio Item Row -->
	<div class="row">

		<div class="col-md-6">
			<img class="img-responsive" src="http://placehold.it/750x500" alt=""
				style="border-radius: 10px;">




			<div class="form-group" style="margin: 10px;">
				<form action="profimage_merge.mypage" method="post"
					accept-charset="UTF-8" enctype="multipart/form-data">
					<div class="col-md-9">
						<input type="file" id="BSbtninfo" name="profimage"> <input
							type="hidden" name="mnum" value="${memberDTO.mnum }" />
					</div>
					<div class="col-md-3" style="margin-left: 0px; padding-left: 0px;">
						<button type="submit" class="btn btn-default btn-block">사진
							변경</button>
					</div>

				</form>
			</div>


		</div>

		<div class="col-md-6">
			<h3>소개</h3>
			<p>저는 바보입니다.</p>
			<h3>바보의 연혁?</h3>
			<ul>
				<li>정바보</li>
				<li>정뭉충</li>
				<li>정소심</li>
				<li>하니</li>
			</ul>
		</div>



	</div>
	<!-- /.row -->

	<!-- Related Projects Row -->
	<div class="row">

		<div class="col-lg-12">
			<h3 class="page-header">듣는 강좌? 사진? 강연? 뭐야?</h3>
		</div>

		<div class="col-sm-3 col-xs-6">
			<a href="#"> <img class="img-responsive portfolio-item"
				src="http://placehold.it/500x300" alt="">
			</a>
		</div>

		<div class="col-sm-3 col-xs-6">
			<a href="#"> <img class="img-responsive portfolio-item"
				src="http://placehold.it/500x300" alt="">
			</a>
		</div>

		<div class="col-sm-3 col-xs-6">
			<a href="#"> <img class="img-responsive portfolio-item"
				src="http://placehold.it/500x300" alt="">
			</a>
		</div>

		<div class="col-sm-3 col-xs-6">
			<a href="#"> <img class="img-responsive portfolio-item"
				src="http://placehold.it/500x300" alt="">
			</a>
		</div>

	</div>
	<!-- /.row -->

	<hr>

</div>




<script>
	$('#BSbtninfo').filestyle({
		buttonName : 'btn-info',
		buttonText : ' Select a File'
	});
</script>





<%@ include file="../bottom.jsp"%>
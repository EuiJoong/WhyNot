<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../top.jsp"%>
<%@ include file="mypage_top.jsp"%>


<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- 1. -->

<c:set var="visitedPw" value="${visitedPw }" />
<c:set var="validPw" value="${validPw }" />


<c:if test="${visitedPw != null }">
	<c:choose>
		<c:when test="${validPw == true }">

			<!-- Small modal -->
			<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">Small modal</button> -->

			<script>
				$(document).ready(function() {

					$("#myModal").modal();
					
				});
			</script>


			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">×</button>
							<h4 class="modal-title">비밀번호 변경</h4>
						</div>
						<div class="modal-body" style="height: 69px;">

							<!-- 모달 내용 -->

							<form action="updatePasswd.mypage" method="post">
								<div class="col-md-9">
									<input type="password" class="form-control"	id="exampleInputPassword1" name="updatePw" placeholder="변경할 비밀번호를 입력하세요.">
								</div>
								<div class="col-md-3">
									<input type="hidden" name="mnum" value="${memberDTO.mnum }" />
									<button type="submit" class="btn btn-default btn-block">비밀번호 변경</button>
								</div>
							</form>

						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>

				</div>
			</div>	

		</c:when>
		<c:otherwise>
			

			<!-- Small modal -->
			<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">Small modal</button> -->

			<script>
				$(document).ready(function() {

					$("#myModal").modal();
				});
				
				
				
			</script>


			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">×</button>
							<h4 class="modal-title">비밀번호가 틀렸습니다.</h4>
						</div>
						<div class="modal-body" style="height: 40px;">

							<!-- 모달 내용 -->

							확인을 누르시고 비밀번호를 다시 입력해 주세요.

						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">확인</button>
						</div>
					</div>

				</div>
			</div>	
		</c:otherwise>
	</c:choose>
	<script type="text/javascript">
		
	</script>

</c:if>












<div class="container" style="padding: 4rem;">

<div class="col-md-2"></div>

<div class="col-md-8">

	<div class="panel panel-default">
		<div class="panel-heading" role="tab" id="headingOne">
			<h4 class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion"
					href="#collapseOne" aria-expanded="true"
					aria-controls="collapseOne"> 비밀번호 변경 </a>
			</h4>
		</div>
		<div id="collapseOne" class="panel-collapse collapse in"
			role="tabpanel" aria-labelledby="headingOne">
			<div class="panel-body">
				<form action="validPasswd.mypage" method="post">
					<div class="col-md-9">
						<input type="password" class="form-control"
							id="exampleInputPassword1" name="pswd" placeholder="비밀번호를 변경 하시려면 비밀번호를 입력하세요.">
					</div>
					<div class="col-md-3">
						<input type="hidden" name="mnum" value="${memberDTO.mnum }" />
						<button type="submit" class="btn btn-default btn-block">비밀번호
							변경</button>
					</div>
				</form>

			</div>
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading" role="tab" id="headingTwo">
			<h4 class="panel-title">
				<a class="collapsed" data-toggle="collapse" data-parent="#accordion"
					href="#collapseTwo" aria-expanded="false"
					aria-controls="collapseTwo"> 준비 중 입니다. </a>
			</h4>
		</div>
		<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel"
			aria-labelledby="headingTwo">
			<div class="panel-body">b</div>
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading" role="tab" id="headingThree">
			<h4 class="panel-title">
				<a class="collapsed" data-toggle="collapse" data-parent="#accordion"
					href="#collapseThree" aria-expanded="false"
					aria-controls="collapseThree"> 준비 중 입니다. </a>
			</h4>
		</div>
		<div id="collapseThree" class="panel-collapse collapse"
			role="tabpanel" aria-labelledby="headingThree">
			<div class="panel-body">c</div>
		</div>
	</div>
	</div>
	<div class="col-md-2"></div>
</div>


<%@ include file="../bottom.jsp"%>
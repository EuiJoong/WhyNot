<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp"%>
<!-- css 는 밑에 링크 파일에!! -->
<link
	href="${pageContext.request.contextPath}/css/usercont_detail.min.css"
	rel="stylesheet">
<!-- 상단 메뉴바가 css로 인해서 윗부분이 겹쳐서 div로  style="padding: px" 줌 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/sponsor.css">
<!-- player skin -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">

<!-- player skin -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/dist/minimalist.css?f">
<!-- site specific styling -->

<script type="text/javascript">
	function init(){
		if('${res}' != null) {
			var res = '${res}';
			if(res == 'notLogin'){
				alert("로그인을 해야 후원을 할 수 있습니다.")
				return
			}	
			if(res == 'full') {
				alert("참여 인원이 충분하지 않아 실패했습니다. ")
				return
			}
			if(res == 'mileage') {
				if(confirm("마일리지가 부족합니다. 충전페이지로 이동하시겠습니까?")){
					window.location = "paymentForm.payment?mnum='${memberDTO.mnum}'"
				}
				return
			}
			if(res == 'fail'){
				alert("후원에 실패했습니다.")
				return
			}
		}
	}
	
	function sponsorChk(min){
		var sponsorAmount = null;
		var particiChk = "no";
		if(document.getElementById("radio1").checked == true){
			if(window.confirm("후원 및 강의참여를 선택하셨습니다. 아니면 취소버튼을 눌러주세요!")){
				particiChk = "ok";
			} else {
				return
			}
		}
		if(document.getElementById("radio2").checked == true){
			if(window.confirm("후원만을 선택하셨습니다. 아니면 취소버튼을 눌러주세요!")){
			} else {
				return
			}
		}
	
		while(true) {
			sponsorAmount = window.prompt("후원할 금액을 입력해 주세요. (최소금액 "+min+"원)")
			if(sponsorAmount == null ){
				if(window.confirm("값을 입력하지 않았습니다.")){continue;
				}else{return;}	
			}else if(isNaN(sponsorAmount) == true) {
				if(window.confirm("숫자만 입력 가능합니다.")){continue;
				}else{return;}
			}else if(parseInt(sponsorAmount)<parseInt(min)) {
				if(window.confirm("최소금액 보다 큰 금액을 입력해주세요!")){continue;
				}else{return;}
			}else{
				break;
			}
		}
		sponPostSender(sponsorAmount,particiChk);
	} 
	
	function sponPostSender(sponsorAmount,particiChk){
		var form = document.createElement("form");
	    console.log("form생성")
	    form.setAttribute("method", "post");
	    form.setAttribute("action", "cont_sponsor.offcont");
	    console.log("method, action생성")
	    var params = {"sponsor" : sponsorAmount, "particiChk" : particiChk, "offnum" : '${offContentDTO.offnum}'}
	    console.log("params생성")
	    for(var key in params) {
	        var hiddenField = document.createElement("input");
	        hiddenField.setAttribute("type", "hidden");
	        hiddenField.setAttribute("name", key);
	        hiddenField.setAttribute("value", params[key]);
	        form.appendChild(hiddenField);
	    }
	    document.body.appendChild(form);
	    form.submit();
	}
</script>

<style>
body {
	font: 12px "Myriad Pro", "Lucida Grande", sans-serif;
}

.onImg {
  width: 200px;
  position: absolute;
  z-index: 1;
 
}
.onImgName {
  float: left;
}
.onImgMin {
  float: right;
}

</style>

<script src="${pageContext.request.contextPath}/dist/jquery.js"></script>

<body style="padding-top: 16px;" onload="javascript:init()">
	<!-- Page Content -->

	<div class="container">
		<div class="row">
			<!-- left division -->
			<!-- Post Content Column -->
			<div class="col-lg-8" style="margin-top: 32px">

				<!-- Blog Post -->
				<!-- Title -->
				<h1>${offContentDTO.title }</h1>
				<!-- Author -->
				<hr>
				<!-- Date/Time -->
				<p>
					by <a href="#" style="font-size: large; color: black;">${writer }</a>
					<!--  <span
							class="glyphicon glyphicon-time">날짜</span> -->
				</p>

				<hr>

				<!-- 여기부터 소개 할게욥~ -->

				<div class="row">

					<div class="col-md-4">
						<img
							src="${pageContext.request.contextPath}/img/defaultpro.png"
							alt="이미지 파일을 찾을 수 없습니다." width="200" height="150" />
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
				<!-- 사진 부분 -->
				<div align="center">
					<img
						src="${pageContext.request.contextPath}/images/${photoDTO.filename}.${photoDTO.fileext}"
						alt="이미지 파일을 찾을 수 없습니다." style="width: 600px; height: 350px;" />
				</div>
				<hr>

				<!-- Post Content -->
				<p class="lead">강의 소개</p>
				${offContentDTO.content}

				<hr>

				<!-- 건들지마요 이거 -->
			</div>
			<!-- /left division -->
			<!-- right division -->
			<!-- Blog Sidebar Widgets Column -->
			<div class="col-md-4" style="margin-top: 50px;">

				<!-- 후원 정보 부 -->
				
					<div class="well" style="background-color:inherit; border-width: 0px; width: 400px; margin-left: 0px;">
					<!-- <form action="#"> -->
					
						<div style="margin-bottom: 5px; border-width: 0px;">
						  <div style="padding: 5px 10px; border-width: 0px;">
						    <h3 class="panel-title">목표 
								<fmt:formatNumber value="${offContentDTO.goal_amount}" type="number"/>원 중 
								<fmt:parseNumber value="${offContentDTO.sponsor/offContentDTO.goal_amount*100 }" integerOnly="true"/>
								% 모임</h3>
						  </div>
						  <div style="padding: 0px 10px; border-width: 0px;">
						    <font style="font-size: 35px">
								<fmt:formatNumber value="${offContentDTO.sponsor}" type="number"/>
							</font><font style="font-size: 20px">원</font>
						  </div>
						</div>

						<div style="margin-bottom: 5px;">
						 <div style="padding: 5px 10px; border-width: 0px;">
						    <h3 class="panel-title">남은 시간</h3>
						  </div>
						  <div style="padding: 0px 10px; border-width: 0px;">
						   <font style="font-size: 35px">
						  ${dDay }</font><font style="font-size: 20px">일</font>
						  </div>
						</div>

						<div style="margin-bottom: 5px;">
						 <div style="padding: 5px 10px; border-width: 0px;">
						    <h3 class="panel-title">후원자</h3>
						  </div>
						  <div style="padding: 0px 10px; border-width: 0px;">
						    <font style="font-size: 35px">
						    	${sponsorList.size() }
							</font><font style="font-size: 20px">명</font>
						  </div>
						</div>
						
						<!-- 후원 라디오버튼, 버튼 부 -->
						<c:if test="${memberDTO.name!=writer && !empty memberDTO}">
							<c:choose>
							<c:when test="${offContentDTO.particnum >= classRoomDTO.max_num}">	<!-- 정원이 꽉찼을때 -->
								<div style="margin: 10px 2px 0px;">
								<input type="radio" name="sponRadio" id="radio1" value="ok" disabled>
							       <label for="radio1">강의참여</label>
							    <input type="radio" name="sponRadio" id="radio2" value="no" checked>
							       <label for="radio2">후원만</label>
							   	<i>정원이 가득차 후원만 가능합니다.</i>  
							    </div>
							</c:when>
							<c:when test="${isPartici=='ok'}">	<!-- 이미 참여신청을 했을때 -->
								<div style="margin: 10px 2px 0px;">
								<input type="radio" name="sponRadio" id="radio1" value="ok" disabled>
							       <label for="radio1">강의참여</label>
							    <input type="radio" name="sponRadio" id="radio2" value="no" checked>
							       <label for="radio2">후원만</label>
							     <i>이미 참여신청을 하여 후원만 가능합니다.</i>
							    </div>
						    </c:when>   
						    <c:otherwise>
						    	<div style="margin: 10px 2px 0px;">
								<input type="radio" name="sponRadio" id="radio1" value="ok" checked>
							       <label for="radio1">강의참여</label>
							    <input type="radio" name="sponRadio" id="radio2" value="no">
							       <label for="radio2">후원만</label>
									<i>최소금액 이상만 후원 가능합니다.</i>
							
							    </div>
						    </c:otherwise>
						    </c:choose>
						    
							 <a href="javascript:sponsorChk('${offContentDTO.min_amount}')" class="c-pledge_button js-show-pledge-button" style="margin-top: 5px;">
							 	<span class="c-pledge_button__label">강의 후원하기</span>
							 	<span class="c-pledge_button__help"> 최소금액은 
									<fmt:formatNumber value="${offContentDTO.min_amount}" type="number"/>
								원입니다.</span>
							 </a>
						</c:if>
						
						
					</div>
				

				<!-- 강의장 정보 -->
				<div data-scroll='sticky' data-top-offset='13'
					data-bottom-offset='39' data-remote-body='.b-sidebar'>
					<div class="b-panel box" data-ui-component="profile-card" style="margin :0px 10px 0px 10px;">
						<div class="b-panel__head"></div>
						<div class="b-panel__body has-no-pad">
							<ul class="b-profile_card">
								<h5 class="b-profile_card__title">강의장 정보</h5>
								<div class="b-profile_card__identity"  align="center" >
									<font style="font-family: 맑은 고딕; font-size: 25px">${offContentDTO.particnum } / ${classRoomDTO.max_num } 명</font> 
									<font style="font-family: 맑은 고딕; font-size: 13px">&nbsp;&nbsp;참여신청</font>
								</div>

								<div class="u-clear"></div>

								<li class="b-profile_card__sns" style="padding-left: 20px"><i
									class="b-fontello b-fontello--pledged b-fontello--pledged is_on"></i>
									${classRoomDTO.addr }</li>

								<li class="b-profile_card__contacts" style="font-size: 15px; padding: 3px 0px">
									${reserveDate }&nbsp;&nbsp;&nbsp; ${classRoomDTO.time } 예정 
								</li>
								<div class="u-clear"></div>
							</ul>
							<!-- b-profile_card -->
						</div>
					</div>

				</div>
			</div>
		<!-- /.row -->
		<hr>

	</div>
</body>

</html>

<%@ include file="../../bottom.jsp"%>
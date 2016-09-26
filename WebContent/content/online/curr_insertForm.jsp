<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- css 는 밑에 링크 파일에!! -->
<!-- Daum Web Editor -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/daumeditor/css/editor.css"
	type="text/css" charset="utf-8" />

<script
	src="${pageContext.request.contextPath}/daumeditor/js/editor_loader.js?environment=development"
	type="text/javascript" charset="utf-8"></script>
<!--------------------->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/css/bootstrap-select.min.css">

<style>
#div-padding1 {
	padding: 80px;
}

#div-padding2 {
	padding-left: 63px;
	padding-right: 18px;
}

#div-position1 {
	text-align: center;
}

#botton1 {
	float: right;
	width: 35%;
}

#title {
	width: 400px;
	margin-right: 10px;
}

#price {
	width: 400px;
}

.float-left {
	float: left;
}

.form-group2 {
	width: 100%;
}

.lable-position {
	padding-top: 6px;
	padding-right: 8px;
}

.text-padding {
	padding-bottom: 8px;
	margin-top: 2px;
}

.fileform {
	padding: 8px;
	background-color: white;
}

#topbody {
	padding-top: 5px;
	margin-top: 25px;
}
</style>
<c:set var="lsnum" value="${param.lsnum }"></c:set>
<c:set var="ocnum" value="${param.ocnum }"></c:set>
<div id="topbody">
	<div class="body" id="topbody">
		<!-- 에디터 시작 -->
		<!--
		@decsription
		등록하기 위한 Form으로 상황에 맞게 수정하여 사용한다. Form 이름은 에디터를 생성할 때 설정값으로 설정한다.
	-->
		<form name="tx_editor_form" id="tx_editor_form"
			action="curri_insertPro.curr?lsnum=${lsnum }&ocnum=${ocnum}" method="post" accept-charset="UTF-8"
			enctype="multipart/form-data">
			<input type="hidden" name="mnum"
				value="${sessionScope.memberDTO.mnum }" /> <input type="hidden"
				name="lsnum" value="${lsnum }">
			<div class="form-group ">

				<!-- 상단 내용 -->
				<div class="col-sm-10 text-padding">
					<label class="control-label float-left lable-position">제 목
						:</label> <input type="text" class="form-control" id="title" name="title"
						style="float: left; padding-right: 10px" placeholder="제목을 입력하세요.">
				</div>
				<div class="col-sm-10 text-padding">
					<label class="control-label float-left lable-position text-padding">이미지
						: </label> <input type="file" class="fileform" id="image-file"
						name="image-file">
				</div>

				<div class="col-sm-10 text-padding">
					<label class="control-label float-left lable-position text-padding">동영상
						: </label> <input type="file" class="fileform" id="video-file"
						name="video-file">
				</div>
				<button type="submit">저장</button>
			</div>
		</form>
	</div>
</div>
<%@ include file="../../bottom.jsp"%>
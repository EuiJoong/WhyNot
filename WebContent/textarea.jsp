<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title></title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/css/bootstrap-select.min.css">
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/js/bootstrap-select.min.js"></script>
<!-- include summernote css/js-->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js"></script>
<script src="js/summernote-ko-KR.js"></script>
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
</style>
<script type="text/javascript">
	function abcd() {
		alert("zzz");
		var aa = document.f.fff.value;
		alert(aa);
		if (document.f.fff.value != null)
			location.href = "main.app?text=" + content;
	}
</script>
</head>
<body>
	<div id="div-padding1">
		<form class="form-horizontal" name="f" action="main.app" method="post">
			<div class="form-group">
				<label class="control-label float-left">제 목 :</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="title"
						style="float: left; padding-right: 10px" placeholder="제목을 입력하세요.">
					<select class="selectpicker">
						<option>Mustard</option>
						<option>Ketchup</option>
						<option>Relish</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label float-left">가 격 :</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="price"
						placeholder="가격을 입력하세요.">
				</div>
			</div>
			<!-- <div class="form-group">
            <label for="comment" align=center>내 용 :</label>
            <textarea class="form-control" rows="8" id="comment"></textarea>
         </div> -->

			<div id="summernote">
				<span id="fff" name="fff">어쩌라는거야....</span>
			</div>

			<input type="file" class="filestyle" data-icon="false">


			<div class="form-group">
				<div id="div-position1">
					<button type="submit" class="btn btn-default" onclick="abcd()">Submit</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script>
	$('#summernote').summernote({
		height : 300, // set editor height
		minHeight : null, // set minimum height of editor
		maxHeight : null, // set maximum height of editor
		focus : true
	// set focus to editable area after initializing summernote

	});
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<link href="css/user_payment.min.css" rel="stylesheet">
<script type="text/JavaScript" src="js/mileage.singup.js"></script>

<body>
	<article class="container">
	<div class="page-header">
		<h1>
			마일리지 <small>너는 이미 충전하고 있다</small>
		</h1>
	</div>
	<div class="col-md-6 col-md-offset-3">
		<form name="f" action="select.mileage" method="post">
			<div class="form-group" id ="money" name = "money" class="form-control">
				<label for="money">결재 상품 선택</label>
				<div class="btn-group input-group" data-toggle="buttons"  name = "money">
					<label class="btn btn-success"> 
					<input type="radio"	id="money1" name="money" />1000원</label><!-- 스타일풀어보면 체크 되어 있어요 -->
					<label class="btn btn-success"> 
					<input type="radio"	id="money2" name="money" />5000원</label>
					<label class="btn btn-success"> 
					<input type="radio"	id="money3" name="money" />10000원</label>
					<label class="btn btn-success"> 
					<input type="radio"	id="money4" name="money" />30000원</label>
				</div>
			</div>
			
			<div class="form-group" id="tool" name="tool" class="form-control">
				<label for="tool">결재 수단</label>
				<div class="btn-group input-group" name="tool" data-toggle="buttons">
					<label class="btn btn-success"> 
					<input type="radio"	id="tool1" name="tool" />휴대전화 </label>
					<label class="btn btn-success"> 
					<input type="radio"	id="tool2" name="tool" />신용카드 </label>
				</div>
			</div>
			<div class="form-group text-center">
				<button type="submit" class="btn btn-info" onclick="chk()">	결재요청<i class="fa fa-check spaceLeft"></i></button>
				<button type="button" class="btn btn-warning" onclick="location.href='main.app'">취소<i class="fa fa-times spaceLeft"></i></button>
			</div>
	</form>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> <script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>
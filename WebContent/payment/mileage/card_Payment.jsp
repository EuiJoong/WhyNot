
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
			카드 충전
		</h1>
	</div>
	<div class="col-md-6 col-md-offset-3">
		<form name="f" action="card.mileage" method="post">
		<div class ="label">
		<label>결제 금액  ${money}원</label>
		</div><br><br>
		<div class = "form-group" name ="card_num" >
		<label>신용카드 번호</label><br>
		<div>
		<input type="text" id = "card_num1" class="form-control" maxlength="4"> - 
		<input type="text" id = "card_num2" class="form-control" maxlength="4"> - 
		<input type="text" id = "card_num3" class="form-control" maxlength="4"> - 
		<input type="text" id = "card_num4" class="form-control" maxlength="4">
		</div></div><br>
		<div class = "form-group" id = "card_day">
		<input type="text" id = "card_day1" class="form-control" placeholder="MM" maxlength="2"> - 
		<input type="text" id = "card_day2" class="form-control" placeholder="YY" maxlength="2">
		<input type="text" id = "card_cvc" class="form-control" placeholder="CVC" maxlength="3">
		</div><br><br>
			<div class="form-group text-center">
				<button type="submit" class="btn btn-info" onclick="card_chk()">	결재요청<i class="fa fa-check spaceLeft"></i></button>
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
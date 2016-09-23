<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<link href="../../css/user_payment.min.css" rel="stylesheet">
<script type="text/JavaScript" >


function isCard_num() {

	if (document.f.card_num.card_num1.value == ""||
		document.f.card_num.card_num2.value == ""||
		document.f.card_num.card_num3.value == ""||
		document.f.card_num.card_num4.value == ""||
		document.f.card_day.card_day1.value == ""||
		document.f.card_day.card_day2.value == ""||
		document.f.card_day.card_cvc.value == "") {
		alert("카드번호를 적어주세요");
		document.f.card_num.card_num1.focus();
		exit;
	}
	/*
	var exptext = /([0-9])+/g//숫자만
	if(	exptext.test(document.f.card_num.card_num1.value)==false||
		exptext.test(document.f.card_num.card_num2.value)==false||
		exptext.test(document.f.card_num.card_num3.value)==false||
		exptext.test(document.f.card_num.card_num4.value)==false||
		exptext.test(document.f.card_day.card_day1.value)==false||
		exptext.test(document.f.card_day.card_day2.value)==false||
		exptext.test(document.f.card_day.card_cvc.value)==false){
		alert("카드번호가 이상합니다!!");
		document.f.card_num.card_num1.focus();
		exit;
	}*/
	
}
function card_chk() {

	if(isCard_num()){
		return;
	}
	document.f.submit();
	
}




</script>

<body style="padding: 20px">
	<div class="page-header">
		<h1>
			카드 충전
		</h1>
	</div>
	<div class="col-md-6 col-md-offset-3">
		<form name="f" action="/WhyNot/purchase.payment" method="post">
			<input type="hidden" name = "mnum" value="${param.mnum}">
			<input type="hidden" name = "bway" value="${param.bway}">
			<input type="hidden" name = "amount" value="${param.amount}">amount
		<div class ="label">
		<label>결제 금액  ${param.amount}원</label>
		</div><br><br>
		<div class = "form-group" >
		<label>신용카드 번호</label><br>
		<div>
		<input type="text" id = "card_num1" name = "card_num" class="form-control" maxlength="4"> -
		<input type="text" id = "card_num2" name = "card_num" class="form-control" maxlength="4"> -
		<input type="text" id = "card_num3" name = "card_num" class="form-control" maxlength="4"> -
		<input type="text" id = "card_num4" name = "card_num" class="form-control" maxlength="4">
		</div></div><br>
		<div class = "form-group">
		<input type="text" id = "card_day1" name = "card_day" class="form-control" placeholder="MM" maxlength="2"> -
		<input type="text" id = "card_day2" name = "card_day"  class="form-control" placeholder="YY" maxlength="2">
		<input type="text" id = "card_cvc" name = "card_day"  class="form-control" placeholder="CVC" maxlength="3">
		</div><br><br>
			<div class="form-group text-center">
				<button type="button" class="btn btn-info" onclick="card_chk()">	결재요청<i class="fa fa-check spaceLeft"></i></button>
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

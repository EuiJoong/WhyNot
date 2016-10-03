<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link href="../../css/user_payment.min.css" rel="stylesheet">
<script type="text/JavaScript">
	function chkcard() {
		
		if (f.card_num1.value == ""){
			alert("카드번호를 적어주세요");
			f.card_num1.focus();
			return false;
		}else if(f.card_num1.value.length !=4){
				alert("카드 4자리 이상 입니다.");
				f.card_num1.focus();
				return false;
		}else if(f.card_num2.value==""){
			alert("카드번호를 적어주세요");
			f.card_num2.focus();
			return false;
		}else if(f.card_num2.value.length !=4){
			alert("카드 4자리 이상 입니다.");
			f.card_num2.focus();
			return false;
	
		}else if(f.card_num3.value==""){
			alert("카드번호를 적어주세요");
			f.card_num3.focus();
			return false;
		}else if(f.card_num3.value.length !=4){
			alert("카드 4자리 이상 입니다.");
			f.card_num3.focus();
			return false;
	
		}else if (f.card_num4.value == ""){
			alert("카드번호를 적어주세요");
			f.card_num4.focus();
			return false;
		}else if(f.card_num4.value.length !=4){
			alert("카드 4자리 이상 입니다.");
			f.card_num4.focus();
			return false;
	
		}else if(f.card_day1.value==""){
			alert("카드날짜를 적어주세요");
			f.card_day1.focus();
			return false;
		}else if(f.card_day1.value.length !=2){
			alert("day는 2자리 이상 입니다.");
			f.card_day1.focus();
			return false;
	
		}else if(f.card_day2.value==""){
			alert("카드날짜를 적어주세요");
			f.card_day2.focus();
			return false;
		}else if(f.card_day2.value.length !=2){
			alert("년도는 2자리 이상 입니다.");
			f.card_day2.focus();
			return false;
	
		}else if(f.card_cvc.value==""){
			alert("카드날짜를 적어주세요");
			f.card_cvc.focus();
			return false;
		}else if(f.card_cvc.value.length !=3){
			alert("cvc 는 3자리 이상 입니다.");
			f.card_cvc.focus();
			return false;
	
		}
		
		return true;
	}
	</script>
<script type="text/javascript">
function onlyNumber(event) {
	event = event || window.event;
	var keyID = (event.which) ? event.which : event.keyCode;
	if ((keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105)
			|| keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39)
		return;
	else
		return false;
}
function removeChar(event) {
	event = event || window.event;
	var keyID = (event.which) ? event.which : event.keyCode;
	if (keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39)
		return;
	else
		event.target.value = event.target.value.replace(/[^0-9]/g, "");
}
</script>
<body style="padding: 10px">
	<div class="page-header">
		<h1>카드 충전</h1>
	</div>
	<div class="col-md-6 col-md-offset-3">
		<form name="f" action="purchasePro.payment" method="post" onsubmit="return chkcard()">
			<input type="hidden" name="mnum" value="${param.mnum}"> <input
				type="hidden" name="bway" value="${param.bway}"> <input
				type="hidden" name="amount" value="${amount}">
			<div class="label">
				<label>결제 금액 ${amount}원</label>
			</div>
			<br>
			<br>
			<div class="form-group">
				<label>신용카드 번호</label><br>
				<div>
				<input type="text" id="card_num1" name="card_num1" class="form-control" maxlength="4" size="4"
					onkeydown="return onlyNumber(event)" onkeyup="removeChar(event)" style="ime-mode: disabled;"> - 
				<input type="text" id="card_num2" name="card_num2" class="form-control" maxlength="4" size="4"
					onkeydown="return onlyNumber(event)" onkeyup="removeChar(event)" style="ime-mode: disabled;"> -
				<input type="text" id="card_num3" name="card_num3" class="form-control" maxlength="4" size="4"
					onkeydown="return onlyNumber(event)" onkeyup="removeChar(event)" style="ime-mode: disabled;"> - 
				<input type="text"id="card_num4"  name="card_num4" class="form-control" maxlength="4" size="4"
					onkeydown="return onlyNumber(event)" onkeyup="removeChar(event)" style="ime-mode: disabled;">
				</div>
			</div>
			<br>
			<div class="form-group">
				<input type="text" id="card_day1" name="card_day1" class="form-control" placeholder="MM" maxlength="2"  size="2"
					onkeydown="return onlyNumber(event)" onkeyup="removeChar(event)" style="ime-mode: disabled;"> - 
				<input type="text" id="card_day2" name="card_day2" class="form-control"	placeholder="YY" maxlength="2"  size="2"
					onkeydown="return onlyNumber(event)" onkeyup="removeChar(event)" style="ime-mode: disabled;"> 
				<input type="text" id="card_cvc" name="card_cvc" class="form-control" placeholder="CVC" maxlength="3"	size="3"
					onkeydown="return onlyNumber(event)" onkeyup="removeChar(event)" style="ime-mode: disabled;">
			</div>
			<br>
			<br>
			<div class="form-group text-center">
				<button type="submit" class="btn btn-info">
					결재요청<i class="fa fa-check spaceLeft"></i>
				</button>
				<button type="button" class="btn btn-warning" onclick="self.close()">
					취소<i class="fa fa-times spaceLeft"></i>
				</button>
			</div>
		</form>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>

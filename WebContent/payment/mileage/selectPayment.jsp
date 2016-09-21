<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<link href="../../css/user_payment.min.css" rel="stylesheet">
<script type="text/JavaScript" src="../../js/mileage.singup.js"></script>

<body style="padding: 20px">
	<div class="page-header">
		<h1>
			마일리지 <small>너는 이미 충전하고 있다</small>
		</h1>
	</div>
	<div class="col-md-6 col-md-offset-3">
		<form name="f" action="select.payment" method="post" >
			<input type="hidden" name = "mnum" value="${param.mnum}">
			<input type="hidden" name = "bway" value="1">
			<div class="form-group" id ="amount" name = "amount" class="form-control">
				<label for="money">결재 상품 선택</label>
				<div class="btn-group input-group" data-toggle="buttons"  name = "amount">
					<label class="btn btn-success">
					<input type="radio"	id="amount1" name="amount" value = "1000" />1000원</label><!-- 스타일풀어보면 체크 되어 있어요 -->
					<label class="btn btn-success">
					<input type="radio"	id="amount2" name="amount" value = "5000" />5000원</label>
					<label class="btn btn-success">
					<input type="radio"	id="amount3" name="amount" value = "10000" />10000원</label>
					<label class="btn btn-success">
					<input type="radio"	id="amount4" name="amount" value = "30000" />30000원</label>
				</div>
			</div>
			<div class="form-group" id="tool" name="tool" class="form-control">
				<label for="tool">결재 수단</label>
				<div class="btn-group input-group" name="tool" data-toggle="buttons">
					<label class="btn btn-success">
					<input type="radio"	id="tool1" name="tool" value = "1" />휴대전화 </label>
					<label class="btn btn-success">
					<input type="radio"	id="tool2" name="tool" value = "2" />신용카드 </label>
				</div>
			</div>
			<div class="form-group text-center">
				<button type="button" class="btn btn-info" onclick="chk()">	결재요청<i class="fa fa-check spaceLeft"></i></button>
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

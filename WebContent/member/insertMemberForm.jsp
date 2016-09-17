<%@page import="member.mybatis.MemberMybatis"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../top.jsp"%>
<link href="css/usersingup.min.css" rel="stylesheet">
<script type="text/JavaScript" src="js/member.singup.js"></script>
<body style="padding: 20px">
	<article class="container">
	<div class="page-header">
		<h1>
			회원가입 <small>너는 이미 가입되어 있다</small>
		</h1>
	</div>
	<div class="col-md-6 col-md-offset-3">
		<form name="f" action="insertPro.member" method="post">
			<div class="form-group">
				<label for="id">아이디</label>
				<div class="form-group" style="background-color: black;">
					<input type="text" name="id" class="form-control-1" id="id"
						placeholder="id@mail.com" style="float: left;">
					<button type="button" class="btn btn-success" onclick="idCHK()"
						style="float: left;">인증번호 전송</button>
				</div>
			</div>
			<br> <br>
			<%
				//if(id!=null){
			%>
			<div class="form-group" class="form-inline">
				<label for="CHK">인증번호</label> <br> <input type="text"
					name="EmailCHK" class="form-control-1" id="CHK"
					placeholder="이메일 인증번호" style="float: left;">
				<samp>
					<button type="button" class="btn btn-success" style="float: left;">확인</button>
				</samp>
			</div>
			<%
				//}
			%>
			<br> <br>

			<div class="form-group">
				<label for="password1">비밀번호</label> <input type="password"
					name="password" class="form-control-1" id="passwd1"
					placeholder="비밀번호">
			</div>
			<div class="form-group">
				<label for="password2">비밀번호 확인</label> <input type="password"
					name="passwd2" class="form-control-1" id="passwd2"
					placeholder="비밀번호 확인">
				<!-- <p class="help-block">비밀번호 확인을 위해 다시한번 입력 해 주세요</p> -->
			</div>

			<div class="form-group">
				<label for="name">이름</label> <input type="text" name="name"
					class="form-control-1" id="name"
					placeholder="한글+영문 or 영문 + 한글 or 한글 or 영문 ">
			</div>

			<!--  -->
			<div class="form-group">
				<label for="gender">성별</label>
				<div class="btn-group input-group" data-toggle="buttons">
					<label class="btn btn-success"> <input type="radio"
						id="gender1" name="gender" checked="checked" value="남성">남성
					</label>
					<!-- 스타일풀어보면 체크 되어 있어요 -->
					<label class="btn btn-success"> <input type="radio"
						id="gender2" name="gender" value="여성" />여성
					</label>
				</div>
			</div>

			<div class="form-group">
				<label for="birthday">생년월일</label>
				<div class="input-group">
					<input type="text" name="birth" class="form-control-2"
						id="birthday" placeholder="YYYYMMDD" maxlength="8">
				</div>
			</div>

			<div class="form-group">
				<label for="interest">관심사항</label>
			</div>
			<span class="input-group-addon"> <input type="checkbox"
				name="interest" id="chkbox" onclick="chkBoxCheck(0)" value="카테고리1">카테고리1
				<input type="checkbox" name="interest" id="chkbox1"
				onclick="chkBoxCheck(1)" value="카테고리2">카테고리2 <input
				type="checkbox" name="interest" id="chkbox1"
				onclick="chkBoxCheck(2)" value="카테고리3">카테고리3
			</span>

			<div class="form-group">
				<h2>이용약관</h2>
				<textarea class="form-control" rows="10">
					제1조 [목적]

이 이용약관(이하 ‘약관’이라 합니다.)은 와이낫(이하 ‘회사’라 합니다.)가 제공하는 와이낫(WhyNot.com) 및 와이낫관련 제반 서비스(이하 ‘서비스’라 한다.)를 이용고객(이하 ‘회원’이라 합니다.)이 이용함에 있어 회사와 회원과의 권리, 의무 및 책임사항, 기타 필요한 사항을 구체적으로 규정함을 목적으로 합니다.
제2조 [용어의 정의]

(1) 이 약관에서 사용하는 용어의 정의는 다음과 같습니다.
– 서비스 : 구현되는 단말기와 상관없이 “회원” 혹은 웹사이트 방문자가 이용할 수 있는 인프런 서비스를 의미합니다.
– 회원 : “회사”의 서비스에 접속하여 본 약관에 따라 회사와 이용계약을 체결하고 “회사”가 제공하는 “서비스”를 이용하는 고객을 말합니다.
– 이용계약 : 이 약관을 포함하여 서비스 이용과 관련하여 회사와 회원 간에 체결하는 모든 계약을 말합니다. – 아이디(ID) : 회원의 식별 및 서비스 이용을 위하여 회원의 신청에 따라 회사가 회원 별로 부여하는 고유한 문자와 숫자의 조합을 말합니다.
– 이메일 : 회원가입이나 로그인 등에 사용되는 단일한 이메일 주소를 말합니다.
– 비밀번호(Password) : 아이디(ID)로 식별되는 회원의 본인 여부를 검증하기 위하여 회원이 설정하여 회사에 등록한 고유의 문자와 숫자의 조합을 말합니다.
– 유료서비스 : 회사가 유료로 제공하는 각종 온라인디지털콘텐츠(동영상 강좌, 프리미엄 교육 정보, 기타 유료 콘텐츠를 포함.) 및 제반 서비스를 의미합니다.
– 충전 : 회사가 지정한 지불수단을 이용하여 회원이 현금을 회사에 지불하면 회사가 이에 상응하는 수량의 ‘사이버머니’를 당해 회원에게 지급하는 것을 말합니다.
– 해지 : 회사 또는 회원이 이용계약을 해약하는 것을 말합니다.
(2) 이 약관에서 사용하는 용어 중 제1항에서 정하지 아니한 것은 관계 법령 및 서비스 별 안내에서 정하는 바에 따르며, 그 외에는 일반 관례에 따릅니다.

제3조 [약관 효력 및 변경]

(1) 이 약관은 그 내용을 회사의 웹사이트에 게시하거나 기타의 방법으로 회원에게 공지함으로 효력이 발생합니다.

(2) 회사는 “약관의규제에관한법률”, “정보통신망이용촉진및정보보호등에관한법률(이하 “정보통신망법”)” 등 관련법을 위배하지 않는 범위에서 사전 고지 없이 이 약관의 내용을 변경할 수 있으며, 변경된 약관은 제1항과 같은 방법으로 공지 또는 통지함으로 효력이 발생됩니다.

(3) 회원은 정기적으로 웹사이트에 방문하여 약관의 변경사항을 확인하여야 합니다. 변경된 약관에 대한 정보를 알지 못해 발생하는 회원의 피해는 회사에서 책임지지 않습니다. 단 회원에게 불리한 약관의 개정의 경우에는 공지 외에 일정기간 전자우편, 쪽지, 로그인시 동의양식 등의 전자적 수단을 통해 따로 명확히 통지하도록 합니다.

(4) 회원은 변경된 약관에 동의하지 않을 경우 회원탈퇴를 요청할 수 있습니다. 변경된 약관의 효력발생일 이후에도 서비스를 계속 이용할 경우 약관의 변경사항에 동의한 것으로 간주됩니다.

제4조 [약관 외 준칙]

회사는 필요한 경우 서비스 내의 개별항목에 대하여 개별약관 또는 운영원칙(이하 ‘서비스 별 안내’라 합니다.)를 정할 수 있으며, 회원은 각 서비스 별 안내에 대해 회원가입과 동시에 동의한 것으로 간주합니다. 본 약관과 서비스 별 안내의 내용이 상충되는 경우에는 서비스 별 안내의 내용을 우선하여 적용합니다.
					</textarea>
				<div class="checkbox">
					<label> <input type="checkbox" name="box">약관에
						동의합니다.
					</label>
				</div>
			</div>
			<div class="form-group text-center">
				<button type="submit" class="btn btn-info" onclick="chk()">
					회원가입<i class="fa fa-check spaceLeft"></i>
				</button>
				<button type="button" class="btn btn-warning"
					onclick="location.href='main.app'">
					가입취소<i class="fa fa-times spaceLeft"></i>
				</button>
			</div>
		</form>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> <script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../js/bootstrap.min.js"></script>
</body>
<%@include file="../bottom.jsp"%>
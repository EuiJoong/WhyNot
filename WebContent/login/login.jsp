<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=1,initial-scale=1,user-scalable=1" />
<link
	href="http://fonts.googleapis.com/css?family=Lato:100italic,100,300italic,300,400italic,400,700italic,700,900italic,900"
	rel="stylesheet" type="text/css">
<!-- 이유는 모르겠지만 적용 안됨;;; index에 넣었음 -->
<link rel="stylesheet" type="text/css"
	href="../loginDesign/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="../loginDesign/css/styles.css" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<section class="login-form" style="padding: 5px">
		<div class="panel panel-default">
			<div class="panel-heading">USER LOGIN</div>
			<div class="panel-body">
				<form method="post" action="login.member" role="login">
					<!-- 쿠키 확인 -->
					<c:if test="${cookie != null }">
						<c:forEach var="cookieVal" items="${cookie}">
							<c:if test="${cookieVal.key == 'saveId' }">
								<c:set var="name" value="${cookieVal.key }" />
								<c:set var="value" value="${cookieVal.value.value }" />
							</c:if>
						</c:forEach>
					</c:if>
					<!-- 쿠키의 value 값이 있냐 없냐에 콤포넌트 출력 조정? -->
					<c:choose>
						<c:when test="${value != null }">
							<input type="email" class="form-control input-lg"
								placeholder="EMAIL ADDRESS" name="id" value="${value }" required>
						</c:when>
						<c:otherwise>
							<input type="email" class="form-control input-lg"
								placeholder="EMAIL ADDRESS" name="id" required>
						</c:otherwise>
					</c:choose>
					<input type="password" class="form-control input-lg" id="password"
						placeholder="PASSWORD" name="password" required> <label>
						<c:choose>
							<c:when test="${value != null }">
								<input type="checkbox" name="saveId" value="on"
									checked="checked">입력을 기억합니다
						</c:when>
							<c:otherwise>
								<input type="checkbox" name="saveId" value="on"> 입력을 기억합니다
						</c:otherwise>
						</c:choose>
					</label>
					<button type="submit" name="go"
						class="btn btn-lg btn-info btn-block" style="margin-top: 0">SIGN
						IN NOW</button>
					<button type="button" name="naver"
						class="btn btn-lg btn-info btn-block" onclick="location.href='http://www.naver.com'"
						style="background-image: url('img/naver1.png'); background-repeat: no-repeat; color: white">.</button>

					<div class="form-links">
						<span class="glyphicon glyphicon-question-sign text-primary"></span>
						<a href="#">Forgot your password ?</a><br /> <span
							class="glyphicon glyphicon-user text-primary"></span> <a href="insert.member">Create
							an account</a>
					</div>
				</form>
			</div>
		</div>
		<div>
			<a href="#">Do you need something ?</a>
		</div>
	</section>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="/loginDesign/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
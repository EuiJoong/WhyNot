<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE script PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link href="../../css/user_payment.min.css" rel="stylesheet">

<html>
<head></head>
<script type="text/javascript">
    function eexit() {
            // 자동 실행 할 javascript 함수 또는 코드를 넣는다.
    	opener.location.href = "insert.member?id=${id}";	
    	self.close();	
    };
</script>
<body onload="eexit()">
</body>
</html>




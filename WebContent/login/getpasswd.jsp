<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	function chk() {
		var exptextId = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
		if(f.id.value ==""){
			alert("이메일을 입력해주세요");
			f.id.focus();
			return false;
		}
		
		var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
		if(exptext.test(document.f.id.value)==false){
			alert("이메일을 올바르게 입력해주세요!!");
			document.f.id.focus();
			return false;
			}
		return true;
	}    
</script>
<c:choose>
	<c:when test="${msg !=null }">
	<script type="text/javascript">
		alert("${msg}");
		self.close();
	</script>
	</c:when>
</c:choose>
		  

	<form  name="f" method="post" onsubmit="return chk()" action="getpasswdpro.member">
	<table border="1"style="width: 15em ">
	 <caption>비밀번호 찾기</caption>
	<tr>
	<td>아이디 : </td>
	<td><input  class="form-control"  type="text" name=id  ></td>
	</tr>
	<tr>
	<td colspan="2" align="right">
	<input type="submit" class="btn btn-default" value="전송">
	<input type="button"  class="btn btn-default"value="취소" onclick="self.close()">
	</td>
	</tr>
	
	</table>
	</form>
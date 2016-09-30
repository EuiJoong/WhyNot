<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Footer -->
<hr>
<footer>
<div class="row" align="center">
	<div class="col-lg-12">
		<p>Copyright &copy; 와이낫? 2016</p>
	</div>
</div>
</footer>
</div>
<!-- /.container -->
<!-- jQuery -->
<!--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> -->
    
<!-- <script -->
<!--  	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->

<!-- <script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script> -->
<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/js/bootstrap-select.min.js"></script>
<%-- <script src="${pageContext.request.contextPath}/js/jquery.js"></script> --%>

<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<%-- <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script> --%>

<!-- new-age Core JavaScript -->
<script src="${pageContext.request.contextPath}/js/new-age.min.js"></script>

<!-- Script to Activate the Carousel -->


<%-- 
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/js/bootstrap-select.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<!-- new-age Core JavaScript -->
<script src="${pageContext.request.contextPath}/js/new-age.min.js"></script> --%>
<!-- Script to Activate the Carousel -->
<script>
	$('.carousel').carousel({
		interval : 3000
	//changes the speed
	})	
</script>
<script>	<!-- 달력 설정 -->
	$(function() {
	    $( "#calendar" ).datepicker({
	        dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
	        dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
	        monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
	        monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	        dateFormat: "yymmdd",
	        minDate: "+7D", 
	        maxDate: "+30D"
	    });
	});
</script>
</body>

</html>
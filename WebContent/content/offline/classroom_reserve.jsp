<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.datepicker {
	z-index: 1600 !important; /* has to be larger than 1050 */
}

.modal-body {
	height: 250px;
	overflow-y: auto;
}
</style>
<script type="text/javascript">
   $(document).ready(function () {         
       $('#datepicker').datepicker({ 
       	 dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'], 
         	 dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
    	     monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'], 
     	     monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'], 
          	 dateFormat: "yymmdd",
           	 minDate: "+31D", 
 	         maxDate: "+40D" 
       });     
   });   
   
   $(document).ready(function () { 
	    $('#myModal').on('hide.bs.modal.prevent', function(e){
	    	 e.preventDefault();
	         return false;
	    });
	   }); 
	   
   $(document).ready(function () {      
       $("#reserveForm").submit(function(){
   	    var dataSet = $("#reserveForm").serialize();
   		 
   	    $.ajax({
			async: "true",   	
   	        type: "POST",
   	        url: "classroom_reserve.offcont",
   	        data: dataSet,
   	        success: function(data){
   	         $("#myModal").find(".modal-content").html(data);
   	        }
   	
   	    }); 
   	return false;
   	});
   }); 
   

   $(document).ready(function () { 
        $("#btnClose").on('click', function(){
            $('#myModal').off('hide.bs.modal.prevent');
            $("#myModal").modal('hide');
           });
        
   });
   
   
   </script>
	<script type="text/javascript">
	function selectOnlyThis(a) {
		  var obj = document.getElementsByName("reserve_chk");
	        for(var i=0; i<obj.length; i++){
	            if(obj[i] != a){
	                obj[i].checked = false;
	            }
	        }
	}
	
	       function reservePostSender(){ 
				if( document.all.reserve_chk==null){
					alert("강의장 검색을 먼저해주세요~!")
					return false;
				}
				chkbox_length = document.all.reserve_chk.length; 
				 for (var i=0;i<chkbox_length ;i++) 
				 { 
					  if (document.all.reserve_chk[i].checked == true ) 
					  { 
						 if(window.confirm("선택된 강의장을 예약 하시겠습니까?")) {
							    var form = document.createElement("form");
							    console.log("form생성")
							    form.setAttribute("method", "post");
							    form.setAttribute("action", "offcont_insertForm.offcont");
							    console.log("method, action생성")
							    var params = {"addr" : $('#td_addr'+i).html(), "reserve_date" : $('#td_rdate'+i).html(), "time" : $('#td_time'+i).html(), "max_num" : $('#td_max'+i).html(), "cr_num" : $('#cr_num'+i).html()}
							    console.log("params생성")
							    for(var key in params) {
							        var hiddenField = document.createElement("input");
							        hiddenField.setAttribute("type", "hidden");
							        hiddenField.setAttribute("name", key);
							        hiddenField.setAttribute("value", params[key]);
							        form.appendChild(hiddenField);
							    }
							    document.body.appendChild(form);
							    form.submit();
						 } 
						 break;
					 }
				 }
						 if (i == chkbox_length) 
						 { 
						 		 alert("예약 할 강의장을 선택하세요~!!"); 
						 } 
				
	       
	  		}
	</script>
<body onload="reservePostSender()">
<!-------------------------->
	<div class="modal-header">
		<h3 class="smaller lighter blue no-margin modal-title">강의실 대여하기</h3>
	</div>
	<!-------------------------->

	<!-------------------------->
	<div class="modal-body">
	
		<form id="reserveForm" name="reserveForm" method="post"
			class="form-horizontal bv-form">
			<div>
				<select name="addr" style="width: 80px; height: 25px">
					<option value="#">강의실</option>
					<c:forEach var="addr" items="${addrSet }">
						<option>${addr}</option>
					</c:forEach>
				</select> <input type="text" id="datepicker" name="reserve_date" readOnly
					placeholder="예약가능 날짜(+31 ~ 40일)" style="width: 200px;"> 
				<select name="time" style="width: 80px; height: 25px">
					<option value="#">시간</option>
					<option>09:00~12:00</option>
					<option>14:00~17:00</option>
				</select>
				<button style="float: right;" type="submit" data-toggle="modal"
					data-target="#myModal" style="margin-bottom: 10px;"
					data-backdrop="static" data-keyboard="false">검색</button>
			</div>
			<div class="form-group">
				<div class="table-responsive">
					<table class="table table-condensed" style="text-align: center;" id="searchTable">
						<thead>
							<tr>
								<th width="10%" style="text-align: center;">선택</th>
								<th width="25%" style="text-align: center;">장소</th>
								<th width="15%" style="text-align: center;">최대인원</th>
								<th width="15%" style="text-align: center;">날짜</th>
								<th width="20%" style="text-align: center;">시간</th>
								<th width="15%" style="text-align: center;">상태</th>
							</tr>
						</thead>
						<tbody id="selFabricanteBody">
							<c:choose>
								<c:when test="${searchList==null || searchList.size()==0 }">
									<tr>
										<td colspan="6">예약 가능한 강의실이 없습니다.</td>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach var="searchDTO" items="${searchList }"
										varStatus="status">
										<tr>
											<td>
												<div class="checkbox">
												<c:choose>
												<c:when test="${searchDTO.CL_RESERVE_STATS=='예약완료' }">
													<label> <input type="checkbox" name="reserve_chk" onclick="selectOnlyThis(this)"
														id="chk${status.index }" disabled>
													</label>
												</c:when>
												<c:otherwise>
													<label> <input type="checkbox" name="reserve_chk" onclick="selectOnlyThis(this)"
														id="chk${status.index }">
													</label>
												</c:otherwise>
												</c:choose>
												</div>
											</td>
											<td id="td_addr${status.index }">${searchDTO.ADDR }</td>
											<td id="td_max${status.index }">${searchDTO.MAX_NUM }</td>
											<td id="td_rdate${status.index }">${searchDTO.RESERVE_DATE }</td>
											<td id="td_time${status.index }">${searchDTO.TIME }</td>
											<td>
												<c:set var="fcolor" value="green"/>
												<c:if test="${searchDTO.CL_RESERVE_STATS=='예약완료' }">
													<c:set var="fcolor" value="red"/>	
												</c:if>
												<font color="${fcolor}">
													${searchDTO.CL_RESERVE_STATS }
												</font>
											</td>
										</tr>
										<div style="display: none;" id="cr_num${status.index }">${searchDTO.CR_NUM }</div>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>
			</div>
		</form>
	</div>

	<!-------------------------->

	<!-------------------------->
	<div class="modal-footer">
		<button class="btn btn-sm btn-warning" id="reserveGo" onclick="reservePostSender()"> 
			<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>예약하기
		</button>
		<button class="btn btn-sm btn-danger pull-right" data-dismiss="modal"
			id="btnClose">
			<i class="ace-icon fa fa-times"></i>닫기
		</button>
	</div>
	<!-------------------------->
</body>
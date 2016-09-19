<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../top.jsp"%>
<%@ include file="mypage_top.jsp"%>
<link href="../css/Nwagon.css" rel="stylesheet">
<div style="height: 50em">
	<div id="chart"></div>
	<script>
		
		var options = {
			'dataset': {
				title: 'Web accessibility status',
				values:[18, 12, 3, 10, 7],
				colorset: ['#56b4e9', '#e69f00', '#cc79a7', '#009e73', '#0072b2'],
				fields: ['A', 'B',  'C', 'D', 'E'] 
			},
			'donut_width' : 100, 
			'core_circle_radius':0,
			'chartDiv': 'chart',
			'chartType': 'pie',
			'chartSize': {width:600, height:300}
		};

		Nwagon.chart(options);
	</script>
</div>
<script src="../js/Nwagon.js"></script>
<script src="../js/Nwagon_no_vml.js"></script>
<%@ include file="../bottom.jsp"%>
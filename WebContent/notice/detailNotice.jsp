<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="ko">
<script type="text/javascript">
	function goOtherEvents() {
		location.href = "listNoticeEvent.notice";
	}
</script>
<head>

<script
	src='//assets.codepen.io/assets/editor/live/console_runner-d0a557e5cb67f9cd9bbb9673355c7e8e.js'></script>
<script
	src='//assets.codepen.io/assets/editor/live/events_runner-21174b4c7273cfddc124acb0876792e0.js'></script>
<script
	src='//assets.codepen.io/assets/editor/live/css_live_reload_init-7618a0de08795409d8f6c9ef6805f7b2.js'></script>
<meta charset='UTF-8'>
<meta name="robots" content="noindex">
<link rel="canonical" href="http://codepen.io/darcyvoutt/pen/dnEBj" />


<style class="cp-pen-styles">/* Mixings &  Variables */
.clearfix, .clearfix:before, .clearfix:after {
	display: block;
	content: " ";
	clear: both;
	zoom: 1;
}
/* Resets */
* {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

body {
	background: #EDF2F6;
	font-family: Arial;
	color: #444;
}

.wrap {
	margin: 0 auto;
	padding: 50px;
	max-width: 1200px;
}
/* Bar Graph Class */
.barGraph {
	position: relative;
	width: 100%;
	height: auto;
	margin-bottom: 50px;
}

.graph {
	position: relative;
	list-style-type: none;
	padding: 0;
	margin: 0;
	width: calc(96%);
	left: 4%;
}

.graph-barBack {
	border-radius: 2px;
	background: #DAE4EB;
	margin-bottom: 10px;
	display: block;
}

.graph-bar {
	background-color: #59BAC0;
	-webkit-transition: all 1s ease-out;
	-moz-transition: all 1s ease-out;
	-o-transition: all 1s ease-out;
	transition: all 1s ease-out;
	border-radius: 2px;
	cursor: pointer;
	margin-bottom: 10px;
	position: relative;
	z-index: 9999;
	display: block;
	height: 20px;
	width: 0%;
}

.graph-bar:hover {
	-webkit-transition: all 0.5s ease;
	-moz-transition: all 0.5s ease;
	-o-transition: all 0.5s ease;
	transition: all 0.5s ease;
	background: #428D92;
}

.graph-bar:last-child {
	margin-bottom: 0;
}

.graph-bar:after {
	position: absolute;
	content: attr(data-value);
	display: none;
	font-size: 12px;
	border-radius: 4px;
	background: rgba(0, 0, 0, 0.5);
	color: #fff;
	line-height: 20px;
	height: 20px;
	padding: 0 10px;
	margin-left: 5px;
	left: 100%;
	top: 0;
}

.graph-bar:hover:after {
	display: block;
}

.graph-legend {
	position: absolute;
	margin-right: 10px;
	left: -40px;
	z-index: 9999;
}
/* Bubble Chart */
.chart {
	border-radius: 3px;
	border: 2px solid rgba(113, 125, 149, 0.45);
	position: relative;
	overflow: hidden;
	width: 100%;
	height: 300px;
}

.chart-bubble {
	overflow: hidden;
	background-color: #59BAC0;
	-webkit-transition: all 1s ease-out;
	-moz-transition: all 1s ease-out;
	-o-transition: all 1s ease-out;
	transition: all 1s ease-out;
	position: absolute;
	border-radius: 100%;
	cursor: pointer;
	display: block;
	min-height: 10px;
	min-width: 10px;
	z-index: 999;
	bottom: 0;
	left: 0;
}

.chart-bubble:hover {
	-webkit-transition: all 0.5s ease;
	-moz-transition: all 0.5s ease;
	-o-transition: all 0.5s ease;
	transition: all 0.5s ease;
	background: #428D92;
}

.chart-bubble:after {
	position: absolute;
	content: attr(data-label);
	display: none;
	width: 100%;
	height: 100%;
	text-align: center;
	padding-top: 50%;
	line-height: 1px;
	font-size: 15px;
	color: #fff;
}

.chart-bubble:hover:after {
	display: block;
}
/* Lines for Charts */
.lines {
	position: absolute;
	height: 100%;
	width: 100%;
	z-index: 0;
	left: 0;
	top: 0;
}

.lines-horz {
	border-bottom: 1px dashed rgba(113, 125, 149, 0.4);
	position: absolute;
	width: 100%;
	height: 0px;
}

.lines-horz:nth-of-type(1) {
	top: 20%;
}

.lines-horz:nth-of-type(2) {
	top: 40%;
}

.lines-horz:nth-of-type(3) {
	top: 60%;
}

.lines-horz:nth-of-type(4) {
	top: 80%;
}

.lines-vert {
	border-right: 1px dashed rgba(113, 125, 149, 0.4);
	position: absolute;
	height: 100%;
	width: 1px;
}

.lines-vert:nth-of-type(5) {
	left: 20%;
}

.lines-vert:nth-of-type(6) {
	left: 40%;
}

.lines-vert:nth-of-type(7) {
	left: 60%;
}

.lines-vert:nth-of-type(8) {
	left: 80%;
}
/* Line Graph */
.lineChart {
	-webkit-transition: all 0.5s ease;
	-moz-transition: all 0.5s ease;
	-o-transition: all 0.5s ease;
	transition: all 0.5s ease;
	border-radius: 3px;
	border: 2px solid rgba(113, 125, 149, 0.45);
	position: relative;
	overflow: hidden;
	width: 100%;
	height: 300px;
}

.lineChart svg {
	position: absolute;
	z-index: 999;
}

.lineChart circle {
	-webkit-transition: all 0.5s ease;
	-moz-transition: all 0.5s ease;
	-o-transition: all 0.5s ease;
	transition: all 0.5s ease;
	position: relative;
	cursor: pointer;
	stroke: #59BAC0;
	stroke-width: 3;
	fill: #59BAC0;
}

.lineChart circle:hover {
	stroke-width: 8;
}

.lineChart line {
	stroke: #717D95;
	stroke-width: 4;
}

.trend line {
	stroke: rgba(204, 51, 51, 0.8);
}
</style>
<meta charset="utf-8">
</head>

<body>
	<c:set var="ndto" value="${ndto }" />
	<c:set var="nlist" value="${nlist }" />
	<a class="btn btn-primary" onclick="javascript:goOtherEvents()">목록</a>
	<div align="center">
		<form name="f" action="Vote.notice" method="post">
			<table border="1" style="width: 80%" class="barGraph">
				<tr class="graph">
					<th colspan="3"><h2>${ndto.title }</h2></th>
				</tr>
				<tr class="graph" style="height: 30em">
					<td colspan="3">${ndto.content }</td>
				</tr>
				<c:if test="${nlist != null }">

					<c:if test="${memberDTO.mnum == 0 || memberDTO==null }">
						<script>
							alert("로그인이 필요한 기능입니다.");
							window.close();
						</script>
					</c:if>
					<tr ><td style="text-align: center;"><strong>리스트</strong></td></tr>
					<c:forEach var="nlistDTO" items="${nlist }">
						<input type="hidden" name="mnum" value="${memberDTO.mnum }">
						<input type="hidden" name="name" value="${memberDTO.id }">
						<input type="hidden" name="eventnum" value="${ndto.eventnum }">
						<tr class="graph">
							<td>${nlistDTO.nomiName }<input type="radio" name="nominee"
								style="margin-left: 2em" value="${nlistDTO.nomiNum }"></td>
						</tr>
					</c:forEach>
					<tr class="graph" align="center">
						<td colspan="3"><input type="submit" value="투표하기"></td>
					</tr>
				</c:if>
			</table>
		</form>
	</div>
	<script
		src='//assets.codepen.io/assets/common/stopExecutionOnTimeout-53beeb1a007ec32040abaf4c9385ebfc.js'></script>
	<script
		src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script>
		$(document).ready(function() {
			$('.graph-bar').each(function() {
				var dataWidth = $(this).data('value');
				$(this).css('width', dataWidth + '%');
			});
		});
		$(document).ready(function() {
			$('.chart-bubble').each(function() {
				var bubbleSize = $(this).data('value');
				$(this).css('width', function() {
					return bubbleSize * 10 + 'px';
				});
				$(this).css('height', function() {
					return bubbleSize * 10 + 'px';
				});
				var posX = $(this).data('x');
				var posY = $(this).data('y');
				$(this).css('left', function() {
					return posX - bubbleSize * 0.5 + '%';
				});
				$(this).css('bottom', function() {
					return posY - bubbleSize * 0.5 + '%';
				});
			});
		});
		//# sourceURL=pen.js
	</script>
</body>
</html>
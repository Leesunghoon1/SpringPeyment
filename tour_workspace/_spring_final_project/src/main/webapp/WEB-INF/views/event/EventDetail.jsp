<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/Roulette.css">
<style type="text/css">
@font-face {
    font-family: 'Orbit-Regular';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2310@1.0/Orbit-Regular.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
}
canvas {
    /* font-family: Pretendard; */
    font-family: Orbit-Regular;
}
</style>
</head>
<body>
	
	<table class="table table-hover">
		<tr>
			<th>evNo</th>
			<td>${evo.evNo }</td>
		</tr>
		<tr>
			<th>evName</th>
			<td>${evo.evName }</td>
		</tr>
		<tr>
			<th>evType</th>
			<td>${evo.evType }</td>
		</tr>
		<tr>
			<th>evStart</th>
			<td>${evo.evStart }</td>
		</tr>
		<tr>
			<th>evEnd</th>
			<td>${evo.evEnd}</td>
		</tr>
	</table>

	<div id="contentArea">${fn:replace(evo.evContent,'\\','/')}</div>
	<c:if test="${evo.evType eq 'rouletteEv'}">
		<div>
			<canvas width="500" height='500' onclick="clickCanvas(window.event)"></canvas>
			<button onclick="rotate()">룰렛 돌리기</button>
		</div>
	</c:if>
	<a href="/event/eventRemove?evNo=${evo.evNo}"><button type="button">삭제</button></a>
	<a href="/event/eventModify?evNo=${evo.evNo}"><button type="button">수정</button></a>

	<script type="text/javascript"
		src="/resources/js/RouletteEvent.js"></script>

</body>
</html>
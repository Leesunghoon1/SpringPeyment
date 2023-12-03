<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	
	<div id="contentArea">
		${fn:replace(evo.evContent,'\\','/')}
	</div>
	<a href="/event/eventRemove?evNo=${evo.evNo}"><button type="button">삭제</button></a>
	<a href="/event/eventModify?evNo=${evo.evNo}"><button type="button">수정</button></a>
	

</body>
</html>
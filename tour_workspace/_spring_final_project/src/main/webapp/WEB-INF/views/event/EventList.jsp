<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>evNO</th>
				<th>eName</th>
				<th>evType</th>
				<th>eStart</th>
				<th>eEnd</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="evo">
				<tr>
					<td> <a href="/event/eventDetail?evNo=${evo.evNo}">${evo.evNo}</a> </td>
					<td>${evo.evName}</td>
					<td>${evo.evType}</td>
					<td>${evo.evStart}</td>
					<td>${evo.evEnd}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/event/eventRegister"><button type="button">이벤트 추가</button></a>
</body>
</html>
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
	<table style="text-align: center;">
		<thead>
			<tr>
				<th>rvNo</th>
				<th>title</th>
				<th>userNo</th>
				<th>regAt</th>
				<th>readCount</th>
				<th>cmtCount</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="rvo">
				<tr>
					<td><a href="/review/reviewDetail?rvNo=${rvo.rvNo}">${rvo.rvNo}</a>
					</td>
					<td>${rvo.title}</td>
					<td>${rvo.userNo}</td>
					<td>${rvo.regAt}</td>
					<td>${rvo.readCount}</td>
					<td>${rvo.cmtCount}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
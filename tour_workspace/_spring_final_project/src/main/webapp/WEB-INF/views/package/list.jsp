<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>



<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="table" class="table table-dark table-hover">
		<tr>
			<th>#</th>
			<th>상품명</th>
			<th>상품가격</th>
		</tr>
		<c:forEach items="${list}" var="order">
			<tr data-bno="${order.pkNo}">
				<td>
				<a id="${order.pkNo}" href="/package/detail?pkNo=${order.pkNo}">${order.pkNo}</a>
				</td>
				<td>${order.pkName}</td>
				<td>${order.pkPrice}</td>
				
			</tr>
		</c:forEach>
	</table>



</html>
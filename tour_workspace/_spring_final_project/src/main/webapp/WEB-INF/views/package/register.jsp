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

	<form action="/package/register" method="post">

		<div>
			<span>패키지 이름</span> <input type="text" class="form-control"
				name="pkName" aria-label="Username" aria-describedby="basic-addon1">
		</div>

		<div>
			<span>가격</span> <input type="text" name="pkPrice">
		</div>
		
		<button type="submit" id="button">등록</button>
	</form>



</body>
</html>
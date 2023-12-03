<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
		
			<form action="/user/login" method="post">
				<div class="inner-container login-container">
					<div>
						<h1>로그인</h1>
					</div>
					<div>
						<div class="title">아이디</div>
						<div class="input-box"><input type="text" name="id" placeholder="아이디를 입력하세요."></div>
					</div>
					<div>
						<div class="title">비밀번호</div>
						<div class="input-box"><input type="password" id="pwd" name="pwd" placeholder="비밀번호를 입력하세요."></div>
					</div>
					<div class="button-box">
						<span><a href="/"><button type="button">취소</button></a></span>
						<span><button type="submit" class="login-btn">확인</button></span>
					</div>
				</div>
			</form>
			
			
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>
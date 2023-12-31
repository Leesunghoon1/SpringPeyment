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
		
			<form action="/user/login" method="post" onsubmit="return validation()">
				<div class="login-container">
					<div class="page-title">
						<h1>로그인</h1>
					</div>
					<a id="loginLink"></a>
					<div>
						<div class="title">아이디</div>
						<div class="input-box"><input type="text" id="id" name="id" placeholder="아이디를 입력하세요."></div>
					</div>
					<div>
						<div class="title">비밀번호</div>
						<div class="input-box"><input type="password" id="pwd" name="pwd" placeholder="비밀번호를 입력하세요."></div>
					</div>
					<div class="button-box">
						<span id="login-span"><button type="submit" id="login-btn">로그인</button></span>
					</div>
					<div class="sns-login">
						<div id="kakaoLogin">
							<img src="/resources/image/main-logo/kakao_logo/kakao_login.png">
						</div>
						<div id="naverLogin">
							<span><img src="/resources/image/main-logo/naver_logo/naver_login.png"></span>
							<span>네이버 로그인</span>
						</div>
						<div id="googleLogin">
							<span><img src="/resources/image/main-logo/google_logo/google_login.png"></span>
							<span>구글 로그인</span>
						</div>
					</div>
				</div>
			</form>
			<div class="loginFail-background">
				<div class="loginFail-modal">
					<span class="material-symbols-outlined" id="confirm-btn">close</span>
					<span class="modal-text"></span>
					<span><button type="button" id="confirm-btn">확인</button></span>
				</div>
			</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="/resources/js/user/oauth.js"></script>
<script type="text/javascript">
	let loginFail = `<c:out value="${loginFail}" />`;
</script>
<script type="text/javascript" src="/resources/js/user/login.js"></script>
</html>
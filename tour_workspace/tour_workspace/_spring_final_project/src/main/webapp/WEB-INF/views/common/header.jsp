<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square-neo.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
<link href="/resources/css/common.css" rel="stylesheet">
<link href="/resources/css/input.css" rel="stylesheet">
<link href="/resources/css/user/user.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

	<div class="all-container">
      
      
      	<!-- 네비바 영역 -->
		<header class="header-container">
         
			<!-- 메인로고 -->
			<div class="main-logo">
				<a href="/user/index">
					<img alt="" src="/resources/image/main-logo/landmark-logo2.png">
				</a>
			</div>
         
			<div class="nav-menu">
		   		<!-- 여행 메뉴 -->
				<dl class="drop-menu">
					<dd><a href="#">패키지여행</a>
						<dl class="sub-menu">
							<dd><a href="/product/list/?pkContinent=동북아">동북아</a></dd>
							<dd><a href="/product/list/?pkContinent=동남아">동남아</a></dd>
							<dd><a href="/product/list/?pkContinent=유럽">유럽</a></dd>
							<dd><a href="/product/list/?pkContinent=아메리카">아메리카</a></dd>
						</dl>
					</dd>
					<dd><a href="#">테마여행</a>
						<dl class="sub-menu">
							<dd><a href="#">휴양지</a></dd>
							<dd><a href="#">아름다운도시</a></dd>
							<dd><a href="#">신나는여행지</a></dd>
						</dl>
					</dd>
					<dd><a href="#">항공</a>
						<dl class="sub-menu">
							<dd><a href="/freetour/air">항공 바로가기</a></dd>
							<dd><a href="#">예매</a></dd>
							<dd><a href="#">예매</a></dd>
							<dd><a href="#">예매</a></dd>
							<dd><a href="#">예매</a></dd>
							<dd><a href="#">예매</a></dd>
							<dd><a href="#">예매</a></dd>
						</dl>
					</dd>
				</dl>
				<!-- 이벤트 메뉴 -->
				<dl class="event-menu">
					<dd><span>|</span></dd>
					<dd><a href="/event/eventList">이벤트</a></dd>
					<dd><a href="/review/reviewList">리뷰</a></dd>
					<dd><a href="/peyment/TestCSS">할인/혜택</a></dd>
				</dl>
			</div>

      
			<!-- 회원 메뉴 -->
			<div class="nav-user-menu">
				<dl>
					<dd><a href="/user/list?pageNo=1">회원목록</a></dd>
					<dd><a href="/product/register">상품등록</a></dd>
					<dd><a href="/user/login">로그인</a></dd>
					<dd><a href="/user/join">회원가입</a></dd>
					<dd><a href="/user/modify">회원정보</a></dd>
					<dd><a href="/peyment/OrderList?pageNo=1">예약확인</a></dd>
					<dd><a href="/user/logout">로그아웃</a></dd>
					<dd><span><i class="fa-solid fa-magnifying-glass"></i></span></dd>
				</dl>
			</div>
         
		</header>	
         
      
   
</body>
<script type="text/javascript" src="/resources/js/dropMenu.js"></script>
</html>
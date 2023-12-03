<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	
	<!-- 메인 역역 -->
	<div class="main-container">
		
		<!-- 메인 슬라이더 -->
		<div class="slider-wraper">
			
			<div id="slider" class="slider">
				<div class="items slider-item1"></div>
				<div class="items slider-item2"></div>
				<div class="items slider-item3"></div>
				<div class="items slider-item4"></div>
				<div class="items slider-item5"></div>
				<div class="items slider-item6"></div>
			</div>
			
			<div class="arrow left-arrow">
				Prev
				<i class="fa-solid fa-chevron-left"></i>
			</div>
			<div class="arrow right-arrow">
				Next
				<i class="fa-solid fa-chevron-right"></i>
			</div>
		</div>
		
	</div>
	
	
	
	<c:if test="${uvo ne null}">
		<div class="user-info">
			<div>${uvo.id}님</div>
			<div>반갑습니다.</div>
			<div><span>회원등급</span>${uvo.grade}</div>
			<div><span>적립포인트</span>${uvo.point}</div>
		</div>
	</c:if>
	
	
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
		
</body>
<script type="text/javascript" src="/resources/js/slider.js"></script>
<script type="text/javascript">
	let msg = `<c:out value="${message}" />`;
	if(msg == "1"){
		alert("LANDMARK 회원가입이 완료되었습니다.");
	}
	slider('slider');
</script>
</html>
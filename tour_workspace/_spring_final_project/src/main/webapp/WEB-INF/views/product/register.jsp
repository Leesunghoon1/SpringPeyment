<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/product_register.css" rel="stylesheet">

</head>
<body>

<!-- 가격 , 지역 , 나라 , 축제 , 항공 , 호텔   -->
	<div class="product-container">
		<div class="product-register-form">
			<form action="/product/register" method="post" enctype="multipart/form-data">
				<div>
					<h2>상품명</h2>
					<input type="text" name="pdTitle">
					<!-- 패키지 네임 -->
				</div>
				<hr>
				
				<div>
					<h2>상품내용</h2>
					<textarea rows="3" name="pdContents"></textarea>
					<!-- 패키지 타이틀 -->
				</div>
				<hr>
				
				<div class="div-date">
					<h2>항공</h2>	
					비행기 가격 : <input type="text" name="apPrice"> <br>
					출발일 : <input type="datetime-local" name="apArrival"><br>
					도착일 : <input type="datetime-local" name="apDeparture"> 
					<!-- 비행기 출발일 / 도착일  -->
				</div>
				
				<hr>
				
				<div>
					<h2>나라</h2> 
					<input type="text" name="plCountry">
					<h2>지역</h2>
					<input type="text" name="plName">
					<h2>축제</h2>
					<input type="text" name="fvName">
					<h2>참여비</h2>
					<input type="text" name="fvPrice">	
				</div>
				
				<hr>
				
				<div>
					<h2>호텔</h2>
					<input type="text" name="htName">
					<h2>비용</h2>
					<input type="text" name="htPrice">원
				</div>
												
				<hr>
								
				<div>
					<h2>이미지</h2>
					<div class="imgZone" id="imgZone">
						
					</div>
					
					<br>
					
					<div>
						<input type="file" name="files" id="files" style="display:none" multiple="multiple">					
						<button type="button" id="trigger" class="imgBtn">이미지</button>
						
					</div>
					
				</div>
				
				<hr>				
				<br>					
				<button type="submit" id="regBtn" class="regBtn">상품 등록</button>
			</form>
		
		</div>
	</div>
	
<script type="text/javascript" src="/resources/js/triggerFile.js"></script>


</body>
</html>
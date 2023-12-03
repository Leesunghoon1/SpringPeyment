<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/product_list.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>
	 
	 <a href="/">홈</a>
	 
	<div class="product-container">
		<div class="sub-container">
	
			<div>
			<!-- 서치라인 -->
				<div class="place-h2">
					<h2>
						<a href="#" class="placeAll" id="placeAll">
						지역보기
						<span class="material-symbols-outlined" id="arrow"></span>
						<!-- 업 <span class="material-symbols-outlined">expand_less</span> -->
						<!-- 다운 <span class="material-symbols-outlined">expand_more</span> -->
						</a>
					</h2>
				</div>
			</div>
			
			<div style="display:none" class="placeDiv" id="placeDiv">
				<div id="chcekBox" class="chcekBox">
					<ul class="country">
						<c:forEach items="${plvo }" var="plvo">
							<li>
								<a href="#">
									${plvo.plCountry }
								</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			
			
			
			
			
			
			<!-- 리스트  -->
			<div class="list-container">
				<c:forEach items="${pdto.packList }" var="packList">
				
					<div class="itemBox">
						<a href="/product/detail?pkNo=${packList.pkNo }" style="display:block">
							<input type="hidden" value="${packList.pkNo }" name="pkNo"> 
							<!-- 사진이 여러개면 옆으로 넘길수 있게  -->
							<div class="imgBox">
								<div class="imgZone" id="imgZone${packList.pkNo}"></div>
							</div>	
										
							<div class="textBox" id="textZone">
								<div class="textDiv">
										상품명 : ${packList.pkName } <br>
										가격 : ${packList.pkPrice }
								</div>
								<input type="hidden" id="textNumber" value="${packList.pkNo }">
							</div>
						</a>
					</div>			
				</c:forEach>
			</div>
		
		</div>
	</div>

<script type="text/javascript" src="/resources/js/product_list.js"></script>
<script type="text/javascript">
	arrowUpDown();
</script>
<script type="text/javascript">
	getImageList();
</script>
</body>
</html>
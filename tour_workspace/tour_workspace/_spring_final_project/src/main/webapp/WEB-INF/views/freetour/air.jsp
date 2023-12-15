<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/freetour/freetour-air.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<!-- 필요한거 출발일 / 도착일 / 왕복,편도  -->
	<div class="air-all-container">
		<div class="air-reservation-div"> <!--  배경   -->
			<div class="air-reservation-info"> <!-- 위치 가운데로잡는 div -->
				<div class="air-info">
				
					<div class="air-tranport">
						<div class="air-operation-info">
							<a href="#" role="button" id="roundTrip" class="trip-operation">왕복</a>
							<a href="#" role="button" id="oneWay" class="trip-operation">편도</a>
							<a href="#" role="button" id="multipleSections" class="trip-operation">다구간</a>
						</div>
						<div>
							<span>
								<input type="checkbox"><label>직항만</label>
							</span>
							<span>
								<input type="checkbox"><label>무료 수하물</label>
							</span>
						</div>
					</div>
					
					<div>
						<ul class="travel-info">
							<li>
								<input type="text" value="인천/김포"> <!-- 출발지 -->
							</li>
							<li>
								<i class="fa-solid fa-repeat"></i>
							</li>
							<li>
								<input type="text" value="도착지"> <!-- 도착지 -->
							</li>
							<li>
								<!-- 출발일자 / 도착일자 -->
								<a href="#">달력나오게 만들기</a>
							</li>
						</ul>
						<div class="travel-peple-count">
							<div>
								<span class="trip-peple-count">여행인원</span>
								<div class="peple-count">
									성인1 ,일반석
								</div>
							</div>
							
							<a href="#">
								<!-- 검색버튼 누르면 검색페이지 넘어가게.  -->
								<span class="search-btn">검색</span>
							</a>
						</div>
					</div>
					<div>
						<div class="image-div">
							
						</div>
					</div>
				</div>

			</div>
		</div>
		
		<div> <!-- 항공권 -->
			<div>
				<div class="world-map">
					<strong>전 세계 항공권을 한눈에 <br> 확인하고 예약하세요</strong>
					<ul>
					
					</ul>
				</div>
			</div>
		</div>
		
		<div> <!-- 테마 여행지 -->
		
		</div>
		
	</div>
	
	
	
	<!-- 달력 -->
	
	<div>
		<div>
			<div> <!-- 이번달 -->
				<table>
					<tr>
						<th>일</th>
						<th>월</th>
						<th>화</th>
						<th>수</th>
						<th>목</th>
						<th>금</th>
						<th>토</th>			
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						
					</tr>
				</table>
			</div> 
			<div> <!-- 다음달 -->
			
			</div> 
		</div>
	</div>
	
	
	
	
	
	
	
	
	
	
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	
	
<script type="text/javascript" src="/resources/js/freetour/freetour-air.js"></script>
<script type="text/javascript">
randomImage();
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/product_detail.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<style>
	
</style>

</head>
<body>
	<div class="product-container">
		<div class="inner-container">	
		
			<div class="product-title">${pbvo.pdTitle }</div>
			
			<div class="main-section">
			
				<div class="sub-container">
					<!-- 상품명 / 아이콘(공유 메일 프린트) -->
					<div class="top-content">
						<!-- 상품명 -->
						<div>
						</div>
						
					</div>
					
					<!-- 사진 리스트 -->
					<c:forEach items="${pfvo }" var="flist">
						<img alt="그림없음" src="/product_upload/${fn: replace(flist.pfSaveDir,'\\','/')}/${flist.pfUuid }_${flist.pfName}">
					</c:forEach>
					
					<div>
						<div>
							<div>
								<a href="#" id="managerInfoA">담당자 정보 <span class="material-symbols-outlined" id="managerInfoSpan">error</span></a>	
								<!-- 여행 후기 갯수 늘어나게 만들기 클릭하면 리뷰창으로 이동 -->
								<!-- 여행후기 갯수  -->
								<a href="#" class="tourreview">여행후기 <span>0</span></a>
							</div>
							
						</div>
					</div>
					
					<!-- 상품가격 -->
					<table class="product-table">
						<tr class="product-table-tr1">		
							<th>상품가격</th>
							<th>한국출발</th>
							<th>한국도착</th>
						</tr>
						<tr>
							<td><span class="apprice"><fmt:formatNumber value="${packvo.pkPrice}" pattern="#,###"/></span>  원 <br><p>유류할증료 포함<br>제세공과금 포함</p></td>
							<td>${avo.apArrival } <br><p>유류할증료 포함<br>제세공과금 포함</p></td>
							<td>${avo.apDeparture } <br><p>유류할증료 포함<br>제세공과금 포함</p></td>
						</tr>	
					</table>
					<!-- 버튼그룹 -->
					<div class="button-grop">
						<button id="evtBtn1" class="evtBtn">상품핵심포인트</button>
						<button id="evtBtn2" class="evtBtn">수하물안내</button>
						<button id="evtBtn3" class="evtBtn">예약안내사항</button>
						<button id="evtBtn4" class="evtBtn">약관정보</button>
						<button id="evtBtn5" class="evtBtn">해외안전정보</button>
					</div>
					<!-- 밑에 바뀌는 div -->
					<div id="product-eventTap" class="product-eventTap">
						<div class="product-point">
							<strong >상품 핵심포인트</strong>
						</div>	
						<div class="item-div">
							<div class="icon-div">
								<span class="material-symbols-outlined">more_horiz</span>
								<span class="icon-text">기타</span>
							</div>
							<div class="item-info">
								<p>공항픽업서비스 : 전용차량 픽업 서비스</p>
								<p>전문가이드투어 : 한국인 전문 가이드투어</p>
								<p>참고사항 : 실시간 항공, 호텔 예약상품으로 상품에 포함된 기본 운임 마감시, 상품가 변동될 수 있습니다.</p>
							</div>
						</div>
						<div class="item-div">
							<div class="icon-div">
								<span class="material-symbols-outlined">verified_user</span>
								<span class="icon-text">여행자보험</span>
							</div>
							<div class="item-info">
								<p>해외 여행자보험(최대1억원/DB손해보험)</p>
								<a href="#">보장내용 및 금액 상세보기</a>
							</div>
						</div>
					</div>
			
				</div><!-- 서브종료  -->
						
				<div class="option-detail">
					<div class="option-price-div">				
						<div class="option-price-text">가격</div>
						
						<div class="option-price-info">
							<strong class="option-price-strong"><fmt:formatNumber value="${packvo.pkPrice}" pattern="#,###"/></strong>
							<span class="option-price-span">원</span>
						</div>
						
						<div class="option-price-button">
							<button type="button" id="minus" class="option-button">-</button>
							<input type="text" value="1" id="pepleCnt" readonly="readonly">
							<button type="button" id="plus" class="option-button">+</button>
						</div>	
						
					</div>
					<form action="/product/reservation" method="post">
						<div class="option-final-price">
							<!-- 최종금액 -->
							<strong class="option-price-text">최종 합계금액</strong>
							<strong id="finalPrice"><fmt:formatNumber value="${packvo.pkPrice}" pattern="#,###" /></strong>
							<span>원</span>
							<input type="hidden" value="${packvo.pkPrice }" id="hiddenPrice">
						</div>
						<div>
							<button type="button" class="option-submit-button">예약하기</button>
						</div>
					</form>
					<div>
						<span>예상 포인트 적립금액</span>
						<!-- 마일리지  -->
						<span>???</span>
					</div>
				</div> <!-- 옵션 -->
			
			</div>
		</div>
	</div> <!-- all -->

<script type="text/javascript" src="/resources/js/product_detail.js"></script>
<script type="text/javascript">
	let country = `<c:out value="${plvo.plCountry}"/>`;
	console.log(country);
</script>
</body>
</html>
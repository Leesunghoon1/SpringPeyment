<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<html>


<head>
<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Cormorant+Garamond:wght@500&display=swap"
	rel="stylesheet">


<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<title>Home</title>
</head>
<link rel="stylesheet" href="/resources/css/user-number.css?var=2">

<body>

	<div class="payment-container-main">
		<div class="bg-video">
			<video class="bg-video__content" autoplay muted loop>
				<source src="/resources/image/pierrr.mp4" type="video/mp4">
				<source src="img/video.webm" type="video/webm" />
			</video>
		</div>
		<div class="payment-box-left">
			<!-- 왼쪽 div  -->




			<div>
				<div class="user-number">

					<div class="user-number-box">
						<h3 id="user-nmuber-top">이성훈님의 회원정보</h3>
					</div>
					<div class="form-group"></div>
					<div class="form-group-two">
						<span for="phon">아이디</span><br> <strong>${uvo.id}</strong> <br><br>
						<span for="phon">전화번호</span><br> <strong>${uvo.phoneNumber}</strong><br>
						<br> <span>*개인 정보 보호를 위해 개인정보는 안심번호로 landmark에 전송됩니다.</span> <br>
						<br> <span for="adrass">주소</span><br> <strong>${uvo.address}</strong><br>
						<br> <span for="email">이메일</span><br> <strong>${uvo.email}</strong><br>
						<br> <span for="phon">맴버쉽</span><br> <strong>${uvo.grade}</strong><br>
						<br> <br>
					</div>


				</div>

				<!--할인 쿠폰  -->

				<div class="event-box">
					<div class="user-event-box">
						<h3 class="user-nmuber-top">할인 수단 선택</h3>
					</div>
					<div class="product-amout">
						<span>구매 금액</span> <b>${pkvo.pkPrice}</b>
					</div>

					<div class="form-group-cupon-mid">
						<input type="text" id="coupon-input"
							placeholder="Enter Coupon Code"> <br>
						<button type="button" class="cupon-button" onclick="applyCoupon()">사용
							가능 쿠폰</button>


					</div>
					<div class="product-amout">
						<span> 일반쿠폰 </span> <span id="discounted-coupon-value"> %</span>
					</div>

					<div class="product-amout">
						<span> 추가쿠폰 </span> <span> - </span>
					</div>
					<div class="product-amout">
						<span> 맴버쉽 할인</span> <span> - </span>
					</div>
					<div class="product-amout">
						<span> 최종할인</span> <span> - </span>
					</div>
					<div class="product-amout">
						<span> 최종금액</span> <span id="discounted-price-value">${pkvo.pkPrice}</span>
					</div>

					<div class="box-left">
						<div class="box">
							<div class="selectBox">
								<button class="label">결제수단 선택</button>
								<ul class="optionList" id="paymentMethod">
									<li class="optionItem" value="kakaopay" data-v-16d1a795>카카오페이</li>
									<li class="optionItem" value="tosspay">토스</li>
									<li class="optionItem" value="html5_inicis">KG이니시스</li>
									<li class="optionItem" value="payco">페이코</li>
									<li class="optionItem" value="settle">핵토파이낸셜</li>
									<li class="optionItem" value="daou">키움페이</li>
								</ul>

							</div>

						</div>
						<button class="btn-gradient cyan" type="button"
							onclick="requestPay()">
							<span>결제하기</span>
						</button>
					</div>


				</div>



			</div>




			<div class="form-group-bottom"></div>
			<!--  로그인 하면 안보이게 만들어주기~ -->

			<div class="form-group-rogin">
				<a> "로그인 후 예약하시면" <br> "할인 쿠폰과 추가 이벤트 를 사용하실수 있습니다~!" <br>
					<span>로그인 ></span>
				</a>
			</div>
		</div>
		<div class="payment-box-right">

			<div class="payment-box-right-main">
				<!-- 버튼그룹 -->

				<!-- 상품가격 -->
				<div class="price-box">
					<table class="product-table">
						<tr class="product-table-tr1">
							<th>여행장소</th>
							<th>상품가격</th>
							<th>한국출발</th>
							<th>한국도착</th>
						</tr>
						<tr>
							<td><span class="apprice"> ${pkvo.pkName}</span> <br></td>





							<td><span class="apprice"> <span
									id="discounted-price-value2">${pkvo.pkPrice}</span>
							</span> 원 ${avo.apDeparture }<br></td>


							<td>${avo.apArrival }<br>
							</td>

						</tr>

					</table>
					<br> <br>
				</div>

				<div class="button-grop">
					<button id="evtBtn1" class="evtBtn">상품핵심포인트</button>
					<button id="evtBtn2" class="evtBtn">수하물안내</button>
					<button id="evtBtn3" class="evtBtn">예약안내사항</button>
					<button id="evtBtn4" class="evtBtn">약관정보</button>
					<button id="evtBtn5" class="evtBtn">해외안전정보</button>
				</div>
				<br> <br>
				<!-- 밑에 바뀌는 div -->
				<div id="product-eventTap" class="product-eventTap">
					<div class="product-point">
						<strong>상품 핵심포인트</strong> <br>
					</div>
					<div class="item-div">
						<div class="icon-div">
							<span class="material-symbols-outlined">more_horiz</span> <span
								class="icon-text">기타</span>
						</div>
						<div class="item-info">
							<p>공항픽업서비스 : 전용차량 픽업 서비스</p>
							<p>전문가이드투어 : 한국인 전문 가이드투어</p>
							<p>참고사항 : 실시간 항공, 호텔 예약상품으로 상품에 포함된 기본 운임 마감시, 상품가 변동될 수
								있습니다.</p>
						</div>
					</div>
					<div class="item-div">
						<div class="icon-div">
							<span class="material-symbols-outlined">verified_user</span> <span
								class="icon-text">여행자보험</span>
						</div>
						<div class="item-info">
							<p>해외 여행자보험(최대1억원/DB손해보험)</p>
							<a href="#">보장내용 및 금액 상세보기</a>
						</div>
						<br>
						<div>
							<div id="product-eventTap" class="product-eventTap">
								<div class="product-point">
									<strong>참고사항</strong>
								</div>
								<div class="item-div">
									<div class="item-info">
										<p>주)LandMark 010-7441-5488 (담당자: 이성훈)</p>
										<p>- 문의사항은 담당자를 통해 확인하시기 바랍니다.</p>
										<p>- 취소규정은 주말, 공휴일을 제외한 영업일수로 계산됩니다.</p>
										<p>- 취소는 정규업무 시간내에만 가능합니다. (정규업무 시간외 취소시 익일 규정 적용됩니다.)</p>
										<p>- 업무시간 월~금 09:00~18:00 (법정공휴일 제외)</p>
										<p>- 예약시점에 따라 원가인상(항공, 호텔)으로 인해 상품가격이 변경될 수 있으며, 예약시 상품가격이
											적용됩니다.</p>
										<p>- 유류할증료는 유가와 환율에 따라 수시로 요금이 변동될 수 있습니다.</p>

									</div>



								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
		<!-- 예약자 정보 -->

	</div>
</body>


<script type="text/javascript">
	let pkVo = `<c:out value="${pkvo}" />`;

</script>
<script type="text/javascript">
	let uvo = `<c:out value="${uvo}" />`;
</script>
<script type="text/javascript" src="/resources/js/userPayment.js"></script>
</html>

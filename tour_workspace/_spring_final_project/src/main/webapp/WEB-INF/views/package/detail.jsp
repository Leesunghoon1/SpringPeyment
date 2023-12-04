<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<!-- SweetAlert2 CSS -->

<title>Home</title>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<!-- SweetAlert2 JS -->
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.all.min.js"></script>
</head>
<link rel="stylesheet" href="/resources/css/user-number.css">

<body>
	<div class="payment-container-main">


		<div class="payment-box-left">
			<!-- 왼쪽 div  -->



			<!-- 예약자 정보 -->

			<div class="user-number">
				<div class="user-number-box">
					<h3 id="user-nmuber-top">상품 정보</h3>
				</div>
				<div class="form-group">
					<span>${pkvo.pkName}</span>
				</div>

				<div class="form-group-two">
					<label for="phon">전화번호</label> <span>개인 정보 보호를 위해 안심번호로
						landmark에 전송됩니다.</span> <input type="text" id="expiry-date"
						name="expiry-date" placeholder="핸드폰 번호" required>
					<button type="button" class="phon-button">인증번호 전송</button>
				</div>

				<div class="form-group-bottom">
					<label for="bbs">이동 수단</label>
					<button type="button" class="user-walk">
						<span>도보</span>
					</button>
					<button type="button" class="user-car">
						<span>차량</span>
					</button>
				</div>
				<!--  로그인 하면 안보이게 만들어주기~ -->
				<div class="form-group-rogin">
					<a> "로그인 후 예약하시면" <br> "할인 쿠폰과 추가 이벤트 를 사용하실수 있습니다~!" <br>
						<span>로그인 ></span>
					</a>
				</div>

			</div>

			<!--할인 쿠폰  -->

			<div class="event-box">
				<div class="user-event-box">
					<h3 class="user-nmuber-top">할인 수단 선택</h3>
				</div>
				<div class="product-amout">
					<span>구매 총액</span> <b>${pkvo.pkPrice}</b>
				</div>

				<div class="form-group-cupon-mid">
					<button type="button" class="cupon-button">사용 가능 쿠폰</button>


				</div>
				<div class="product-amout">
					<span> 일반쿠폰 </span> <span> - </span>
				</div>

				<div class="product-amout">
					<span> 추가쿠폰 </span> <span> - </span>
				</div>

			</div>

			<div class="cash-box">
				<section class="user-event-box">
					<h3 class="user-nmuber-top">결제수단 선택</h3>
					<c:set value="${ph.pgvo.type}" var="typed" />
					<select id="paymentMethod">
						<option data-minprice="0" selected="selected" value="kakaopay"
							data-v-16d1a795>카카오페이</option>
						<option data-minprice="0" value="tosspay"}>토스</option>
						<option data-minprice="0" value="html5_inicis"}>KG이니시스</option>
						<option data-minprice="0" value="payco">페이코</option>
						<option data-minprice="0" value="daou"}>키움페이</option>
						<option data-minprice="0" value="settle"}>핵토파이낸셜</option>
					</select>
				</section>
				<button type="button" onclick="requestPay()">결제하기</button>


				<button onclick="cancelPay()">환불하기</button>
				<!-- jQuery CDN --->

			</div>

		</div>



	</div>
</body>
<script type="text/javascript">
	let pkVo = `<c:out value="${pkvo}" />`;
</script>
<script type="text/javascript" src="/resources/js/userPayment.js"></script>
</html>

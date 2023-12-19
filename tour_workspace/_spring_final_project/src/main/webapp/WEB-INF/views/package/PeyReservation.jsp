<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<title>랜드마크</title>

<link rel="stylesheet" href="/resources/css/peyment/PeyReservation.css"
	type="text/css">

<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<style>
body, h1, h2, h3, h4, h5, h6, p, span {
	font-family: 'Noto Sans KR', sans-serif !important;
}
</style>

</head>
<body>
	<div class="main-container">
		<div class="main-top-top">
			<h2>스케줄</h2>
			<p>
				<span>비행상세</span>
			</p>
		</div>
		<div class="main-top-mid">
			<div class="main-top-mid-content2">
				<p class="plan">인천 ICN</p>
				<span class="mid-content-icon"> </span>
				<p class="plan">도쿄 NRT</p>
			</div>
		</div>
		<table class="main-top-bottom">
			<colgroup>
				<col style="width: 29%">
				<col style="width: *">
				<col style="width: 15.5%">
				<col style="width: 13.8%">
			</colgroup>
			<thead>
				<tr>
					<th scope="col">항공편</th>
					<th scope="col">여정</th>
					<th scope="col">좌석등급</th>
					<th scope="col">무료수하물</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<div class="td-top">
							<img
								src="https://air.kyowontour.com/air/wfw/imgs/mbl/logo/air/KE.png"
								alt="KE" class="k1-air-logo">
							<div class="tit-box">
								<p>대한항공 705편</p>
							</div>
						</div>
					</td>
					<td>
						<div class="txt_area">
							<div class="k1-kwk-itinerary_box">
								<div class="tit-box">
									<p>인천 ICN</p>
									<p>시간~</p>
								</div>
								<span class="k1-kwk-ico-arr"><img
									src="https://air.kyowontour.com/air/imgs_ibe/b2c/24_Oneway_arr_ico@2x.png"></span>
								<div class="tit-box">
									<p>인천 ICN</p>
									<p>시간~</p>
								</div>
							</div>
						</div>
					</td>
					<td>
						<div class="txt-area">일반석</div>
					</td>
					<td>
						<div class="txt-area">1개</div>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="mid-detail">
			<div class="mid-txt-area">
				<span>총 소요시간</span>

			</div>
			<div class="mid-txt-area2">
				<ul>
					<li>대기예약시 모든 좌석이 확인되어야만, 항공권 구매가 가능합니다.</li>
				</ul>
			</div>
		</div>
		
			<table class="main-top-bottom">
			<colgroup>
				<col style="width: 29%">
				<col style="width: *">
				<col style="width: 15.5%">
				<col style="width: 13.8%">
			</colgroup>
			<thead>
				<tr>
					<th scope="col">항공편</th>
					<th scope="col">여정</th>
					<th scope="col">좌석등급</th>
					<th scope="col">무료수하물</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<div class="td-top">
							<img
								src="https://air.kyowontour.com/air/wfw/imgs/mbl/logo/air/KE.png"
								alt="KE" class="k1-air-logo">
							<div class="tit-box">
								<p>대한항공 705편</p>
							</div>
						</div>
					</td>
					<td>
						<div class="txt_area">
							<div class="k1-kwk-itinerary_box">
								<div class="tit-box">
									<p>인천 ICN</p>
									<p>시간~</p>
								</div>
								<span class="k1-kwk-ico-arr"><img
									src="https://air.kyowontour.com/air/imgs_ibe/b2c/24_Oneway_arr_ico@2x.png"></span>
								<div class="tit-box">
									<p>인천 ICN</p>
									<p>시간~</p>
								</div>
							</div>
						</div>
					</td>
					<td>
						<div class="txt-area">일반석</div>
					</td>
					<td>
						<div class="txt-area">1개</div>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="mid-detail">
			<div class="mid-txt-area">
				<span>총 소요시간</span>

			</div>
			<div class="mid-txt-area2">
				<ul>
					<li>대기예약시 모든 좌석이 확인되어야만, 항공권 구매가 가능합니다.</li>
				</ul>
			</div>
		</div>
		<div class="mid-mid">
		<h2 class="mid-mid-top">탑승객 및 상세요금</h2>
		<p>요금 규정</p>
		</div>
		
	</div>
</body>
</html>
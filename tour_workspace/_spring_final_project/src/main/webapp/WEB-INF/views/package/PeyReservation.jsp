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

		<div class="left-content">
			<div class="top-content">
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
			</div>




			<div class="mid-content">
				<div class="mid-mid">
					<h2 class="mid-mid-top">탑승객 및 상세요금</h2>
				</div>
				<table class="main-mid-mid">
					<colgroup>
						<col style="width: 7%">
						<col style="width: 10%">
						<col style="width: 15%">
						<col style="width: 15%">
						<col style="width: 15%">
						<col style="width: 15%">
						<col style="width: 7%">
						<col style="width: *%">
					</colgroup>
					<thead>
						<tr>
							<th>구분</th>
							<th>운임조건</th>
							<th>항공요금</th>
							<th>제세공과금</th>
							<th>유류할증료</th>
							<th>발권수수료</th>
							<th>인원</th>
							<th>합계</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><span>성인</span></td>
							<td><span>성인</span></td>
							<td><span>1996원</span></td>
							<td><span>1157원</span></td>
							<td><span>598498원</span></td>
							<td><span>5454원</span></td>
							<td><span>9984원</span></td>
							<td><span>6999999원</span></td>
						</tr>
					</tbody>
				</table>


				<div class="mid-mid">
					<h2 class="mid-mid-top">예약자 정보</h2>
				</div>
				<table class="main-mid-mid">
					<colgroup>
						<col style="width: 33%">
						<col style="width: 33%">
						<col style="width: *%">
					</colgroup>
					<thead>
						<tr>
							<th>성명</th>
							<th>휴대폰</th>
							<th>이메일</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><span>이성훈</span></td>
							<td><span>010-7441-5488</span></td>
							<td><span>fecd119@naver.com</span></td>
						</tr>
					</tbody>
				</table>
				<div class="pay-box">
					<ul>
						<li>가입된 이메일 주소와 연락처로 예약관련 이메일과 SMS가 발송됩니다.</li>
						<li>부정확한 정보입력으로 인하여 연락이 불가능할 경우 발생되는 불이익에 대해 당사는 책임지지 않으니 이 점
							유의하시기 바랍니다.</li>
					</ul>
				</div>
			</div>



			<div class="bottom-content">

				<div class="mid-mid-user">
					<h2 class="mid-mid-user">탑승객</h2>

				</div>

				<div class="pay-box">
					<ul>
						<li>영문 성/영문 이름/생년월일은 여권과 동일한 정보를 입력해주세요. (특수문자 및 공백 불가)</li>
						<li>소아는 출발일 기준 만 2세 이상~만12세미만, 유아는 만2세 미만입니다.</li>
						<li>도착일 기준, 만12세 이상 소아 / 만2세 이상 유아 / 성인을 동반하지 않은 혼자 여행하는 16세
							미만 소아는 추가 요금이 발생하므로 당사로 문의 바랍니다.</li>
					</ul>
				</div>


				<div class="bottom-content-end">
					<h2 class="mid-mid-top">항공권 결제 동의사항</h2>
				</div>

				<div class="k1_kwk_agree">
					<div class="k_agree_tab">
						<ul>
							<li></li>
							<li></li>
							<li></li>
							<li></li>
							<li></li>
							<li></li>
							<li></li>
							<li></li>
							<li></li>
						</ul>
					</div>
				</div>
			</div>


		</div>


		<div></div>






	</div>
</body>
</html>
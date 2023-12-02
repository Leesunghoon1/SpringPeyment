<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<title>랜드마크</title>

<link rel="stylesheet" href="/resources/css/myOrder.css" type="text/css">

<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<style>
body, h1, h2, h3, h4, h5, h6, p, span {
	font-family: 'Noto Sans KR', sans-serif !important;
}
</style>

</head>
<body>

	<section class="checkout-section spad mt-5">
		<div class="container">
			<form class="checkout-form">
				<div class="row">
					<div class="col-lg-12">

						<h3>${payDTO.orderNum }님의전체주문내역</h3>
						<h3>${payDTO.payAmount }전체금액</h3>
						<h3>${payDTO.payMethod }결제방식</h3>
						<h3>${payDTO.payNum }결제번호</h3>

						<div class="point_list_box">

							<div class="container">
								<h1>이성훈님의 결제 정보</h1>
								<table class="rwd-table">
									<tbody>
										<tr>
											<th>결제 시간/결제 번호</th>
											<th>상품 번호</th>
											<th>상품 이름</th>
											<th>상품 출발시간</th>
											<th>상품 도착시간</th>
											<th>상품 최종가격</th>
											<th>주문 취소</th>
										</tr>
										<tr>
											<td data-th="Supplier Code">${payDTO.payNum }</td>
											<td data-th="Supplier Name">${payDTO.orderNum }</td>
											<td data-th="Invoice Number">${payDTO.payName }</td>
											<td data-th="Invoice Date">출발일</td>
											<td data-th="Due Date">도착일</td>
											<td data-th="Net Amount">${payDTO.payAmount }</td>
											<td data-th="Net Amount">
												<button type="button" order-num="${payDTO.orderNum}"
													class="payMentCancel site-btn">주문 취소</button>
											</td>
										</tr>
									</tbody>
								</table>
								<h3>이전 다음</h3>
							</div>
						</div>
					</div>
				</div>
				<!-- 리뷰 페이지 끝 -->

			</form>
		</div>
	</section>
	<script type="text/javascript">
		let pkVo = `<c:out value="${payDTO}" />`;
	</script>

	<script src="/resources/js/myOrder.js">
		
	</script>
</body>
</html>
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

<link rel="stylesheet" href="/resources/css/peyment/myOrder.css"
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

	<c:set value="${pldto.packvo }" var="packvo" />
	<c:set value="${pldto.pfList }" var="pfList" />
	<c:set value="${pldto.avo }" var="avo" />
	<c:set value="${pldto.hvo }" var="hvo" />
	<c:set value="${pldto.fvo }" var="fvo" />
	<c:set value="${pldto.plvo }" var="plvo" />
	

	<div class="main-container">
		<div class="main-header">
			<div class="my-style">
				<span class="tita">${uvo.name }</span>
				<!-- 나중에 여기는 유저 정보로 이동  -->
				<span class="titb">님, 안녕하세요.</span>
				<div class="text-head">
					<p>
						포인트는<span> ${msVo.point }P가 있어요 </span> 등급은 <span><strong>${msVo.grade }</strong>입니다!!</span>
					</p>
					<p>
						<span>${uvo.name }</span>님이 좋아하는 여행 스타일은 어떤걸까요 ?
					</p>
				</div>
<!--   https://cdn-icons-png.flaticon.com/512/7858/7858530.png-->
				<div class="text-bottom"> 
					<div>제가 선택한 여행지는</div>
					<div class="titc">${packvo.pkName} <span> 입니다.</span></div> 
					<h4>#여행정보</h4>
					<div class="travle-info">
						<img src="https://img-kyowontour.kyowontour.com/hp/icon/where.icon3.svg" alt="">
						<span>${packvo.pkContent}</span>
					</div>
				</div>
			</div>
			<div class="my-icon">
				<img src="https://cdn.pixabay.com/photo/2012/04/01/18/01/backpacking-23788_1280.png "
					width="400" height="400">
			</div>
		</div>
		<div class="main-body">
			<div class="main-item">
				<div class="item-head">
					<h2>결제내역</h2>
					<a href="/peyment/OrderList?pageNo=1"><h2>예약내역 리스트 가기</h2></a>
				</div>


				<c:forEach items="${ollList }" var="ollList">
					<div class="item-reserve">
						<div class="item-img">
							<img class="listImg"
								src="/product_upload/${fn:replace(ollList.pfSaveDir,'-','/')}/${ollList.pfUuid}_${ollList.pfName}">
						</div>

						<div class="item-info">
							<div class="no">
								<dl class="nodt">
									<dt>예약번호</dt>
									<dd>${ollList.orderNum }</dd>
								</dl>

								<dl class="nodt">
									<dt>출발일</dt>
									<dd>${ollList.apDeparture }</dd>
								</dl>
								<dl class="nodt">
									<dt>도착일</dt>
									<dd>${ollList.apArrival }</dd>
								</dl>
								<dl class="nodt">
									<dt>여행권</dt>
									<dd>${ollList.pkContinent }</dd>
								</dl>
								<dl class="nodt">
									<dt>여행지</dt>
									<dd>${ollList.pkName }</dd>
								</dl>
								<dl class="nodt">
									<dt>호텔</dt>
									<dd>${ollList.htName }</dd>
								</dl>
								<dl class="nodt">
									<dt>결제금액</dt>
									<dd>${ollList.totalPrice}원</dd>
								</dl>
							</div>
							<div class="item-info-tit">
								<Strong>상품소개</Strong>
								<p>${ollList.pkContent }</p>
							</div>
							<div class="button-class">

								<button type="button" order-num="${ollList.orderNum}"
									class="payMentOk site-btn" id="confirmButton">
									<span>결제 확정</span>
								</button>


								<button type="button" order-num="${ollList.orderNum}"
									class="payMentCancel site-btn" id="cancelButton">
									<span>결제 취소</span>
								</button>


							</div>
						</div>

					</div>
				</c:forEach>
			</div>



		</div>
		<div class="panel-item">
			<div class="tit">
				<h2 class="main-item">항공권 예약 내역</h2>
			</div>
			<div class="banner-box">
				<div class="text-head">
					온라인을 통해 항공권을 예약하신 고객께서는 <img class="aa"
						src="https://www.kyowontour.com/images/emoji/emoji-airplane-departure02.svg"
						alt="" style="width: 70px;"> 마이페이지에서 확인이 가능합니다.
				</div>
				<div>
					<a href="/user/detail"><button type="button"
							class="btn-gradient-bottom">
							<span>마이페이지</span>
						</button></a>
				</div>

			</div>
		</div>

	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	<script type="text/javascript">
		let orderNum = `<c:out value="${orderNum}" />`;
		let id = `<c:out value="${uvo.name }" />`;
		
	</script>

	<script src="/resources/js/peyment/myOrder.js">
		
	</script>
</body>
</html>
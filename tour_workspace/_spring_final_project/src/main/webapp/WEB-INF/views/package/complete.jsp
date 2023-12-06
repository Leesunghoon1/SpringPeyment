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
						포인트는<span>1000P가 있어요 </span> 등급은 <span>gold입니다!!</span>
					</p>
					<p>
						<span>${uvo.name }</span>님이 좋아하는 여행 스타일은 어떤걸까요 ?
					</p>
				</div>
				<div class="text-bottom">
					나는 <span class="current-icon"> <img
						src="https://img-kyowontour.kyowontour.com/hp/icon/who.icon2.svg"
						alt="">친구와 함께
					</span> <span class="current-icon"> <img
						src="https://img-kyowontour.kyowontour.com/hp/icon/where.icon3.svg"
						alt="">일본에서
					</span> <br> <span class="current-icon"> <img
						src=" https://cdn-icons-png.flaticon.com/512/2314/2314620.png "
						width="50" height="50"> 온천을
					</span>즐기고 싶어요.
				</div>
			</div>
			<div class="my-icon">
				<img src="https://cdn-icons-png.flaticon.com/512/7858/7858530.png "
					width="400" height="400">
			</div>
		</div>
		<div class="main-body">
			<div class="main-item">
				<div class="item-head">
					<h2>예약 내역</h2>
					<a>총 1건</a>
				</div>
				<div class="item-reserve">
					<div class="item-img">
						<c:forEach items="${pldto.pfList }" var="pfList">
							<img class="listImg"
								src="/product_upload/${fn:replace(pfList.pfSaveDir,'-','/')}/${pfList.pfUuid}_${pfList.pfName}">
						</c:forEach>
					</div>
					<div class="item-info">
						<div class="no">
							<dl>
								<dt>예약번호</dt>
								<dd>${payDTO.orderNum }</dd>
							</dl>

							<dl>
								<dt>출발일</dt>
								<dd>${avo.apDeparture }</dd>
							</dl>
							<dl>
								<dt>도착일</dt>
								<dd>${avo.apArrival }</dd>
							</dl>
						</div>
						<div>
							<button type="button" order-num="${payDTO.orderNum}"
								class="btn-gradient cyan" class="btn-gradient cyan">
								<span>예약 취소</span>
							</button>
						</div>
						<div class="item-info-tit">
							<strong>${packvo.pkContent }</strong>
						</div>
						<div class="item-info-pey">
							<strong>${payDTO.payAmount }</strong><span>원</span>
						</div>
						<div class="paging">
							<a href="#" class="btn-prev"></a> <a href="#" class="selected">1</a>
							<a href="#" class="btn-next"></a>
						</div>
					</div>
				</div>
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
						alt="" style="width: 70px;"> 나의 항공권에서 확인이 가능합니다. 
						<a><button
							type="button" class="btn-gradient-bottom">
							<span>나의 항공권</span>
						</button></a>

				</div>
			</div>
		</div>
		<script type="text/javascript">
			let pkVo = `<c:out value="${packvo}" />`;
		</script>

		<script src="/resources/js/myOrder.js">
			
		</script>
</body>
</html>
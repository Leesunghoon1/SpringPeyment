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
		<div class="main-body">
			<div class="main-item">
				<div class="item-head">
					<h2>예약내역</h2>
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
						<a class="prev-a" href="/peyment/detail?pkNo=${pkNoVal}&userCount=${userCount}">
							<button type="button" class="payMentCancel site-btn">
								<span>결제 하기</span>
							</button>
						
						</a>
						</div>
						<div class="item-info-tit">
							<strong>${packvo.pkContent }</strong>
						</div>
					</div>
				</div>
			</div>
			<!-- 페이지네이션 영역 ${ph.prev ? '' : 'disabled'} -->
			<div class="paging-container">
				<a class="prev-a" href="/peyment/OrderList?pageNo=${ph.pageStart-1}"><i
					id="${ph.prev eq false ? 'disable' : 'enable'}"
					class="fa-solid fa-circle-chevron-left"></i></a>
				<c:forEach begin="${ph.pageStart}" end="${ph.pageEnd}" var="i">
					<a href="//peyment/OrderList=${i}"><span
						id="${ph.pageNo eq i ? 'selectNo' : ''}">${i}</span></a>
				</c:forEach>
				<a class="next-a" href="//peyment/OrderList=${ph.pageEnd+1}"><i
					id="${ph.next eq false ? 'disable' : 'enable'}"
					class="fa-solid fa-circle-chevron-right"></i></a>
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
						alt="" style="width: 70px;"> 나의 항공권에서 확인이 가능합니다. <a><button
							type="button" class="btn-gradient-bottom">
							<span>나의 항공권</span>
						</button></a>

				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		let pkVo = `<c:out value="${payDTO}" />`;
		let prev = `<c:out value="${ph.prev}" />`;
		let next = `<c:out value="${ph.next}" />`;
	</script>

	<script src="/resources/js/peyment/myOrder.js">
		
	</script>
	<script type="text/javascript" src="/resources/js/pagenation.js">
		
	</script>
</body>
</html>
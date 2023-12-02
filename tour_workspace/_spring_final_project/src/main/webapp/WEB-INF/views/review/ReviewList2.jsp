<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Review</h2>
		<p>소중한 고객님의 후기를 기다립니다.</p>
	</div>
	<!-- 검색라인 -->
	<form action="/review/reviewList" method="get">
		<c:set value="${ph.pgvo.type}" var="typed"></c:set>
		<select name="type" class="search-select">
			<option ${typed eq null ? 'selected':''}>Choose...</option>
			<option value="t" ${typed eq "t" ? 'selected':''}>Title</option>
			<option value="w" ${typed eq "w" ? 'selected':''}>Writer</option>
			<option value="c" ${typed eq "c" ? 'selected':''}>Content</option>
			<option value="tw" ${typed eq "tw" ? 'selected':''}>Title or Writer</option>
			<option value="tc" ${typed eq "tc" ? 'selected':''}>Title or Content</option>
			<option value="cw" ${typed eq "cw" ? 'selected':''}>Content or Writer</option>
			<option value="tcw" ${typed eq "tcw" ? 'selected':''}>all</option>
		
		</select>
		<input type="text" name="keyword" class="search-input" placeholder="검색어를 입력하세요">
		<input type="hidden" value="${ph.pgvo.qty}">
		<input type="hidden" value="1">
		<button type="submit">검색</button>
		<span>${ph.totalCount}</span>
	</form>

	<table style="text-align: center;">
		<thead>
			<tr>
				<th>rvNo</th>
				<th>title</th>
				<th>id</th>
				<th>regAt</th>
				<th>조회수</th>
				<th>댓글갯수</th>
				<th>좋아요 갯수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="rvo">
				<tr>
					<td>${rvo.rvNo}</td>
					<td>
						<c:if test="${fn:contains(rvo.secret, 'y')}">
							<i class="bi bi-file-earmark-lock"></i>
						</c:if>
						<a href="/review/reviewDetail?rvNo=${rvo.rvNo}">${fn:contains(rvo.secret, 'y') ? '비밀글입니다':rvo.title}</a>
					</td>
					<td>${rvo.id}</td>
					<td>${rvo.regAt}</td>
					<td>${rvo.readCount}</td>
					<td>${rvo.cmtCount}</td>
					<td>${rvo.likeCount}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<!-- 페이징 라인 -->
	<c:if test="${ph.prev}">
		<a href="/review/reviewList?pageNo=${ph.startPage-1}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}"><button type="button">prev</button></a>
	</c:if>
	<c:forEach begin="${ph.startPage}" end="${ph.endPage}" var="i">
		<a href="/review/reviewList?pageNo=${i}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">${i}</a>
	</c:forEach>
	<c:if test="${ph.next}">
		<a href="/review/reviewList?pageNo=${ph.endPage+1}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}"><button type="button">next</button></a>
	</c:if>
	
	<br>
	<a href="/review/reviewRegister"><button type="button">글쓰기</button></a>
	<a href="/review/BestReview"><button>BEST 글</button></a>
	<script type="text/javascript">
		let msg=`<c:out value='${msg}'/>`;
		console.log(msg);
		if(msg=="secret")
			alert('비밀글입니다.');
	</script>

</body>
</html>
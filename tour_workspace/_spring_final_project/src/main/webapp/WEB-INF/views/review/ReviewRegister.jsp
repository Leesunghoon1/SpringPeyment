<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/tmpCss.css" rel="stylesheet">

<!-- include libraries(jQuery, bootstrap) -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

</head>
<body>
	<div class="all-container">
		<!-- <hr> -->
		<form action="/review/reviewRegister" method="post">
			<table>
				<tr>
					<th>리뷰 제목</th>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="id" value="${uvo.id}"></td>
				</tr>
				<tr>
					<th>비밀글</th>
					<td><input type="checkbox" name="secret" value="Y"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea id="summernote" name="content"></textarea></td>
				</tr>
			</table>
			<button type="submit">등록</button>
		</form>
	</div>
	<script type="text/javascript" src="/resources/js/summernote.js"></script>
	<script type="text/javascript">
		function uploadImage(file) {
			var formData = new FormData();
			formData.append('file', file);

			$.ajax({
				url : '/review/image',
				method : 'POST',
				data : formData,
				contentType : false,
				processData : false,
				enctype : 'multipart/form-data',
				success : function(url) {
					console.log('Image uploaded successfully. URL:', url);
					var imgTag = '<img src="' + url + '" />';
					$('#summernote').summernote('pasteHTML', imgTag);
				},
				error : function() {
					console.error('Error uploading image');
				}
			});
		}
	</script>
</body>
</html>
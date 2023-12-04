<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/tmpCss.css" rel="stylesheet">
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
	<form action="/review/modify" method="post">
	<table class="table table-hover">
		<tr>
			<th>rvNo</th>
			<td><input type="text" value="${rvo.rvNo}" name="rvNo" readonly="readonly"></td>
		</tr>
		<tr>
			<th>title</th>
			<td><input type="text" value="${rvo.title}" name="title"></td>
		</tr>
		<tr>
			<th>userNo</th>
			<td><input type="text" value="${uvo.id}" name="id" readonly="readonly"></td>
		</tr>
		<tr>
			<th>비밀글</th>
			<td>
			<input type="checkbox" name="secret" id="secret" value="y">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea id="summernote" name="content" >${rvo.content}</textarea></td>
		</tr>
	</table>
	<button type="submit">수정</button>	
	</form>

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
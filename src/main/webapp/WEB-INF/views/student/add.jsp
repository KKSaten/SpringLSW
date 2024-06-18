<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생정보입력 페이지</h1>
	
	<form action="/student/add" method="post">
	
		<div>
			<label for="name">이름</label>
			<input type="text" name="name">
		</div>
		<div>
			<label for="kor">국어</label>
			<input type="text" name="kor">
		</div>
		<div>
			<label for="eng">영어</label>
			<input type="text" name="eng">
		</div>
		<div>
			<label for="math">수학</label>
			<input type="text" name="math">
		</div>
		<div>
			<label for="total">총합</label>
			<input type="text" name="total">
		</div>
		<div>
			<label for="avg">평균</label>
			<input type="text" name="avg">
		</div>

		
		
		<input type="submit" value="등록">
		
		
	</form>

</body>
</html>
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
			<input type="text" id="name" name="name">
		</div>
		<div>
			<label for="avg">평균</label>
			<input type="text" id="avg" name="avg">
		</div>
		<div>
			<label></label>
			<input type="radio" name="ch" value="girl"> <!-- 얘는 입력이 아니라서 submit으로 value값이 넘어가지 않음. 이렇게 직접 적어줘야한다 -->
			<input type="radio" name="ch" value="boy">
		</div>
		<div>
			<select name="mobile">
				<option value="SKT">SKT</option>
				<option value="KT">KT</option>
				<option value="LG">LG</option>
			</select>
		</div>
		<div>
			<input type="checkbox" name="sports" value="soccer">
			<input type="checkbox" name="sports" value="baseball">
			<input type="checkbox" name="sports" value="basketball">
		</div>
		<div>
			<textarea rows"" cols="" name="contents"></textarea>
		</div>
		<div>
			<input type="submit" value="등록">
			<button type="submit">작성</button>
		</div>
	</form>

</body>
</html>
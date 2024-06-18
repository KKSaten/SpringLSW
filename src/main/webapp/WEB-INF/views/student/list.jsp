<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href = "/resources/css/tables.css" rel = "stylesheet">

</head>
<body>

	<h1>학생정보리스트 페이지</h1>
	
	
	<!-- <div>
		<img alt="" src="/resources/images/cat2.jpg" width = 400px height = 400px>
	</div> -->
	
	
	<table border = "1" class = "tbl">
		<thead>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>평균</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${requestScope.list}" var = "student">
				<tr>
					<td>${pageScope.student.num}</td>
					<td><a href = "./detail?num=${pageScope.student.num}">${pageScope.student.name}</a></td>
					<td>${pageScope.student.avg}</td>
				</tr>
			</c:forEach>
		</tbody>
		
	
	</table>
	
	<div>
		<a href = "./add">학생 등록</a>
	</div>

</body>
</html>
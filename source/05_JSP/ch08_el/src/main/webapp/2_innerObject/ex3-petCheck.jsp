<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet">
</head>
<body>
	<form action="ex4.jsp">
		name <input type="text" name="name"><br>
		키우는 반려동물을 선택하세요
		<input type="checkbox" name="pets" value="고양이">고양이
		<input type="checkbox" name="pets" value="앵무새">앵무새
		<input type="checkbox" name="pets" value="강아지">강아지
		<input type="checkbox" name="pets" value="거북이">거북이<br>
		<input type="submit" >
	</form>
</body>
</html>
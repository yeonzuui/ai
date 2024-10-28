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
	<!-- sol 1 -->
	<h1>회원정보(2_dispatcher 폴더 파일): request에 setAttribute한 내용</h1>
	<h2>ID ${member.id }(member.getId()를 자동호출)</h2>
	<h2>PW ${member.pw }</h2>
	<h2>name ${member.name }</h2>
	<hr>
	
	<!-- sol 2 -->
	<h1>회원정보: request의 parameter 내용</h1>
	<h2>ID ${param.id }</h2>
	<h2>PW ${param.pw }</h2>
	<h2>name ${param.name }</h2>
</body>
</html>
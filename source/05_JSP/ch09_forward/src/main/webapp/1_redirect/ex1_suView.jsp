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
	<h2>1_redirect 폴더 파일입니다</h2>
	<h2>1부터 ${param.su }까지 누적합은 ${param.sum }입니다</h2>
	<!-- suInput에서 실행하면 Servlet 파일로 감 -->
</body>
</html>
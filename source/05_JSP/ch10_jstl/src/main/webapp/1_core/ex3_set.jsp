<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet">
</head>
<body>
	<h3>변수 선언과 출력과 삭제</h3>
	<!-- scope 생략 시 page scope, default값 (해당 페이지에서만 유효) -->
	<c:set var="varName" value="varValue" scope="page"/> <!-- 변수 선언 -->
	varName: ${varName } <br>
	<c:set var="varName" value="XXX" />
	varName(수정한 후 변수): ${varName } <br>
	<!-- varName 변수 삭제 -->
	<c:remove var="varName" />
	varName(삭제한 후 변수): ${varName } <br> <!-- null값도 "" 출력 -->
	varName(삭제한 후 변수): <c:out value="${varName }" default="삭제된 변수"/> <br>
</body>
</html>
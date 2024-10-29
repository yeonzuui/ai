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
	<!-- 변수 선언  -->
	<c:set var="n1"     value="${param.n1 }"/>
	<c:set var="n2"     value="${param.n2 }"/>
	<c:set var="result" value="${param.result }"/>
	<c:if test="${empty result }">
		<h2>정답을 입력하세요</h2>
	</c:if>
	<c:if test="${result eq n1*n2 }">
		<h2> 정답 </h2>
	</c:if>
	<c:if test="${result != n1*n2 &&  not empty result }">
		<h2> 오~~답 </h2>
	</c:if>
</body>
</html>
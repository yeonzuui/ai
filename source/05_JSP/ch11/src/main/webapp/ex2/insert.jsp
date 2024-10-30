<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/ex.css" rel="stylesheet">
</head>
<body>
	<h1>insert.jsp 파일입니다</h1>
	<h3>insert 결과: ${insertResult eq 1 ? "insert 성공" : "insert 실패" }</h3>
	<button onclick="location.href='${conPath}/select.do'">목록가기</button>
</body>
</html>
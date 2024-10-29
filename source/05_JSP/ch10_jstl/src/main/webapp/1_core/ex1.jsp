
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet">
</head>
<body>
	<!-- custom tag 사용하기 위해서는 먼저 선언 -->
	<h2>core 라이브러리 태그: if, forEach, set, ...</h2>
	<%
		for(int i=1 ; i<=3 ; i++){
			out.print(i + "번째 안녕하세요<br>");
		}
	%>
	<c:forEach var="i" begin="1" end="3" step="1">
		${i }번째 안녕하세요<br>
	</c:forEach>
	<h2>fmt(formatting)라이브러리: 날짜나 숫자 format</h2>
	<!-- java.util에 있는 Date() import -->
	<%
	Date now = new Date(System.currentTimeMillis());
	request.setAttribute("now", now);
	%>
	<fmt:formatDate value="${now }" pattern="YY"/>
	<fmt:formatNumber value="356356.356" pattern="#,###.##"></fmt:formatNumber>
	<h2>그 외 라이브러리(functions): el표기법과 함께 사용</h2>
	id 파라미터를 대문자로: ${fn:toUpperCase(param.id) }
	id 파라미터를 대문자로: ${param.id.toUpperCase() }
</body>
</html>
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
	<%
		String[] names = {"홍길동", "김길동", "신길동"};
		for(String name: names){
			out.println("<p>" + name + "<p>");
		}
		for(int idx=0 ; idx<names.length ; idx++){
			out.println("<p>" + idx + "번째 " + names[idx] + "</p>");
		}
		// 자바 측에서 뷰단에 출력할 내용을 setAttribute
		request.setAttribute("names", names);
	%>
	<hr>
	<h4>확장 for문 역할</h4>
	<c:forEach var="name" items="${names }">
		<p>${name }</p>
	</c:forEach>
	<h4>일반 for문 역할</h4>
	<!-- idx 변수에 0으로 초기화하여 선언 -->
	<c:set var="idx" value="0"/> <!-- /로 닫는 태그 대체 가능 -->
	<c:forEach var="name" items="${names }">
		<p>${idx }번째 ${name }</p>
		<c:set var="idx" value="${idx + 1 }"/> <!-- idx 변수를 재선언: idx += 1 -->
	</c:forEach>
	<h4>for문 끝까지 수행하지 않고 특정 횟수만 실행 </h4>
	<c:forEach var="name" items="${names }" begin="0" end="1"> <!-- 배열의 0방부터 1방까지 -->
		<p>${name }</p>
	</c:forEach>
	<h4>5번 반복하는 for문</h4>
	<c:forEach begin="1" end="5">
		<p>안녕하세요</p>
	</c:forEach>
</body>
</html>
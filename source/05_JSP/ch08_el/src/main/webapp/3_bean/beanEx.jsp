<%@page import="com.lec.dto.Friend"%>
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
	<%
		// MVC패턴에서는 자바에서 구현될 소스는 자바에서 구현
		Friend friend = new Friend(1, "홍길동", "010-9999-9999");
		request.setAttribute("friend", friend);
	%>
	<h2>친구정보 (el표기법)</h2>
	<h2>값 null이면 error 아닌 빈 스트링 출력</h2>
	<h3>friend: ${friend }</h3><!-- toString -->
	<h3>순번: ${friend.no }(getNo 자동 호출)</h3>
	<h3>이름: ${friend.name }(getName 자동 호출)</h3>
	<h3>전화번호: ${friend.tel }(getTel 자동 호출)</h3>
</body>
</html>
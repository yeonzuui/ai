<%@page import="com.lec.ex.dto.Person"%>
<%@page import="com.lec.ex.dao.PersonRepository"%>
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
	<%
		String name    = null, 
			   tel     = null,
			   address = null,
			   memo    = null;
		PersonRepository dao = PersonRepository.getInstance();
		for(int i=101 ; i<=220 ; i++){
			name = "홍길" + i;
			tel  = "010-1111-1" + i;
			address = "서울시 관악구 신림로 " + i;
			memo = "안녕하쇼 " + i;
			int result = dao.insertPerson(new Person(0, name, tel, address, null, memo, null));
			System.out.println(result == 1 ? i+"번째 성공" : i+"번째 실패");
		}
		response.sendRedirect("../list.do");
	%>
</body>
</html>
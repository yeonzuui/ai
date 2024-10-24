<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <% String conPath = request.getContextPath(); %> --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<%-- <link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">  --%>
</head> 
<body>
	<%-- 지시자: page 속성, include, taglib(9장에서) --%>
	<%
		int[] arr = {1,2,3};
		// Arrays import 필수
		out.print(Arrays.toString(arr));
	%>
	<hr>
	<% // footer include %>
	<!-- JSP 표준 액션 태그에서의 include: jsp를 실행한 결과 html을 include -->
	<jsp:include page="../main/footer.jsp"/> 
	<hr>
	<!-- include 지시자 : jsp를 include-->
	<%@ include file="../main/footer.jsp" %>
	<hr>
	다시 ex2_지시자로 옴 - 끝 -
</body>
</html>
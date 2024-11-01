<%@page import="com.lec.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script>
		$(document).ready(function(){
			
		}); 
	</script>
</head>
<body>
<%
	String id = request.getParameter("id");
	MemberDao dao = MemberDao.getInstance();
	int cnt = dao.getCountMember(id);
	if(cnt == MemberDao.MEMBER_EXISTENT){
		out.print("<b>중복된 ID입니다</b>");
	}else{
		out.print("사용 가능한 ID입니다");
	}
%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">  
</head>
<body>
	<%
		String name   = request.getParameter("name");
		String number = request.getParameter("number");
		
		if(!name.equals("name")){
			name.trim();
		}else if(!number.isEmpty()){
			int numberParam = Integer.parseInt(number);
			int sum = 0; 
			for(int i=1 ; i<=numberParam ; i++) {
				sum += i;
			}
			out.print("1부터" + number + "까지 누적합은" + sum + "입니다");
		}
	%>
</body>
</html>
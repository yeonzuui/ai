<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
	<%
		String name   = request.getParameter("name");
		String number = request.getParameter("number");
	%>  
</head>
<body>
	<form action="" method="get">
		<fieldset>
			<legend>입력</legend>
			<p>
				이름
				<input type="text" name="name" value=<%=name==null ? "" : name.trim() %>>
			</p>
			<p>
				숫자
				<input type="text" name="number" value=<%=number==null ? "" : number %>>
			</p>
			<p><input type="submit" value="누적"></p>
		</fieldset>
		<%
			if(number != null && !number.equals("")){
				int numberParam = Integer.parseInt(number);
				int sum = 0; 
				for(int i=1 ; i<=numberParam ; i++) {
					sum += i;
				}
				out.print("<style>h2{color:red;}</style>");
				out.print("<h2>1부터 " + number + "까지 누적합은 " + sum + "입니다</h2>");
			}
			
		%>
	</form>
</html>
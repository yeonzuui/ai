<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% // 스크립트릿은 java 코드
		long result = power(2, 10);
	%>
	<p>2의 10승은 <%=result %>입니다</p>
	<p>9의 10승은 <%=power(9, 10) %>입니다</p>
	
	<%! // java 선언부(우선적으로 최초 1회 실행됨)
		private long power(int a, int b){ // a의 b승을 return
			long result = 1;
			for(int i=1 ; i<=b ; i++){
				result *= a;
			}//for
			return result;
		}
	%>
</body>
</html>
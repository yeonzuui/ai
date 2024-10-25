<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.net.ConnectException"%>
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
<%! // 선언부 아무데나 위치해도 됨
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String uid    = "scott";
	String upw    = "tiger";
%> 
<table>
<%
	Connection conn = null;
	Statement  stmt = null;
	ResultSet  rs   = null;
	String     sql  = "SELECT * FROM EMP";
	try{
		Class.forName(driver); // 1단계: 드라이버로드(jsp에서는 생략 불가능)
		conn = DriverManager.getConnection(url, uid, upw); // 2단계: DB연결
		stmt = conn.createStatement(); // 3단계: SQL전송 객체
		rs   = stmt.executeQuery(sql);
		if(rs.next()){ // sql문 전송 결과가 1행 이상 있을 때
			out.print("<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th>");
			out.print("    <th>입사일</th><th>급여</th><th>상여</th><th>부서번호</th></tr>");
			do{
				// rs내용 출력
				int       empno    = rs.getInt("empno");
				String    ename    = rs.getString("ename");
				String    job      = rs.getString("job");
				int       mgr      = rs.getInt("mgr"); // DB의 null데이터는 int로 받을 시 0
				Date      hiredate = rs.getDate("hiredate"); // 날짜만 받음(시간은 안 받음)
				Timestamp hire2    = rs.getTimestamp("hiredate"); // 날짜와 시간을 다 받음
				String    hire3    = rs.getString("hiredate"); // DB출력된 정보를 문자열로(비추)
				int       sal      = rs.getInt("sal");
				int       comm     = rs.getInt("comm");
				int       deptno   = rs.getInt("deptno");
				out.print("<tr><td>" + empno + "</td>");
				out.print("    <td>" + ename + "</td>");
				out.print("    <td>" + job + "</td>");
				out.print("    <td>" + (mgr==0?"CEO":mgr) + "</td>");
				out.print("    <td>" + hiredate + " " + hire2 + "</td>");
				out.print("    <td>" + sal + "</td>");
				out.print("    <td>" + comm + "</td>");
				out.print("    <td>" + deptno + "</td>" + "");
			}while(rs.next());
		}else{
			out.print("<tr><td>입력된 사원정보가 없습니다</td></tr>");
		}
		out.println("<h2>DB 연결 성공</h2>");
	}catch(Exception e){
		System.out.println(e.getMessage());
	}finally{
		try{ // 닫는 순서 거꾸로
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}catch(Exception e){
			System.out.println(e.getMessage());			
		}
	}
	
	
	
	
	
	
	
	
	
	
%>
</table>
</body>
</html>













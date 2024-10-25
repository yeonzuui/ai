<%@page import="org.apache.tomcat.dbcp.dbcp2.DriverManagerConnectionFactory"%>
<%@page import="java.sql.*"%>
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
<%!
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String uid    = "scott";
	String upw    = "tiger";
%>
<body>
	<form action="ex2_deptnoEmpOut.jsp">
		<p>
			<select name="deptno">
				<option></option> <%-- 빈스트링(전체부서정보) --%>
				<%
				Connection conn = null;
				Statement  stmt = null;
				ResultSet  rs   = null;
				String sql = "SELECT * FROM DEPT";
				try{
					Class.forName(driver); // (1)
					conn = DriverManager.getConnection(url, uid, upw); // (2)
					stmt = conn.createStatement(); // (3)
					rs = stmt.executeQuery(sql); // (4)+(5)
					 // (6) rs.next() 받아서 <option value="10">10-ACCOUNTNG</option>" 출력
					while(rs.next()){
						int deptno = rs.getInt("deptno");
						String dname = rs.getString("dname");
						out.print("<option value='" + deptno + "'>");
						out.print(deptno + "-" + dname);
						out.print("</option>");
					}
				}catch(Exception e){
					System.out.println(e.getMessage());
				}finally{
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close();
				}
				%>
			</select>
			<input type="submit" value="검색">
		</p>
	</form>
</body>
</html>










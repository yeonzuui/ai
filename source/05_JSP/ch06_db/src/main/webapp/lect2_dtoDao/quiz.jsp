<%@page import="javax.naming.directory.SearchControls"%>
<%@page import="com.lec.dto.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.EmpRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">  
	<style>
		window.onload = () => {
			document.querySelector('input[name="ename"]').onkeyup = function(){
				document.querySelector('form').submit();
			};
		};
	</style>
</head>
<% // parameter 받기
	String ename = request.getParameter("ename");
	//공백제거
	if(ename != null){
		ename = ename.trim().toUpperCase();				
	}
%>
<body>
	<form action="" >
		<p>
			<input type="text" name="searchName" value=<%=ename==null ? "" : ename %>>
			<input type="submit" value="검색">
		</p>
	</form>
	<table> <%-- 출력내용 --%>
			<% 
			// Repository 변수 생성
			EmpRepository empRepository = EmpRepository.getInstance();
			// ArrayList 생성
			ArrayList<Emp> empList = empRepository.empListBySearchName(ename);
			// 제목
			out.print("<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th>");
			out.print("    <th>입사일</th><th>급여</th><th>상여</th><th>부서번호</th></tr>");
			
			if(!empList.isEmpty()){ // 또는 empList.size()!=0
				for(Emp emp:empList){
					out.print("<tr><td>" +  emp.getEmpno()    +  "</td>");
					out.print("    <td>" +  emp.getEname()    +  "</td>");
					out.print("    <td>" +  emp.getJob()      +  "</td>");
					out.print("    <td>" +  (emp.getMgr()==0 ? "CEO" :emp.getMgr()) +  "</td>");
					out.print("    <td>" +  emp.getHiredate() +  "</td>");
					out.print("    <td>" +  emp.getSal()      +  "</td>");
					out.print("    <td>" +  emp.getComm()     +  "</td>");
					out.print("    <td>" +  emp.getDeptno()   +  "</td></tr>");
				} // for
			}else{
				// colspan='cnt': cnt개만큼의 열을 병합하여 1개의 셀로 나타냄
				out.print("<tr><td colspan='8'>해당 부서번호의 사람은 없습니다</td></tr>");
			}
		%>
		</table>
</body>
</html>
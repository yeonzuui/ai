package com.lec.ex6prepareStatement;

import java.sql.*;
import java.util.Scanner;

// com.lec.ex2selectWhere.Ex2 + Ex3_selectWhereDname 같은 기능
// 부서명을 입력 받아 해당 부서정보를 출력하고, 해당부서 사원(사번, 이름, 급여, 급여순)을 출력
public class Ex3_selectWhereDname {
	// SQL문 먼저 작성
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 주소
		Scanner scanner = new Scanner(System.in); // scanner 변수 생성
		// conn, pstmt, rs 변수 생성
		Connection        conn = null;
		PreparedStatement pstmt = null;
		ResultSet         rs = null;
		String deptSql = "SELECT * FROM DEPT WHERE DNAME = UPPER(?)"; // single quotation mark 삭제
		String empSql = "SELECT EMPNO, ENAME, SAL "
				+ "    FROM EMP E, DEPT D"
				+ "    WHERE E.DEPTNO = D.DEPTNO AND DNAME = UPPER(?)"
				+ "    ORDER BY SAL";
		try {
			//-------------------------함수------------------------------
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(deptSql);
			System.out.println("출력을 원하는 부서명은 > ");
			String dname = scanner.next();
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery(); 
			//-------------------------만들기------------------------------
			if(rs.next()) { // 부서가 있는 경우
				System.out.println("부서번호 : " + rs.getInt("deptno"));
				System.out.println("부서명 : " + dname);
				System.out.println("부서위치 : " + rs.getString("loc"));
				System.out.println(); // 개행
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(empSql);
				pstmt.setString(1, dname);
				rs = pstmt.executeQuery();
				if(rs.next()) { // 사원이 있는 경우
					System.out.println("사번\t이름\t급여");
					do {
						int    empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int    sal   = rs.getInt("sal");
						System.out.println(empno + "\t" + ename + "\t" + sal);
					}while(rs.next());
				}else {
					System.out.println(dname + "부서의 사원정보를 찾을 수 없습니다.");
				} // if-else(사원)
			}else {
				System.out.println("입력하신 부서를 찾을 수 없습니다.");
			} // if-else(부서)
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		} // try-catch
	} // main
} // class


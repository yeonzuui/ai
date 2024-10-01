package com.lec.ex3insert;

import java.sql.*;
import java.util.Scanner;

// 입력받은 부서번호 중복체크후, 부서명, 근무지를 입력받아 insert
public class InsertDeptConfirm {
	// SQL문 먼저 만들기
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 주소
		Scanner    scanner = new Scanner(System.in);
		Connection conn    = null;
		Statement  stmt    = null;
		ResultSet  rs      = null; // 중복체크 결과 반환할 거니까 ResultSet 필요
		System.out.print("입력할 부서번호는 >");
		int deptno = scanner.nextInt();
		// deptno 중복 체크
		String confirmSql = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO =" + deptno;
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs   = stmt.executeQuery(confirmSql);
			rs.next();
			int cnt = rs.getInt(1); // 1번째 열을 가져옴
			if(cnt == 0) {
				// insert 수행
				System.out.print("입력할 부서명은 >");
				String dname = scanner.next();
				System.out.print("입력할 부서위치는 >");
				String loc = scanner.next();
				String insertSql = String.format("INSERT INTO DEPT"
						+ "    VALUES (%d, UPPER('%s'), UPPER('%s'))", deptno, dname, loc);
				int result = stmt.executeUpdate(insertSql); // executeUpdate: insert할 때
				if(result>0) {
					System.out.println("입력성공");
				}
			}else {
				System.out.println("중복된 부서번호는 입력 불가합니다.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try { // 7. 연결해제
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}

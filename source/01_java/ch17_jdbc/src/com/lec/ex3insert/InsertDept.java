package com.lec.ex3insert;

import java.sql.*;
import java.util.Scanner;

// 사용자에게 부서번호, 부서명, 부서위치를 입력받아 insert
public class InsertDept {
	// SQL문 먼저 만들기
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 주소
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		// ResultSet 필요없음 SELECT로 결과 출력할 거 아니니까
		System.out.print("입력할 부서번호는 >");
		int deptno = scanner.nextInt();
		System.out.print("입력할 부서명은 >");
		String dname = scanner.next();
		System.out.print("입력할 부서위치는 >");
		String loc = scanner.next();
		String sql = String.format("INSERT INTO DEPT "
				+ "    VALUES (%d, UPPER('%s'), UPPER('%s'))", deptno, dname, loc); // ctrl + shift + x 대문자로 변환
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql); // 자바는 결과를 '몇' 행 삽입했는지 숫자로 받아
			System.out.println(result > 0 ? "입력성공" : "입력실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "sql문 오류거나 중복된 부서번호");
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
